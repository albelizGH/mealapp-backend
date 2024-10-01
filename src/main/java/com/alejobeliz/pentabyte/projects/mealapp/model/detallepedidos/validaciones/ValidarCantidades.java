package com.alejobeliz.pentabyte.projects.mealapp.model.detallepedidos.validaciones;

import com.alejobeliz.pentabyte.projects.mealapp.model.detallepedidos.DetallePedido;
import com.alejobeliz.pentabyte.projects.mealapp.model.plato.Plato;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class ValidarCantidades implements ValidadorDeDetallesDePedidos {

    @Override
    public void validar(DetallePedido detallePedido,Plato plato) {
        if(detallePedido.getCantidad()>plato.getCantidadMaxima()){
            throw new ValidationException("La cantidad del plato " + plato.getNombre() + " supera la cantidad máxima permitida de "+plato.getCantidadMaxima()+".");
        }
    }
}
