package com.alejobeliz.pentabyte.projects.mealapp.cliente.dto;

import com.alejobeliz.pentabyte.projects.mealapp.cliente.Cliente;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ClienteDiasLaboralesDto(Boolean lunes,
                                      Boolean martes,
                                      Boolean miercoles,
                                      Boolean jueves,
                                      Boolean viernes) {
    public ClienteDiasLaboralesDto(Cliente cliente) {
        this(cliente.getLunes(),
                cliente.getMartes(),
                cliente.getMiercoles(),
                cliente.getJueves(),
                cliente.getViernes());
    }

    public ClienteDiasLaboralesDto {
    }
}
