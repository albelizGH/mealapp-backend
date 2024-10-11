package com.alejobeliz.pentabyte.projects.mealapp.dto.out;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PlatoCompletoDto(
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
