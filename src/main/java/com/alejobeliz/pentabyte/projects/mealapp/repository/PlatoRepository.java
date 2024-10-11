package com.alejobeliz.pentabyte.projects.mealapp.repository;

import com.alejobeliz.pentabyte.projects.mealapp.dto.out.PlatoCompletoDto;
import com.alejobeliz.pentabyte.projects.mealapp.model.plato.Plato;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface PlatoRepository extends JpaRepository<Plato, Long> {

    @Query("""
            SELECT p
            FROM Plato p
            WHERE p.id=:id
            """)
    Optional<Plato> findPlatoById(Long id);

    @Query("""
    SELECT new com.alejobeliz.pentabyte.projects.mealapp.dto.out.PlatoCompletoDto(
        p.id,
        p.nombre,
        p.descripcion,
        p.etiqueta,
        p.imagen,
        p.cantidadMaxima,
        p.tipoDePlato.nombre,
        CASE WHEN f IS NOT NULL THEN true ELSE false END
    )
    FROM DisponibilidadSemanal d
    JOIN d.plato p
    LEFT JOIN Favorito f ON p.id = f.plato.id AND f.cliente.id = :clienteId
    WHERE d.semanaDeInicio = :inicioDeSemana
    AND p.tipoDePlato.nombre = :tipoDePlato
    AND CASE :dia
            WHEN 'lunes' THEN d.lunes
            WHEN 'martes' THEN d.martes
            WHEN 'miercoles' THEN d.miercoles
            WHEN 'jueves' THEN d.jueves
            WHEN 'viernes' THEN d.viernes
        END = true
""")
    Page<PlatoCompletoDto> getPlatoDtoByClienteIdAndInicioDeSemanaAndDiaAndTipoDePlato(Long clienteId, LocalDate inicioDeSemana, String dia, String tipoDePlato, Pageable pageable);


}