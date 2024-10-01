package com.alejobeliz.pentabyte.projects.mealapp.model.pedido.validaciones;

import com.alejobeliz.pentabyte.projects.mealapp.model.pedido.Pedido;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

@Component
public class ValidarFechaDePedido implements ValidadorDePedidos {
    // Inyecto mis variables guardadas en el application.properties
    @Value("${mealapp.pedido.fecha.apertura.dia}")
    private DayOfWeek diaApertura;
    @Value("${mealapp.pedido.fecha.apertura.hora}")
    private int horaApertura;
    @Value("${mealapp.pedido.fecha.apertura.minutos}")
    private int minutosApertura;

    @Value("${mealapp.pedido.fecha.cierre.dia}")
    private DayOfWeek diaCierre;
    @Value("${mealapp.pedido.fecha.cierre.hora}")
    private int horaCierre;
    @Value("${mealapp.pedido.fecha.cierre.minutos}")
    private int minutosCierre;

    @Override
    public void validar(Pedido pedido) {
        // Verificar el horario para ver si se puede crear el pedido
        LocalDateTime fechaPedido = pedido.getFechaDePedido();
        LocalDateTime ahora = LocalDateTime.now();

        // Crear el límite de apertura de pedidos (lunes a las 08:00 AM)
        LocalDateTime limiteApertura = ahora.with(TemporalAdjusters.previousOrSame(diaApertura))
                .withHour(horaApertura)
                .withMinute(minutosApertura)
                .withSecond(0)
                .withNano(0);

        // Crear el límite de cierre de pedidos (jueves a las 16:00 PM)
        LocalDateTime limiteCierre = limiteApertura.with(TemporalAdjusters.nextOrSame(diaCierre))
                .withHour(horaCierre)
                .withMinute(minutosCierre)
                .withSecond(0)
                .withNano(0);

        // Validar si el pedido está fuera del período permitido
        if (fechaPedido.isBefore(limiteApertura) || fechaPedido.isAfter(limiteCierre)) {
            throw new ValidationException("Los pedidos no pueden ser realizados o modificados el día "
                    + diaApertura.getDisplayName(TextStyle.FULL, new Locale("es", "ES"))
                    + " a las " + horaApertura + ":" + (minutosApertura == 0 ? "00" : minutosApertura) + "hs"
                    + " y el día " + diaCierre.getDisplayName(TextStyle.FULL, new Locale("es", "ES"))
                    + " a las " + horaCierre + ":" + (minutosCierre == 0 ? "00" : minutosCierre) + "hs.");
        }
    }

}
