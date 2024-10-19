package com.alejobeliz.pentabyte.projects.mealapp.pedidoDiario.dto;

import com.alejobeliz.pentabyte.projects.mealapp.plato.dto.PlatoOutDto;
import org.springframework.data.domain.Page;

public record DetalleDiarioDto(String dia,
                               Page<PlatoOutDto> platos) {
}
