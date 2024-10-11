package com.alejobeliz.pentabyte.projects.mealapp.repository;

import com.alejobeliz.pentabyte.projects.mealapp.model.pedido.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Query("""
            SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END
                FROM Pedido p
                WHERE p.cliente.id = :idCliente AND p.semanaDeEntrega = :fecha
            """)
    boolean existePedidoConEsaFecha(Long idCliente, LocalDate fecha);


    @Query("""
            SELECT p
                FROM Pedido p
                WHERE p.cliente.id = :idCliente AND p.semanaDeEntrega = :fecha
            """)
    Optional<Pedido> PedidoConFecha(Long idCliente, LocalDate fecha);

}