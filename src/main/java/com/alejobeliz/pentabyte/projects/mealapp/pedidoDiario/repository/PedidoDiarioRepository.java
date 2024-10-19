package com.alejobeliz.pentabyte.projects.mealapp.pedidoDiario.repository;

import com.alejobeliz.pentabyte.projects.mealapp.pedidoDiario.PedidoDiario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoDiarioRepository extends JpaRepository<PedidoDiario,Long> {
    @Query("""
        SELECT pd
        FROM PedidoDiario pd
        WHERE pd.pedidoSemanal.id = :id
        """)
    List<PedidoDiario> findPedidoDiasByPedidoId(@Param("id") Long id);
}
