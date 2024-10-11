package com.alejobeliz.pentabyte.projects.mealapp.repository;

import com.alejobeliz.pentabyte.projects.mealapp.model.detallepedidos.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DetallePedidoRepository extends JpaRepository<DetallePedido,Long> {
    @Query("""
        SELECT d
        FROM DetallePedido d
        WHERE d.pedidoDia.id IN :pedidoDiaIds
        """)
    List<DetallePedido> findDetallePedidosByPedidoDiaId(@Param("pedidoDiaIds") List<Long> pedidoDiaIds);

}
