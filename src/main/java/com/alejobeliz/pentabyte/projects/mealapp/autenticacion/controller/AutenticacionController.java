package com.alejobeliz.pentabyte.projects.mealapp.autenticacion.controller;

import com.alejobeliz.pentabyte.projects.mealapp.autenticacion.dto.CredencialesDto;
import com.alejobeliz.pentabyte.projects.mealapp.autenticacion.service.AutenticacionService;
import com.alejobeliz.pentabyte.projects.mealapp.cliente.dto.ClienteDto;
import com.alejobeliz.pentabyte.projects.mealapp.cliente.dto.RegistroCliente;
import com.alejobeliz.pentabyte.projects.mealapp.cliente.service.ClienteService;
import com.alejobeliz.pentabyte.projects.mealapp.infra.security.TokenAcceso;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AutenticacionController {


    private ClienteService clienteService;
    private AutenticacionService autenticacionService;

    @Autowired
    public AutenticacionController(ClienteService clienteService, AutenticacionService autenticacionService) {
        this.clienteService = clienteService;
        this.autenticacionService = autenticacionService;
    }

    @PostMapping(name = "registro")
    public ResponseEntity<ClienteDto> registrarCliente(@RequestBody @Valid RegistroCliente nuevoCliente) {
        ClienteDto cliente = clienteService.registrarCliente(nuevoCliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    @PostMapping("login")
    public ResponseEntity autenticarUsuario(@RequestBody @Valid CredencialesDto credenciales) {
        TokenAcceso token = autenticacionService.autenticarLogin(credenciales);
        return ResponseEntity.ok(token);

    }


}

