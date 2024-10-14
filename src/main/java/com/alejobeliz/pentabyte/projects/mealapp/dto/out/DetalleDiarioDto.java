package com.alejobeliz.pentabyte.projects.mealapp.dto.out;

import org.springframework.data.domain.Page;

public record DetalleDiarioDto(String dia,
                               Page<PlatoCompletoDto> platos) {
}
