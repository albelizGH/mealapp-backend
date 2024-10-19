package com.alejobeliz.pentabyte.projects.mealapp.detalleDePedido.dto;

import com.alejobeliz.pentabyte.projects.mealapp.detalleDePedido.DetalleDePedido;
import com.alejobeliz.pentabyte.projects.mealapp.plato.Plato;

public record DetallePedidoDto(
        Long id,
        String nombrePlato,
        String tipoPlato,
        String comentario,
        Integer cantidad
) {
    public DetallePedidoDto(DetalleDePedido detalleDePedido, Plato plato){
        this(detalleDePedido.getId(),plato.getNombre(),plato.getTipoDePlato().getNombre(), detalleDePedido.getComentario(), detalleDePedido.getCantidad());
    }
}
