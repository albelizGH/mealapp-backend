package com.alejobeliz.pentabyte.projects.mealapp.page.service;

import com.alejobeliz.pentabyte.projects.mealapp.cliente.Cliente;
import com.alejobeliz.pentabyte.projects.mealapp.cliente.dto.DiasLaboralesDto;
import com.alejobeliz.pentabyte.projects.mealapp.cliente.mapper.ClienteMapper;
import com.alejobeliz.pentabyte.projects.mealapp.cliente.repository.ClienteRepository;
import com.alejobeliz.pentabyte.projects.mealapp.disponibilidad.repository.DisponibilidadSemanalRepository;
import com.alejobeliz.pentabyte.projects.mealapp.favorito.repository.FavoritoRepository;
import com.alejobeliz.pentabyte.projects.mealapp.page.dto.MenuSemanalDto;
import com.alejobeliz.pentabyte.projects.mealapp.pedidoDiario.dto.DetalleDiarioDto;
import com.alejobeliz.pentabyte.projects.mealapp.plato.dto.PlatoOutDto;
import com.alejobeliz.pentabyte.projects.mealapp.plato.repository.PlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class PageService {

    private ClienteRepository clienteRepository;
    private DisponibilidadSemanalRepository disponibilidadSemanalRepository;
    private FavoritoRepository favoritoRepository;
    private PlatoRepository platoRepository;

    @Autowired
    public PageService(ClienteRepository clienteRepository, DisponibilidadSemanalRepository disponibilidadSemanalRepository, FavoritoRepository favoritoRepository, PlatoRepository platoRepository) {
        this.clienteRepository = clienteRepository;
        this.disponibilidadSemanalRepository = disponibilidadSemanalRepository;
        this.favoritoRepository = favoritoRepository;
        this.platoRepository = platoRepository;
    }

    public MenuSemanalDto getMenuSemanal(Long idCliente,Pageable paginacion) {
        List<DiasLaboralesDto> diasLaboralesDtos = getDiasLaborales(idCliente);
        Optional<String> primerDiaLaboralActivoOpt = diasLaboralesDtos.stream()
                .filter(dia -> dia.activo())
                .map(dia -> dia.dia())
                .findFirst();

        // Si no hay un primer día laboral activo, devolver un array vacío en detallesDiarios
        if (!primerDiaLaboralActivoOpt.isPresent()) {
            return new MenuSemanalDto(idCliente, diasLaboralesDtos, new ArrayList<>());
        }

        String primerDiaLaboralActivo = primerDiaLaboralActivoOpt.get();
        LocalDate inicioDeSemana = LocalDate.now().with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));

        Page<PlatoOutDto> platosPrincipalesDelDia = platoRepository.getPlatoDtoByClienteIdAndInicioDeSemanaAndDiaAndTipoDePlato(idCliente, inicioDeSemana, primerDiaLaboralActivo.toLowerCase(), "Principal", paginacion);

        DetalleDiarioDto detalleDiarioDto = new DetalleDiarioDto(primerDiaLaboralActivo, platosPrincipalesDelDia);
        List<DetalleDiarioDto> detallesDiarios = new ArrayList<>();
        detallesDiarios.add(detalleDiarioDto);
        MenuSemanalDto menuSemanalDto = new MenuSemanalDto(idCliente, diasLaboralesDtos, detallesDiarios);

        return menuSemanalDto;
    }


    private List<DiasLaboralesDto> getDiasLaborales(Long idCliente) {
        Cliente clienteDb=clienteRepository.getClienteById(idCliente).get();
        return new ClienteMapper().mapearAListaDiasLAboralesDto(clienteDb);
    }
}
