package com.alejobeliz.pentabyte.projects.mealapp.plato.controller;

import com.alejobeliz.pentabyte.projects.mealapp.infra.security.SecurityContextService;
import com.alejobeliz.pentabyte.projects.mealapp.pedidoDiario.dto.DetalleDiarioDto;
import com.alejobeliz.pentabyte.projects.mealapp.plato.dto.PlatoDto;
import com.alejobeliz.pentabyte.projects.mealapp.plato.service.PlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/platos")
public class PlatoController {

    private PlatoService platoService;
    private SecurityContextService securityContextService;

    @Autowired
    public PlatoController(PlatoService platoService, SecurityContextService securityContextService) {
        this.platoService = platoService;
        this.securityContextService = securityContextService;
    }

    @GetMapping()
    public List<PlatoDto> getPlatos(){
        return platoService.getAllPlatos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlatoDto> getPlato(@PathVariable Long id) {
        PlatoDto platoDto = platoService.getPlato(id);
        return ResponseEntity.ok(platoDto);
    }

    @GetMapping("/disponibles")
    public ResponseEntity<DetalleDiarioDto> getPlatosPorDiaYTipo(@RequestParam String dia, @RequestParam String tipoDePlato, @PageableDefault(size = 10,sort = "id", direction = Sort.Direction.ASC) Pageable paginacion){
        Long idCliente = securityContextService.getIdDeUsuarioDesdeAuthenticated();
        DetalleDiarioDto detalle = platoService.getDetalleDiario(idCliente,dia,tipoDePlato,paginacion);
        return ResponseEntity.ok(detalle);
    }


}

