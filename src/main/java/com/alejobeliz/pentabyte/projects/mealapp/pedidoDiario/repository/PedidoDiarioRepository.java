package com.alejobeliz.pentabyte.projects.mealapp.pedidoDiario.repository;

import com.alejobeliz.pentabyte.projects.mealapp.page.local.dto.PedidoPageDto;
import com.alejobeliz.pentabyte.projects.mealapp.pedidoDiario.Dia;
import com.alejobeliz.pentabyte.projects.mealapp.pedidoDiario.PedidoDiario;
import com.alejobeliz.pentabyte.projects.mealapp.pedidoSemanal.PedidoSemanal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface PedidoDiarioRepository extends JpaRepository<PedidoDiario, Long> {
    @Query("""
            SELECT pd
            FROM PedidoDiario pd
            WHERE pd.pedidoSemanal.id = :id
            """)
    List<PedidoDiario> findPedidoDiasByPedidoId(@Param("id") Long id);

    @Query("""
                SELECT new com.alejobeliz.pentabyte.projects.mealapp.page.local.dto.PedidoPageDto(
                        pd.id,
                        cl.id,
                        cl.nombre,
                        cl.apellido,
                        p.nombre,
                        p.tipoDePlato.nombre,
                        dp.cantidad,
                        dp.comentario,
                        pd.estado)
                FROM DetalleDePedido dp
                JOIN dp.pedidoDiario pd
                JOIN dp.plato p
                JOIN pd.pedidoSemanal ps
                JOIN ps.cliente cl
                WHERE pd.dia = :dia AND pd.fechaDeEntrega = :fecha
            """)
    Page<PedidoPageDto> getPedidosPorDiaFecha(Dia dia, LocalDate fecha, Pageable paginacion);

    @Query("""
                SELECT new com.alejobeliz.pentabyte.projects.mealapp.page.local.dto.PedidoPageDto(
                        pd.id,
                        cl.id,
                        cl.nombre,
                        cl.apellido,
                        p.nombre,
                        p.tipoDePlato.nombre,
                        dp.cantidad,
                        dp.comentario,
                        pd.estado)
                FROM DetalleDePedido dp
                JOIN dp.pedidoDiario pd
                JOIN dp.plato p
                JOIN pd.pedidoSemanal ps
                JOIN ps.cliente cl
                WHERE pd.fechaDeEntrega = :fecha
            """)
    Page<PedidoPageDto> getPedidosVigentes(LocalDate fecha, Pageable paginacion);

    Optional<PedidoDiario> findByPedidoSemanalAndDia(PedidoSemanal pedidoSemanal, Dia dia);

}