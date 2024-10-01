package com.alejobeliz.pentabyte.projects.mealapp.model.pedido.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record PedidoDeLaSemanaActual(
        @JsonAlias("fecha_pedido")
    LocalDateTime fechaDePedido,
    @JsonAlias("semana_entrega")
    LocalDate semanaDeEntrega,
    String estado
) {

}
