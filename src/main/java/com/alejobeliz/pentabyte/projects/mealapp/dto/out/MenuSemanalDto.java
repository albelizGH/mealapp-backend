package com.alejobeliz.pentabyte.projects.mealapp.dto.out;

import org.springframework.data.domain.Page;

import java.util.List;

public record MenuSemanalDto(
        Long clienteId,
        List<DiasLaboralesDto> diasLaborales,
        List<DetalleDiarioDto> detallesDiarios
) {

    public static record DetalleDiarioDto(
    String dia,
    Page<PlatoCompletoDto> platos
    ){}


}