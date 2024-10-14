package com.alejobeliz.pentabyte.projects.mealapp.service;

import com.alejobeliz.pentabyte.projects.mealapp.dto.out.DetalleDiarioDto;
import com.alejobeliz.pentabyte.projects.mealapp.dto.out.DiasLaboralesDto;
import com.alejobeliz.pentabyte.projects.mealapp.dto.out.MenuSemanalDto;
import com.alejobeliz.pentabyte.projects.mealapp.dto.out.PlatoCompletoDto;
import com.alejobeliz.pentabyte.projects.mealapp.model.cliente.dto.ClienteDiasLaboralesDto;
import com.alejobeliz.pentabyte.projects.mealapp.repository.*;
import jakarta.persistence.EntityNotFoundException;
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
    public PageService(PedidoRepository pedidoRepository,
                       ClienteRepository clienteRepository,
                       DisponibilidadSemanalRepository disponibilidadSemanalRepository,
                       FavoritoRepository favoritoRepository,
                       PlatoRepository platoRepository) {
        this.clienteRepository = clienteRepository;
        this.disponibilidadSemanalRepository = disponibilidadSemanalRepository;
        this.favoritoRepository = favoritoRepository;
        this.platoRepository = platoRepository;
    }

  /*  public MenuSemanalDto getMenuSemanal(Long idCliente, Pageable paginacion) {
        List<DiasLaboralesDto> diasLaboralesDtos = getDiasLaborales(idCliente);
        String primerDiaLaboralActivo = diasLaboralesDtos.stream().filter(dia -> dia.activo()).map(dia -> dia.dia()).findFirst().get();

        LocalDate inicioDeSemana = LocalDate.now().with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));

        Page<PlatoCompletoDto> platosPrincipalesDelDia = platoRepository.getPlatoDtoByClienteIdAndInicioDeSemanaAndDiaAndTipoDePlato(idCliente, inicioDeSemana, primerDiaLaboralActivo.toLowerCase(), "Principal", paginacion);

        List<MenuSemanalDto.DetalleDiarioDto> detallesDiarios = new ArrayList<>();
        MenuSemanalDto.DetalleDiarioDto
                detalleDiarioDto = new MenuSemanalDto.DetalleDiarioDto(primerDiaLaboralActivo, platosPrincipalesDelDia);
        detallesDiarios.add(detalleDiarioDto);
        MenuSemanalDto menuSemanalDto = new MenuSemanalDto(idCliente, diasLaboralesDtos, detallesDiarios);

        return menuSemanalDto;
    }*/

    public MenuSemanalDto getMenuSemanal(Long idCliente, Pageable paginacion) {
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

        Page<PlatoCompletoDto> platosPrincipalesDelDia = platoRepository.getPlatoDtoByClienteIdAndInicioDeSemanaAndDiaAndTipoDePlato(idCliente, inicioDeSemana, primerDiaLaboralActivo.toLowerCase(), "Principal", paginacion);

        DetalleDiarioDto detalleDiarioDto = new DetalleDiarioDto(primerDiaLaboralActivo, platosPrincipalesDelDia);
        List<DetalleDiarioDto> detallesDiarios = new ArrayList<>();
        detallesDiarios.add(detalleDiarioDto);
        MenuSemanalDto menuSemanalDto = new MenuSemanalDto(idCliente, diasLaboralesDtos, detallesDiarios);

        return menuSemanalDto;
    }


    private List<DiasLaboralesDto> getDiasLaborales(Long idCliente) {
        ClienteDiasLaboralesDto diasLaboralesDB = clienteRepository.findDiasLaboralesById(idCliente).orElseThrow(() -> new EntityNotFoundException("No se encuentra el cliente con id: " + idCliente));

        DiasLaboralesDto lunes = new DiasLaboralesDto("Lunes", diasLaboralesDB.lunes());
        DiasLaboralesDto martes = new DiasLaboralesDto("Martes", diasLaboralesDB.martes());
        DiasLaboralesDto miercoles = new DiasLaboralesDto("Miercoles", diasLaboralesDB.miercoles());
        DiasLaboralesDto jueves = new DiasLaboralesDto("Jueves", diasLaboralesDB.jueves());
        DiasLaboralesDto viernes = new DiasLaboralesDto("Viernes", diasLaboralesDB.viernes());

        List<DiasLaboralesDto> diasLaboralesDtos = new ArrayList<>();
        diasLaboralesDtos.add(lunes);
        diasLaboralesDtos.add(martes);
        diasLaboralesDtos.add(miercoles);
        diasLaboralesDtos.add(jueves);
        diasLaboralesDtos.add(viernes);
        return diasLaboralesDtos;
    }
}
