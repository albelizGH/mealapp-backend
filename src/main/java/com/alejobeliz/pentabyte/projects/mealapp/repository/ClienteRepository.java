package com.alejobeliz.pentabyte.projects.mealapp.repository;

import com.alejobeliz.pentabyte.projects.mealapp.model.cliente.Cliente;
import com.alejobeliz.pentabyte.projects.mealapp.model.cliente.dto.ClienteDatosPersonalesDto;
import com.alejobeliz.pentabyte.projects.mealapp.model.cliente.dto.ClienteDiasLaboralesDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {

    @Query("""
        SELECT new com.alejobeliz.pentabyte.projects.mealapp.model.cliente.dto.ClienteDiasLaboralesDto(c.lunes, c.martes, c.miercoles, c.jueves, c.viernes)
        FROM Cliente c
        WHERE c.id = :id
        """)
    Optional<ClienteDiasLaboralesDto> findDiasLaboralesById(Long id);

    @Query("""
        SELECT new com.alejobeliz.pentabyte.projects.mealapp.model.cliente.dto.ClienteDatosPersonalesDto(c.nombre, c.apellido, c.documento)
        FROM Cliente c
        WHERE c.id = :id
        """)
    Optional<ClienteDatosPersonalesDto> findDatosPersonalesById(Long id);


    @Query("""
        SELECT c
        FROM Cliente c
        WHERE c.id = :id
        """)
    Optional<Cliente> getClienteById(Long id);

    @Query("""
            SELECT c
            FROM Cliente c
            WHERE c.correo = :correo
            """)
    Optional<Cliente> findClienteByCorreo(String correo);

    @Query("""
            SELECT c.activo
            FROM Cliente c
            WHERE c.id = :id
            """)
    Boolean isActive(Long id);
}
