package com.alejobeliz.pentabyte.projects.mealapp.controller;

import com.alejobeliz.pentabyte.projects.mealapp.model.plato.dto.PlatoDto;
import com.alejobeliz.pentabyte.projects.mealapp.service.PlatoService;
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

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping()
    public List<PlatoDto> getPlatos(){
        return platoService.getAllPlatos();
    }

  /*  @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/all")
    public List<PlatoCardDto> getPlatosPorTipo(@RequestParam(defaultValue = "Plato") String tipo){
        return platoService.getAllPlatos();
    }*/


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{id}")
    public ResponseEntity<PlatoDto> getCliente(@PathVariable Long id) {
        PlatoDto platoDto = platoService.getPlato(id);
        return ResponseEntity.ok(platoDto);
    }

    /*METODOS PATCH*/

    //Hacer metodo para agregar o quitar de favoritos

}

