package com.alejobeliz.pentabyte.projects.mealapp.dto.out;

import java.util.List;

public record MenuSemanalDto(
        Long clienteId,
        List<DiasLaboralesDto> diasLaborales,
        List<DetalleDiarioDto> detallesDiarios
) {




}