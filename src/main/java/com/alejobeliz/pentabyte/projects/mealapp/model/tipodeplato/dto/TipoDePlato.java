package com.alejobeliz.pentabyte.projects.mealapp.model.tipodeplato.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public record TipoDePlato(
        Long id,
        String nombre
) {
}