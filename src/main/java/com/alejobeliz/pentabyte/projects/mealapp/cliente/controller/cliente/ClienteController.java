package com.alejobeliz.pentabyte.projects.mealapp.cliente.controller.cliente;

import com.alejobeliz.pentabyte.projects.mealapp.autenticacion.dto.CredencialesDto;
import com.alejobeliz.pentabyte.projects.mealapp.cliente.dto.ClienteDiasLaboralesDto;
import com.alejobeliz.pentabyte.projects.mealapp.cliente.dto.ClienteDto;
import com.alejobeliz.pentabyte.projects.mealapp.cliente.dto.DatosPersonalesDto;
import com.alejobeliz.pentabyte.projects.mealapp.cliente.dto.DiasLaboralesDto;
import com.alejobeliz.pentabyte.projects.mealapp.cliente.service.ClienteService;
import com.alejobeliz.pentabyte.projects.mealapp.infra.security.SecurityContextService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    private final ClienteService clienteService;
    private final SecurityContextService securityContextService;

    @Autowired
    public ClienteController(ClienteService clienteService, SecurityContextService securityContextService) {
        this.clienteService = clienteService;
        this.securityContextService = securityContextService;
    }

    /*METODOS GET*/

    @GetMapping()
    public ResponseEntity<ClienteDto> getCliente() {
        ClienteDto clienteDto = clienteService.getCliente(securityContextService.getIdDeUsuarioDesdeAuthenticated());
        return ResponseEntity.ok(clienteDto);
    }

    @GetMapping("laboral")
    public ResponseEntity<List<DiasLaboralesDto>> getDiasLaborales() {
        List<DiasLaboralesDto> clienteDiasLaboralesDto = clienteService.getDiasLaborales(securityContextService.getIdDeUsuarioDesdeAuthenticated());
        return ResponseEntity.ok(clienteDiasLaboralesDto);
    }

    @GetMapping("personal")
    public ResponseEntity<DatosPersonalesDto> getDatosPersonales() {
        DatosPersonalesDto datosPersonalesDto = clienteService.getDatosPersoanles(securityContextService.getIdDeUsuarioDesdeAuthenticated());
        return ResponseEntity.ok(datosPersonalesDto);
    }

    /*METODOS PATCH*/
    @PatchMapping("laboral")
    public ResponseEntity setDiasLaborales(@RequestBody ClienteDiasLaboralesDto diasLaborales) {
        clienteService.setDiasLaborales(securityContextService.getIdDeUsuarioDesdeAuthenticated(), diasLaborales);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("personal")
    public ResponseEntity<DatosPersonalesDto> setDatosPersonales(@RequestBody @Valid DatosPersonalesDto datosPersonales) {
        DatosPersonalesDto datosPersonalesDto = clienteService.setDatosPersonales(securityContextService.getIdDeUsuarioDesdeAuthenticated(), datosPersonales);
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

}
