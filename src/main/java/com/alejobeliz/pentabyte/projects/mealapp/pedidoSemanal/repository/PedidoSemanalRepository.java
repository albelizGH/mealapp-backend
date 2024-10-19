package com.alejobeliz.pentabyte.projects.mealapp.pedidoSemanal.repository;

import com.alejobeliz.pentabyte.projects.mealapp.pedidoSemanal.PedidoSemanal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface PedidoSemanalRepository extends JpaRepository<PedidoSemanal, Long> {

    @Query("""
            SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END
                FROM PedidoSemanal p
                WHERE p.cliente.id = :idCliente AND p.semanaDeEntrega = :fecha
            """)
    boolean existePedidoConEsaFecha(Long idCliente, LocalDate fecha);


    @Query("""
            SELECT p
                FROM PedidoSemanal p
                WHERE p.cliente.id = :idCliente AND p.semanaDeEntrega = :fecha
            """)
    Optional<PedidoSemanal> PedidoConFecha(Long idCliente, LocalDate fecha);

}