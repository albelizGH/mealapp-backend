package com.alejobeliz.pentabyte.projects.mealapp.plato.dto;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotBlank;

public record PlatoCreate(
        @NotBlank
        String nombre,
        @NotBlank
        String descripcion,
        @NotBlank
        String etiqueta,
        String imagen,
        @Nonnull
        Integer cantidadMaxima,
        Integer stock,
        @NotBlank
        String tipo
) {
}
