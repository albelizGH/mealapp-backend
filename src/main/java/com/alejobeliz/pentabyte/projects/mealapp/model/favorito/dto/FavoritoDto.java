package com.alejobeliz.pentabyte.projects.mealapp.model.favorito.dto;

import com.alejobeliz.pentabyte.projects.mealapp.model.cliente.dto.ClienteDto;
import com.alejobeliz.pentabyte.projects.mealapp.model.favorito.Favorito;
import com.alejobeliz.pentabyte.projects.mealapp.model.plato.dto.PlatoDto;

public record FavoritoDto(Long id, ClienteDto clienteDto, PlatoDto platoDto) {
    public FavoritoDto(Favorito favorito){
        this(favorito.getId(),new ClienteDto(favorito.getCliente()), new PlatoDto(favorito.getPlato()));
    }
}
