package com.alejobeliz.pentabyte.projects.mealapp.controller;

import com.alejobeliz.pentabyte.projects.mealapp.dto.in.PedidoSemanalDtoIn;
import com.alejobeliz.pentabyte.projects.mealapp.dto.out.PedidoSemanalDto;
import com.alejobeliz.pentabyte.projects.mealapp.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private PedidoService pedidoService;

    @Autowired
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    /*METODOS GET*/

    @GetMapping("cliente/{idCliente}/ultimo")
    public ResponseEntity<PedidoSemanalDto> getPedidoProximaSemana(@PathVariable Long idCliente) {
        PedidoSemanalDto pedido = pedidoService.getPedidoProximaSemana(idCliente);
        return ResponseEntity.ok(pedido);
    }


    /*METODOS POST*/

    @PostMapping
    @Transactional
    public ResponseEntity crearPedidoSemanal(@RequestBody @Valid PedidoSemanalDtoIn pedido) {
        pedidoService.crearNuevoPedido(pedido);
        return ResponseEntity.ok(pedido);
    }

    /*METODOS DELETE*/
    @DeleteMapping("cliente/{idCliente}/ultimo")
    @Transactional
    public ResponseEntity eliminarUltimoPedido(@PathVariable Long idCliente) {
        pedidoService.eliminarUlitmoPedido(idCliente);
        return ResponseEntity.noContent().build();
    }



}
