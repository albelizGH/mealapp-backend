package com.alejobeliz.pentabyte.projects.mealapp.favorito.controller;

import com.alejobeliz.pentabyte.projects.mealapp.favorito.dto.FavoritoDto;
import com.alejobeliz.pentabyte.projects.mealapp.favorito.service.FavoritoService;
import com.alejobeliz.pentabyte.projects.mealapp.infra.security.service.SecurityService;
import com.alejobeliz.pentabyte.projects.mealapp.plato.dto.PlatoOutDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/cliente/favoritos")
public class FavoritoController {

    private final FavoritoService favoritoService;
    private final SecurityService securityService;

    @Autowired
    public FavoritoController(FavoritoService favoritoService, SecurityService securityService) {
        this.favoritoService = favoritoService;
        this.securityService = securityService;
    }

    @GetMapping()
    public ResponseEntity<List<PlatoOutDto>> getFavorites() {
        List<PlatoOutDto> platos = favoritoService.getFavoritesById(securityService.getIdDeUsuarioDesdeAuthenticated());
        return ResponseEntity.ok(platos);
    }

    @PostMapping()
    public ResponseEntity crearFavorito(@RequestParam Long idPlato, UriComponentsBuilder uriComponentsBuilder) throws URISyntaxException {
        FavoritoDto favorito = favoritoService.agregarPlatoAFavoritos(securityService.getIdDeUsuarioDesdeAuthenticated(), idPlato);
        URI uri = uriComponentsBuilder.path("/api/favoritos/{id}").buildAndExpand(favorito.id()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping()
    public ResponseEntity borrarFavorito(@RequestParam Long idPlato){
        favoritoService.borrarFavorito(securityService.getIdDeUsuarioDesdeAuthenticated(), idPlato);
        return ResponseEntity.noContent().build();
    }

}
