package com.alejobeliz.pentabyte.projects.mealapp.favorito.dto;

import com.alejobeliz.pentabyte.projects.mealapp.cliente.dto.ClienteDto;
import com.alejobeliz.pentabyte.projects.mealapp.favorito.Favorito;
import com.alejobeliz.pentabyte.projects.mealapp.plato.dto.PlatoDto;

public record FavoritoDto(Long id, ClienteDto clienteDto, PlatoDto platoDto) {
    public FavoritoDto(Favorito favorito){
        this(favorito.getId(),new ClienteDto(favorito.getCliente()), new PlatoDto(favorito.getPlato()));
    }
}
