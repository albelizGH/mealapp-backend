package com.alejobeliz.pentabyte.projects.mealapp.disponibilidad.controller;

import com.alejobeliz.pentabyte.projects.mealapp.disponibilidad.service.DisponibilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/local/disponibilidad")
public class DisponibilidadController {

    private DisponibilidadService disponibilidadService;

    @Autowired
    public DisponibilidadController(DisponibilidadService disponibilidadService) {
        this.disponibilidadService = disponibilidadService;
    }



}
