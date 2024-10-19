package com.alejobeliz.pentabyte.projects.mealapp.pedidoSemanal.controller;

import com.alejobeliz.pentabyte.projects.mealapp.infra.security.service.SecurityService;
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
    private final SecurityService securityService;

    @Autowired
    public PedidoController(SecurityService securityService, PedidoService pedidoService) {
        this.securityService = securityService;
        this.pedidoService = pedidoService;
    }

    /*METODOS GET*/

    @GetMapping("ultimo")
    public ResponseEntity<PedidoSemanalDto> getPedidoProximaSemana() {
        PedidoSemanalDto pedido = pedidoService.getPedidoProximaSemana(securityService.getIdDeUsuarioDesdeAuthenticated());
        return ResponseEntity.ok(pedido);
    }


    /*METODOS POST*/

    @PostMapping
    @Transactional
    public ResponseEntity crearPedidoSemanal(@RequestBody @Valid PedidoSemanalDtoIn pedido) {
        pedidoService.crearNuevoPedido(pedido,securityService.getIdDeUsuarioDesdeAuthenticated());
        return ResponseEntity.ok().build();
    }

    /*METODOS DELETE*/
    @DeleteMapping("ultimo")
    @Transactional
    public ResponseEntity eliminarUltimoPedido() {
        pedidoService.eliminarUlitmoPedido(securityService.getIdDeUsuarioDesdeAuthenticated());
        return ResponseEntity.noContent().build();
    }



}
