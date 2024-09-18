package com.alejobeliz.pentabyte.projects.mealapp.controller;

import com.alejobeliz.pentabyte.projects.mealapp.model.pedido.Pedido;
import com.alejobeliz.pentabyte.projects.mealapp.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    PedidoRepository pedidoRepository;

    @GetMapping
    public List<Pedido> getPedidos(){
        return pedidoRepository.findAll();
    }
}
