package com.alejobeliz.pentabyte.projects.mealapp.repository;

import com.alejobeliz.pentabyte.projects.mealapp.model.pedidodia.PedidoDia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PedidoDiaRepository extends JpaRepository<PedidoDia,Long> {
    @Query("""
        SELECT pd
        FROM PedidoDia pd
        WHERE pd.pedido.id = :id
        """)
    List<PedidoDia> findPedidoDiasByPedidoId(@Param("id") Long id);
}
