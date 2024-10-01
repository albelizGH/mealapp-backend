package com.alejobeliz.pentabyte.projects.mealapp.model.detallepedidos.validaciones;

import com.alejobeliz.pentabyte.projects.mealapp.model.detallepedidos.DetallePedido;
import com.alejobeliz.pentabyte.projects.mealapp.model.plato.Plato;

public interface ValidadorDeDetallesDePedidos {
    void validar(DetallePedido detallePedido, Plato plato);
}
