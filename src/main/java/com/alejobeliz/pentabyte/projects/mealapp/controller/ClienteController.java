package com.alejobeliz.pentabyte.projects.mealapp.controller;

import com.alejobeliz.pentabyte.projects.mealapp.dto.Cliente.ClienteDiasLaboralesDto;
import com.alejobeliz.pentabyte.projects.mealapp.dto.Cliente.ClienteDto;
import com.alejobeliz.pentabyte.projects.mealapp.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{id}")
    public ResponseEntity<ClienteDto> getCliente(@PathVariable Long id) {
        ClienteDto clienteDto = clienteService.getCliente(id);
        return ResponseEntity.ok(clienteDto);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public ResponseEntity<List<ClienteDto>> getAllClientes() {
        List<ClienteDto> clientes = clienteService.getAllClientes();
        return ResponseEntity.ok(clientes);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/laboral/{id}")
    public ResponseEntity<ClienteDiasLaboralesDto> getDiasLaborales(@PathVariable Long id) {
        ClienteDiasLaboralesDto clienteDiasLaboralesDto = clienteService.getDiasLaborales(id);
        return ResponseEntity.ok(clienteDiasLaboralesDto);
    }
}
