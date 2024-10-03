package com.alejobeliz.pentabyte.projects.mealapp.model.plato.dto;

import com.alejobeliz.pentabyte.projects.mealapp.model.plato.Plato;

public record PlatoCardDto(
        Long id,
        String nombre,
        String etiqueta,
        String imagen
) {
    public PlatoCardDto {
    }

    public PlatoCardDto(Plato plato) {
        this(plato.getId(),
                plato.getNombre(),
                plato.getEtiqueta(),
                plato.getImagen());
    }
}
