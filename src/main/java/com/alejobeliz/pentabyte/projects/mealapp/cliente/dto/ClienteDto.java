package com.alejobeliz.pentabyte.projects.mealapp.cliente.dto;

import com.alejobeliz.pentabyte.projects.mealapp.cliente.Cliente;
import com.alejobeliz.pentabyte.projects.mealapp.cliente.mapper.ClienteMapper;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ClienteDto(String nombre,
                         String apellido,
                         String documento,
                         List<DiasLaboralesDto> diasLaborales) {

    public ClienteDto(Cliente cliente) {
        this(   cliente.getNombre(),
                cliente.getApellido(),
                cliente.getDocumento(),
                new ClienteMapper().mapearAListaDiasLAboralesDto(cliente));
    }

    public ClienteDto {
    }


}
