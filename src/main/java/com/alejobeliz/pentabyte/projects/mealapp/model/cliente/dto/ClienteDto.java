package com.alejobeliz.pentabyte.projects.mealapp.model.cliente.dto;

import com.alejobeliz.pentabyte.projects.mealapp.model.cliente.Cliente;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ClienteDto(String id,
                         String nombre,
                         String apellido,
                         String documento,
                         ClienteDiasLaboralesDto laboral) {

    public ClienteDto(Cliente cliente) {
        this(cliente.getId().toString(),cliente.getNombre(),cliente.getApellido(),cliente.getDocumento(),new ClienteDiasLaboralesDto(cliente));
    }

    public ClienteDto {
    }
}
