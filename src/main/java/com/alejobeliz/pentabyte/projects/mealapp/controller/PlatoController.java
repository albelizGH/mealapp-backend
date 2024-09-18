package com.alejobeliz.pentabyte.projects.mealapp.controller;

import com.alejobeliz.pentabyte.projects.mealapp.model.plato.Plato;
import com.alejobeliz.pentabyte.projects.mealapp.repository.PlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/platos")
public class PlatoController {

    @Autowired
    PlatoRepository platoRepository;

    @GetMapping()
    public List<Plato> getPlatos(){
        return platoRepository.findAll();
    }


    @GetMapping("/{id}")
    public Plato obtenerPlatoporId(@PathVariable Long id) {
        Optional<Plato> platoOptional = platoRepository.findById(id);
        if (!platoOptional.isPresent()) {
            throw new RuntimeException("No hay plato que correspondan a ese Id");
        }
        return platoOptional.get();
    }

}

