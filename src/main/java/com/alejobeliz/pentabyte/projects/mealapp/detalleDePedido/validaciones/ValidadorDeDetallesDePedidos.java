package com.alejobeliz.pentabyte.projects.mealapp.detalleDePedido.validaciones;

import com.alejobeliz.pentabyte.projects.mealapp.detalleDePedido.DetalleDePedido;
import com.alejobeliz.pentabyte.projects.mealapp.plato.Plato;

public interface ValidadorDeDetallesDePedidos {
    void validar(DetalleDePedido detalleDePedido, Plato plato);
}
