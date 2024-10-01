package com.alejobeliz.pentabyte.projects.mealapp.model.pedidodia;

import com.alejobeliz.pentabyte.projects.mealapp.model.detallepedidos.dto.DetallePedidoDto;

import java.util.List;

public record PedidoDiaDto(
        Long id,
        String dia,
        List<DetallePedidoDto> detalles
) {
}
