package com.alejobeliz.pentabyte.projects.mealapp.repository;

import com.alejobeliz.pentabyte.projects.mealapp.model.disponibilidadsemanal.DisponibilidadSemanal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisponibilidadSemanalRepository extends JpaRepository<DisponibilidadSemanal,Long> {
}
