package com.alejobeliz.pentabyte.projects.mealapp.plato.service;

import com.alejobeliz.pentabyte.projects.mealapp.pedidoDiario.dto.DetalleDiarioDto;
import com.alejobeliz.pentabyte.projects.mealapp.plato.Plato;
import com.alejobeliz.pentabyte.projects.mealapp.plato.dto.PlatoCreate;
import com.alejobeliz.pentabyte.projects.mealapp.plato.dto.PlatoDto;
import com.alejobeliz.pentabyte.projects.mealapp.plato.dto.PlatoOutDto;
import com.alejobeliz.pentabyte.projects.mealapp.plato.repository.PlatoRepository;
import com.alejobeliz.pentabyte.projects.mealapp.tipoDePlato.TipoDePlato;
import com.alejobeliz.pentabyte.projects.mealapp.tipoDePlato.repository.TipoDePlatoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlatoService {
    private final PlatoRepository platoRepository;
    private final TipoDePlatoRepository tipoDePlatoRepository;

    @Autowired
    public PlatoService(PlatoRepository platoRepository, TipoDePlatoRepository tipoDePlatoRepository) {
        this.platoRepository = platoRepository;
        this.tipoDePlatoRepository = tipoDePlatoRepository;
    }

    public List<PlatoCreate> getAllPlatos() {
        return platoRepository.findAll().stream().map(plato -> {
            return new PlatoCreate(plato.getNombre(),plato.getDescripcion(),plato.getEtiqueta(),plato.getImagen(),plato.getCantidadMaxima(),plato.getStock(),plato.getTipoDePlato().getNombre());
                })
                .collect(Collectors.toList());
    }

    public PlatoDto getPlato(Long id) {
        return platoRepository.findById(id)
                .map(PlatoDto::new)
                .orElseThrow(()->new EntityNotFoundException("No se encuentra el plato con id: " + id));
    }

    public DetalleDiarioDto getDetalleDiario(Long idCliente,String dia, String tipoDePlato, Pageable paginacion) {
        LocalDate inicioDeSemana = LocalDate.now().with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        Page<PlatoOutDto> platos = platoRepository.getPlatoDtoByClienteIdAndInicioDeSemanaAndDiaAndTipoDePlato(idCliente,inicioDeSemana,dia,tipoDePlato,paginacion);
        return new DetalleDiarioDto(dia,platos);
    }

    public void crearPlato(PlatoCreate platoCreate) {
        Plato plato = new Plato();
        plato.setNombre(platoCreate.nombre());
        plato.setDescripcion(platoCreate.descripcion());
        plato.setEtiqueta(platoCreate.etiqueta());
        plato.setImagen(platoCreate.imagen());
        plato.setCantidadMaxima(platoCreate.cantidadMaxima());
        plato.setStock(platoCreate.stock());
        TipoDePlato tipo = tipoDePlatoRepository.findByNombre(platoCreate.tipo());
        plato.setTipoDePlato(tipo);
        System.out.println(plato);
        platoRepository.save(plato);
    }
}