package com.alejobeliz.pentabyte.projects.mealapp.pedidoDiario;

import com.alejobeliz.pentabyte.projects.mealapp.detalleDePedido.dto.DetallePedidoDto;

import java.time.LocalDate;
import java.util.List;

public record PedidoDiaDto(
        Long id,
        String dia,
        LocalDate fechaDeEntrega,
        List<DetallePedidoDto> detalles
) {
}