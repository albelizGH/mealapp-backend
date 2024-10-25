package com.alejobeliz.pentabyte.projects.mealapp.disponibilidad.service;

import com.alejobeliz.pentabyte.projects.mealapp.disponibilidad.repository.DisponibilidadSemanalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DisponibilidadService {

    private DisponibilidadSemanalRepository disponibilidadSemanalRepository;

    @Autowired
    public DisponibilidadService(DisponibilidadSemanalRepository disponibilidadSemanalRepository) {
        this.disponibilidadSemanalRepository = disponibilidadSemanalRepository;
    }

}
