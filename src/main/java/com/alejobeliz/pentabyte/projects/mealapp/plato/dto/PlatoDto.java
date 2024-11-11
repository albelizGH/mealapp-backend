package com.alejobeliz.pentabyte.projects.mealapp.plato.dto;

import com.alejobeliz.pentabyte.projects.mealapp.plato.Plato;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PlatoDto(
        Long id,
        String nombre,
        String descripcion,
        String etiqueta,
        String imagen,
        Integer cantidadMaxima,
        String tipo,
        Integer cantidad,
        String comentario

) {
    public PlatoDto {
    }

    public PlatoDto(Plato plato) {
        this(plato.getId(),
        plato.getNombre(),
        plato.getDescripcion(),
        plato.getEtiqueta(),
        plato.getImagen(),
        plato.getCantidadMaxima(),
        plato.getTipoDePlato().getNombre(),
        0,"");
    }

}
