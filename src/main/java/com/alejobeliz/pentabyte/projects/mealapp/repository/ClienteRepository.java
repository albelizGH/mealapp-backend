package com.alejobeliz.pentabyte.projects.mealapp.repository;

import com.alejobeliz.pentabyte.projects.mealapp.dto.Cliente.ClienteDiasLaboralesDto;
import com.alejobeliz.pentabyte.projects.mealapp.model.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {

    @Query("""
            Select new com.alejobeliz.pentabyte.projects.mealapp.dto.Cliente.ClienteDiasLaboralesDto(c.lunes, c.martes, c.miercoles, c.jueves, c.viernes) 
            From Cliente c 
            where c.id = :id
            """)
    Optional<ClienteDiasLaboralesDto> findDiasLaboralesById(Long id);
}
