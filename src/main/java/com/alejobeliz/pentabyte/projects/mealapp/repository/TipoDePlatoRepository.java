package com.alejobeliz.pentabyte.projects.mealapp.repository;

import com.alejobeliz.pentabyte.projects.mealapp.model.tipodeplato.TipoDePlato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoDePlatoRepository extends JpaRepository<TipoDePlato,Long> {
}