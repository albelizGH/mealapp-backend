package com.alejobeliz.pentabyte.projects.mealapp.favorito.service;

import com.alejobeliz.pentabyte.projects.mealapp.plato.dto.PlatoOutDto;
import com.alejobeliz.pentabyte.projects.mealapp.cliente.Cliente;
import com.alejobeliz.pentabyte.projects.mealapp.favorito.Favorito;
import com.alejobeliz.pentabyte.projects.mealapp.favorito.dto.FavoritoDto;
import com.alejobeliz.pentabyte.projects.mealapp.plato.Plato;
import com.alejobeliz.pentabyte.projects.mealapp.cliente.repository.ClienteRepository;
import com.alejobeliz.pentabyte.projects.mealapp.favorito.repository.FavoritoRepository;
import com.alejobeliz.pentabyte.projects.mealapp.plato.repository.PlatoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FavoritoService {

    private final FavoritoRepository favoritoRepository;
    private final ClienteRepository clienteRepository;
    private final PlatoRepository platoRepository;

    @Autowired
    public FavoritoService(FavoritoRepository favoritoRepository, ClienteRepository clienteRepository, PlatoRepository platoRepository) {
        this.favoritoRepository = favoritoRepository;
        this.clienteRepository = clienteRepository;
        this.platoRepository = platoRepository;
    }

    public List<PlatoOutDto> getFavoritesById(Long idCliente) {
        Cliente clienteDb = clienteRepository.getClienteById(idCliente).get();
        return favoritoRepository.findAllByClienteId(idCliente).stream().map(plato -> new PlatoOutDto(plato.getId(),plato.getNombre(),plato.getDescripcion(),plato.getEtiqueta(),plato.getImagen(),plato.getCantidadMaxima(),plato.getTipoDePlato().getNombre().toString(),true)).collect(Collectors.toUnmodifiableList());
    }

    @Transactional
    public FavoritoDto agregarPlatoAFavoritos(Long idCliente, Long idPlato){
        Cliente clienteDb = clienteRepository.getClienteById(idCliente).get();
        Plato platoDb = platoRepository.findPlatoById(idPlato).orElseThrow(() -> new EntityNotFoundException("No se encuentra el plato con id: " + idPlato));
        Optional<Favorito> favoritoDb = favoritoRepository.findFavoritoByClienteIdAndId(idCliente,idPlato);
        if(favoritoDb.isPresent()){
           throw new  EntityNotFoundException("El plato con id " + idPlato+" ya se encuentra en favoritos");
        }
        Favorito favorito = new Favorito(clienteDb,platoDb);
        favoritoRepository.save(favorito);
        return new FavoritoDto(favorito);
    }

    @Transactional
    public void borrarFavorito(Long idCliente, Long idPlato) {
        Cliente clienteDb = clienteRepository.getClienteById(idCliente).orElseThrow(() -> new EntityNotFoundException("No se encuentra el cliente con id: " + idCliente));
        Plato platoDb = platoRepository.findPlatoById(idPlato).orElseThrow(() -> new EntityNotFoundException("No se encuentra el plato con id: " + idPlato));
        Favorito favorito = favoritoRepository.findFavoritoByClienteIdAndId(idCliente,idPlato).orElseThrow(() -> new EntityNotFoundException("El plato con id " + idPlato+" no se encuentra en favoritos"));
        favoritoRepository.delete(favorito);
    }
}
/*.orElseThrow(()->new EntityNotFoundException("No se encuentra el plato con el id: " + id)));*/