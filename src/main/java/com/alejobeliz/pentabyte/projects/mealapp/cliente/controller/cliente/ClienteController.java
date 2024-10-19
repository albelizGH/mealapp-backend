package com.alejobeliz.pentabyte.projects.mealapp.cliente.controller.cliente;

import com.alejobeliz.pentabyte.projects.mealapp.autenticacion.dto.CredencialesDto;
import com.alejobeliz.pentabyte.projects.mealapp.cliente.dto.*;
import com.alejobeliz.pentabyte.projects.mealapp.cliente.service.ClienteService;
import com.alejobeliz.pentabyte.projects.mealapp.infra.security.service.SecurityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    private final ClienteService clienteService;
    private final SecurityService securityService;

    @Autowired
    public ClienteController(ClienteService clienteService,SecurityService securityService) {
        this.clienteService = clienteService;
        this.securityService=securityService;
    }

    /*METODOS GET*/

    @GetMapping()
    public ResponseEntity<ClienteDto> getCliente() {
        ClienteDto clienteDto = clienteService.getCliente(securityService.getIdDeUsuarioDesdeAuthenticated());
        return ResponseEntity.ok(clienteDto);
    }

    @GetMapping("laboral")
    public ResponseEntity<List<DiasLaboralesDto>> getDiasLaborales() {
        List<DiasLaboralesDto> clienteDiasLaboralesDto = clienteService.getDiasLaborales(securityService.getIdDeUsuarioDesdeAuthenticated());
        return ResponseEntity.ok(clienteDiasLaboralesDto);
    }

    @GetMapping("personal")
    public ResponseEntity<DatosPersonalesDto> getDatosPersonales() {
        DatosPersonalesDto datosPersonalesDto = clienteService.getDatosPersoanles(securityService.getIdDeUsuarioDesdeAuthenticated());
        return ResponseEntity.ok(datosPersonalesDto);
    }

    /*METODOS PATCH*/
    @PatchMapping("laboral")
    public ResponseEntity setDiasLaborales(@RequestBody ClienteDiasLaboralesDto diasLaborales) {
        clienteService.setDiasLaborales(securityService.getIdDeUsuarioDesdeAuthenticated(), diasLaborales);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("personal")
    public ResponseEntity<DatosPersonalesDto> setDatosPersonales(@RequestBody @Valid DatosPersonalesDto datosPersonales) {
        DatosPersonalesDto datosPersonalesDto = clienteService.setDatosPersonales(securityService.getIdDeUsuarioDesdeAuthenticated(), datosPersonales);
        return ResponseEntity.ok(datosPersonalesDto);
    }

    @PatchMapping("activar")
    @Transactional
    public ResponseEntity<ClienteDto> activarCliente(@RequestBody @Valid CredencialesDto credenciales) {
        ClienteDto clienteActivado = clienteService.activarCliente(credenciales);
        return ResponseEntity.ok(clienteActivado);
    }

    @PatchMapping("desactivar")
    @Transactional
    public ResponseEntity desactivarCliente(@RequestBody @Valid CredencialesDto credenciales) {
        clienteService.desactivarCliente(credenciales);
        return ResponseEntity.noContent().build();
    }

    /*METODOS POST*/
    @PostMapping
    public ResponseEntity<ClienteDto> registrarCliente(@RequestBody @Valid RegistroCliente nuevoCliente) {
        ClienteDto cliente = clienteService.registrarCliente(nuevoCliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

}
