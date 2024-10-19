package com.alejobeliz.pentabyte.projects.mealapp.pedidoSemanal.dto;

import com.alejobeliz.pentabyte.projects.mealapp.pedidoDiario.PedidoDiaDto;

import java.util.List;

public record PedidoSemanalDto(
        Long id,
        String fechaDePedido,
        List<PedidoDiaDto> comidasPorDia
) {
}
