package com.alejobeliz.pentabyte.projects.mealapp.controller;

import com.alejobeliz.pentabyte.projects.mealapp.dto.out.PlatoCompletoDto;
import com.alejobeliz.pentabyte.projects.mealapp.model.favorito.dto.FavoritoDto;
import com.alejobeliz.pentabyte.projects.mealapp.service.FavoritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/favoritos")
public class FavoritoController {

    private final FavoritoService favoritoService;

    @Autowired
    public FavoritoController(FavoritoService favoritoService) {
        this.favoritoService = favoritoService;
    }

    @GetMapping("/cliente/{idCliente}")
    public ResponseEntity<List<PlatoCompletoDto >> getFavorites(@PathVariable Long idCliente) {
        List<PlatoCompletoDto > platos = favoritoService.getFavoritesById(idCliente);
        return ResponseEntity.ok(platos);
    }

    @PostMapping()
    public ResponseEntity crearFavorito(@RequestParam Long idCliente, @RequestParam Long idPlato, UriComponentsBuilder uriComponentsBuilder) throws URISyntaxException {
        FavoritoDto favorito = favoritoService.agregarPlatoAFavoritos(idCliente,idPlato);
        URI uri = uriComponentsBuilder.path("/api/favoritos/{id}").buildAndExpand(favorito.id()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping()
    public ResponseEntity borrarFavorito(@RequestParam Long idCliente, @RequestParam Long idPlato){
        favoritoService.borrarFavorito(idCliente,idPlato);
        return ResponseEntity.noContent().build();
    }

}
