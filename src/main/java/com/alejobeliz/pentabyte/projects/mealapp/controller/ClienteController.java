package com.alejobeliz.pentabyte.projects.mealapp.controller;

import com.alejobeliz.pentabyte.projects.mealapp.dto.ClienteDto;
import com.alejobeliz.pentabyte.projects.mealapp.mapper.ClienteMapper;
import com.alejobeliz.pentabyte.projects.mealapp.model.cliente.Cliente;
import com.alejobeliz.pentabyte.projects.mealapp.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private ClienteRepository clienteRepository;
    private ClienteMapper clienteMapper;

    @Autowired
    public ClienteController(ClienteRepository clienteRepository,ClienteMapper clienteMapper) {
        this.clienteRepository=clienteRepository;
        this.clienteMapper=clienteMapper;

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{id}")
    public ClienteDto getDetallesCliente(@PathVariable Long id) {

        Optional<Cliente> clienteOpcional = clienteRepository.findById(id);

        if (!clienteOpcional.isPresent()) {
            throw new RuntimeException("No hay plato que correspondan a ese Id");
        }
        return clienteMapper.clienteToClienteDto(clienteOpcional.get());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public List<ClienteDto> getAllCliente() {
        return clienteRepository.findAll().stream().map(cliente -> clienteMapper.clienteToClienteDto(cliente)).collect(Collectors.toList());
    }
}
