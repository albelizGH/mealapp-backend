package com.alejobeliz.pentabyte.projects.mealapp.dto.out;

import com.alejobeliz.pentabyte.projects.mealapp.model.pedido.Estado;
import com.alejobeliz.pentabyte.projects.mealapp.model.pedidodia.PedidoDiaDto;

import java.util.List;

public record PedidoSemanalDto(
        Long id,
        String fechaDePedido,
        Estado estado,
        List<PedidoDiaDto> comidasPorDia
) {
}
