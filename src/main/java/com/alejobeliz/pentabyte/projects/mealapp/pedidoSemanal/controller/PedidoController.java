package com.alejobeliz.pentabyte.projects.mealapp.pedidoSemanal.controller;

import com.alejobeliz.pentabyte.projects.mealapp.infra.security.SecurityContextService;
import com.alejobeliz.pentabyte.projects.mealapp.pedidoSemanal.dto.PedidoSemanalDtoIn;
import com.alejobeliz.pentabyte.projects.mealapp.pedidoSemanal.dto.PedidoSemanalDto;
import com.alejobeliz.pentabyte.projects.mealapp.pedidoSemanal.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cliente/pedidos")
public class PedidoController {

    private PedidoService pedidoService;
    private final SecurityContextService securityContextService;

    @Autowired
    public PedidoController(SecurityContextService securityContextService, PedidoService pedidoService) {
        this.securityContextService = securityContextService;
        this.pedidoService = pedidoService;
    }

    /*METODOS GET*/

    @GetMapping("ultimo")
    public ResponseEntity<PedidoSemanalDto> getPedidoProximaSemana() {
        PedidoSemanalDto pedido = pedidoService.getPedidoProximaSemana(securityContextService.getIdDeUsuarioDesdeAuthenticated());
        return ResponseEntity.ok(pedido);
    }


    /*METODOS POST*/

    @PostMapping
    @Transactional
    public ResponseEntity crearPedidoSemanal(@RequestBody @Valid PedidoSemanalDtoIn pedido) {
        pedidoService.crearNuevoPedido(pedido, securityContextService.getIdDeUsuarioDesdeAuthenticated());
        return ResponseEntity.ok().build();
    }

    /*METODOS DELETE*/
    @DeleteMapping("ultimo")
    @Transactional
    public ResponseEntity eliminarUltimoPedido() {
        pedidoService.eliminarUlitmoPedido(securityContextService.getIdDeUsuarioDesdeAuthenticated());
        return ResponseEntity.noContent().build();
    }



}
