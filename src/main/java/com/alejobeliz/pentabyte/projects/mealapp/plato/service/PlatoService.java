package com.alejobeliz.pentabyte.projects.mealapp.plato.service;

import com.alejobeliz.pentabyte.projects.mealapp.pedidoDiario.dto.DetalleDiarioDto;
import com.alejobeliz.pentabyte.projects.mealapp.plato.dto.PlatoDto;
import com.alejobeliz.pentabyte.projects.mealapp.plato.dto.PlatoOutDto;
import com.alejobeliz.pentabyte.projects.mealapp.plato.repository.PlatoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlatoService {
    private final PlatoRepository platoRepository;

    @Autowired
    public PlatoService(PlatoRepository platoRepository) {
        this.platoRepository = platoRepository;
    }

    public List<PlatoDto> getAllPlatos() {
        return platoRepository.findAll().stream().map(PlatoDto::new)
                .collect(Collectors.toList());
    }

    public PlatoDto getPlato(Long id) {
        PlatoDto platoDto=platoRepository.findById(id)
                .map(PlatoDto::new)
                .orElseThrow(()->new EntityNotFoundException("No se encuentra el plato con id: " + id));
        return platoDto;
    }

    public DetalleDiarioDto getDetalleDiario(Long idCliente,String dia, String tipoDePlato, Pageable paginacion) {
        LocalDate inicioDeSemana = LocalDate.now().with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        Page<PlatoOutDto> platos = platoRepository.getPlatoDtoByClienteIdAndInicioDeSemanaAndDiaAndTipoDePlato(idCliente,inicioDeSemana,dia,tipoDePlato,paginacion);
        return new DetalleDiarioDto(dia,platos);
    }
}