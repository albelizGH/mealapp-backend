package com.alejobeliz.pentabyte.projects.mealapp.page.local.dto;

import com.alejobeliz.pentabyte.projects.mealapp.pedidoDiario.Estado;

public record PedidoPageDto(
        Long pedidoId,
        Long clienteId,
        String nombreCliente,
        String apellidoCliente,
        String nombrePlato,
        String tipo,
        Integer cantidad,
        String comentario,
        Estado estado
) {

}