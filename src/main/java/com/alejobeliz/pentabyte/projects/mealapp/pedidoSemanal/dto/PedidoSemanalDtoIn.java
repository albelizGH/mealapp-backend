package com.alejobeliz.pentabyte.projects.mealapp.pedidoSemanal.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;
public record PedidoSemanalDtoIn(
        Long id,
        @Size(min = 1, message = "Debe agregar al menos la comida de un día.")
        List<ComidaPorDia> comidasPorDia
        ) {
            public record ComidaPorDia(
                    @NotBlank(message = "El día es requerido")
                    String dia,
                    @Size(min = 1,max = 3, message = "Tiene que elegir al menos un plato al dia.")
                    List<DetallePedido> detalles
                ) {
                    public record DetallePedido(
                            @NotNull(message = "El id es requerido")
                            Long platoId,
                            @Min(value = 1, message = "La cantidad debe ser al menos 1.")
                            int cantidad,
                            String comentario
                    ) {}
                }
}
