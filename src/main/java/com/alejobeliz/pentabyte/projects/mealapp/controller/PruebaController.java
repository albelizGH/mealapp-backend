package com.alejobeliz.pentabyte.projects.mealapp.controller;

import com.alejobeliz.pentabyte.projects.mealapp.model.detallepedidos.DetallePedido;
import com.alejobeliz.pentabyte.projects.mealapp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("prueba")
public class PruebaController {

    @Autowired
    DetallePedidoRepository detallePedidoRepository;
    @Autowired
    PedidoRepository pedidoRepository;
    @Autowired
    DisponibilidadSemanalRepository disponibilidadSemanalRepository;
    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    FavoritoRepository favoritoRepository;
    @Autowired
    TipoDePlatoRepository tipoDePlatoRepository;
    @Autowired
    PlatoRepository platoRepository;

    @GetMapping("/detalle")
    public List<DetallePedido> getDetalles() {
        return detallePedidoRepository.findAll();
    }

}
