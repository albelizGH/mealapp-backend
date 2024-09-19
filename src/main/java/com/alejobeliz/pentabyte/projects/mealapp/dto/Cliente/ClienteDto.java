package com.alejobeliz.pentabyte.projects.mealapp.dto.Cliente;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ClienteDto(String id,
                         String nombre,
                         String apellido,
                         String documento,
                         Boolean lunes,
                         Boolean martes,
                         Boolean miercoles,
                         Boolean jueves,
                         Boolean viernes) {
}
