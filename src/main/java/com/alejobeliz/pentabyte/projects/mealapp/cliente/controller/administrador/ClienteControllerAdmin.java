package com.alejobeliz.pentabyte.projects.mealapp.cliente.controller.administrador;

import com.alejobeliz.pentabyte.projects.mealapp.cliente.dto.ClienteDto;
import com.alejobeliz.pentabyte.projects.mealapp.cliente.service.ClienteService;
import com.alejobeliz.pentabyte.projects.mealapp.infra.security.SecurityContextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/administrador/clientes")
public class ClienteControllerAdmin {

    private final ClienteService clienteService;
    private final SecurityContextService securityContextService;

    @Autowired
    public ClienteControllerAdmin(ClienteService clienteService, SecurityContextService securityContextService) {
        this.clienteService = clienteService;
        this.securityContextService = securityContextService;
    }

    /*METODOS GET*/

    @GetMapping("{id}")
    public ResponseEntity<ClienteDto> getCliente(@PathVariable Long id) {
        ClienteDto clienteDto = clienteService.getCliente(id);
        return ResponseEntity.ok(clienteDto);
    }

    @GetMapping
    public ResponseEntity<List<ClienteDto>> getAllClientes() {
        List<ClienteDto> clientes = clienteService.getAllClientes();
        return ResponseEntity.ok(clientes);
    }

    /*METODOS DELETE*/
    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity borrarCliente(@PathVariable Long id) {
        clienteService.borrarCliente(securityContextService.getIdDeUsuarioDesdeAuthenticated());
        return ResponseEntity.noContent().build();
    }

}
