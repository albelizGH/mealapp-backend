package com.alejobeliz.pentabyte.projects.mealapp.tipoDePlato.repository;

import com.alejobeliz.pentabyte.projects.mealapp.tipoDePlato.TipoDePlato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDePlatoRepository extends JpaRepository<TipoDePlato,Long> {
}
