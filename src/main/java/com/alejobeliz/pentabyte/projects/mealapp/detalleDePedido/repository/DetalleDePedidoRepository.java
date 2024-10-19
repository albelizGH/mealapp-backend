package com.alejobeliz.pentabyte.projects.mealapp.detalleDePedido.repository;

import com.alejobeliz.pentabyte.projects.mealapp.detalleDePedido.DetalleDePedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DetalleDePedidoRepository extends JpaRepository<DetalleDePedido,Long> {
    @Query("""
        SELECT d
        FROM DetalleDePedido d
        WHERE d.pedidoDiario.id IN :pedidoDiaIds
        """)
    List<DetalleDePedido> findDetallePedidosByPedidoDiaId(@Param("pedidoDiaIds") List<Long> pedidoDiaIds);

}
