package com.alejobeliz.pentabyte.projects.mealapp.page.local.service;

import com.alejobeliz.pentabyte.projects.mealapp.page.local.dto.PedidoPageDto;
import com.alejobeliz.pentabyte.projects.mealapp.pedidoDiario.Dia;
import com.alejobeliz.pentabyte.projects.mealapp.pedidoDiario.repository.PedidoDiarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

@Service
public class PedidoPageService {

    private PedidoDiarioRepository pedidoDiarioRepository;

    @Autowired
    public PedidoPageService(PedidoDiarioRepository pedidoDiarioRepository) {
        this.pedidoDiarioRepository = pedidoDiarioRepository;
    }

    public Page<PedidoPageDto> getPedidosPorDiaFecha(Dia dia, LocalDate fecha, Pageable paginacion){
       return pedidoDiarioRepository.getPedidosPorDiaFecha(dia,fecha,paginacion);
    }

    public Page<PedidoPageDto> getPedidosVigentes(Pageable paginacion){
        LocalDate fechaActual=LocalDate.now().with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        return  pedidoDiarioRepository.getPedidosVigentes(fechaActual,paginacion);
    }


}
