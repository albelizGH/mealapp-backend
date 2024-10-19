package com.alejobeliz.pentabyte.projects.mealapp.page.dto;

import com.alejobeliz.pentabyte.projects.mealapp.cliente.dto.DiasLaboralesDto;
import com.alejobeliz.pentabyte.projects.mealapp.pedidoDiario.dto.DetalleDiarioDto;

import java.util.List;

public record MenuSemanalDto(
        Long clienteId,
        List<DiasLaboralesDto> diasLaborales,
        List<DetalleDiarioDto> detallesDiarios
) {




}