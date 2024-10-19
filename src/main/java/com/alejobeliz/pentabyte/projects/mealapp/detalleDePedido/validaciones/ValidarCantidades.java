package com.alejobeliz.pentabyte.projects.mealapp.detalleDePedido.validaciones;

import com.alejobeliz.pentabyte.projects.mealapp.detalleDePedido.DetalleDePedido;
import com.alejobeliz.pentabyte.projects.mealapp.plato.Plato;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class ValidarCantidades implements ValidadorDeDetallesDePedidos {

    @Override
    public void validar(DetalleDePedido detalleDePedido, Plato plato) {
        if(detalleDePedido.getCantidad()>plato.getCantidadMaxima()){
            throw new ValidationException("La cantidad del plato " + plato.getNombre() + " supera la cantidad máxima permitida de "+plato.getCantidadMaxima()+".");
        }
    }
}
