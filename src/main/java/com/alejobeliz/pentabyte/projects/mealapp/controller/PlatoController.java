package com.alejobeliz.pentabyte.projects.mealapp.controller;

import com.alejobeliz.pentabyte.projects.mealapp.dto.out.DetalleDiarioDto;
import com.alejobeliz.pentabyte.projects.mealapp.model.plato.dto.PlatoDto;
import com.alejobeliz.pentabyte.projects.mealapp.service.PlatoService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/platos")
public class PlatoController {

    PlatoService platoService;

    public PlatoController(PlatoService platoService) {
        this.platoService = platoService;
    }

    @GetMapping()
    public List<PlatoDto> getPlatos(){
        return platoService.getAllPlatos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlatoDto> getCliente(@PathVariable Long id) {
        PlatoDto platoDto = platoService.getPlato(id);
        return ResponseEntity.ok(platoDto);
    }

    @GetMapping("/disponibles")
    public ResponseEntity<DetalleDiarioDto> getPlatosPorDiaYTipo(@RequestParam Long idCliente, @RequestParam String dia, @RequestParam String tipoDePlato, @PageableDefault(size = 10,sort = "id", direction = Sort.Direction.ASC) Pageable paginacion){
        DetalleDiarioDto detalle = platoService.getDetalleDiario(idCliente,dia,tipoDePlato,paginacion);
        return ResponseEntity.ok(detalle);
    }

    /*METODOS PATCH*/

    //Hacer metodo para agregar o quitar de favoritos

}

