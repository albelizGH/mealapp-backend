package com.alejobeliz.pentabyte.projects.mealapp.plato.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PlatoOutDto(
        Long id,
        String nombre,
        String descripcion,
        String etiqueta,
        String imagen,
        Integer cantidadMaxima,
        String tipo,
        Boolean esFavorito
) {
}
