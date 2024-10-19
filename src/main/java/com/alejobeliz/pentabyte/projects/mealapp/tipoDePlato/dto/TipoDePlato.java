package com.alejobeliz.pentabyte.projects.mealapp.tipoDePlato.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public record TipoDePlato(
        Long id,
        String nombre
) {
}