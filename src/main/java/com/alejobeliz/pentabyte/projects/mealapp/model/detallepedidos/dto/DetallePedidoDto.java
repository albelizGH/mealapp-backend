package com.alejobeliz.pentabyte.projects.mealapp.model.detallepedidos.dto;

import com.alejobeliz.pentabyte.projects.mealapp.model.detallepedidos.DetallePedido;
import com.alejobeliz.pentabyte.projects.mealapp.model.plato.Plato;

public record DetallePedidoDto(
        Long id,
        String nombrePlato,
        String tipoPlato,
        String comentario,
        Integer cantidad
) {
    public DetallePedidoDto(DetallePedido detallePedido, Plato plato){
        this(detallePedido.getId(),plato.getNombre(),plato.getTipoDePlato().getNombre(),detallePedido.getComentario(),detallePedido.getCantidad());
    }
}
