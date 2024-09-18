package com.alejobeliz.pentabyte.projects.mealapp.controller;

import com.alejobeliz.pentabyte.projects.mealapp.model.tipodeplato.TipoDePlato;
import com.alejobeliz.pentabyte.projects.mealapp.repository.TipoDePlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tiposdeplatos")
public class TipoDePlatoController {

    @Autowired
    TipoDePlatoRepository tipoDePlatoRepository;

    @GetMapping
    public List<TipoDePlato> getTipos(){
        return tipoDePlatoRepository.findAll();
    }




}
