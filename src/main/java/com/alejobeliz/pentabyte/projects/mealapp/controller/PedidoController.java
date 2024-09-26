package com.alejobeliz.pentabyte.projects.mealapp.controller;

import com.alejobeliz.pentabyte.projects.mealapp.dto.in.PedidoSemanalDtoIn;
import com.alejobeliz.pentabyte.projects.mealapp.model.pedido.Pedido;
import com.alejobeliz.pentabyte.projects.mealapp.repository.PedidoRepository;
import com.alejobeliz.pentabyte.projects.mealapp.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private PedidoService pedidoService;

    @Autowired
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity crearPedidoSemanal(@RequestBody @Valid PedidoSemanalDtoIn pedido){
        pedidoService.crearNuevoPedido(pedido);
        return ResponseEntity.ok(pedido);
    }


}
