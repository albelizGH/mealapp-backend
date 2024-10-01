package com.alejobeliz.pentabyte.projects.mealapp.service;

import com.alejobeliz.pentabyte.projects.mealapp.model.plato.dto.PlatoDto;
import com.alejobeliz.pentabyte.projects.mealapp.mapper.Mapper;
import com.alejobeliz.pentabyte.projects.mealapp.repository.PlatoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlatoService {
    private final PlatoRepository platoRepository;

    @Autowired
    public PlatoService(PlatoRepository platoRepository, Mapper mapper) {
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
}