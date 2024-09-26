package com.alejobeliz.pentabyte.projects.mealapp.controller;

import com.alejobeliz.pentabyte.projects.mealapp.model.cliente.dto.ClienteDatosPersonalesDto;
import com.alejobeliz.pentabyte.projects.mealapp.model.cliente.dto.ClienteDiasLaboralesDto;
import com.alejobeliz.pentabyte.projects.mealapp.model.cliente.dto.ClienteDto;
import com.alejobeliz.pentabyte.projects.mealapp.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    /*METODOS GET*/

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("{id}")
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
    @GetMapping("{id}/laboral")
    public ResponseEntity<ClienteDiasLaboralesDto> getDiasLaborales(@PathVariable Long id) {
        ClienteDiasLaboralesDto clienteDiasLaboralesDto = clienteService.getDiasLaborales(id);
        return ResponseEntity.ok(clienteDiasLaboralesDto);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("{id}/personal")
    public ResponseEntity<ClienteDatosPersonalesDto> getDatosPersonales(@PathVariable Long id) {
        ClienteDatosPersonalesDto clienteDatosPersonalesDto = clienteService.getDatosPersoanles(id);
        return ResponseEntity.ok(clienteDatosPersonalesDto);
    }

    /*METODOS PATCH*/
    @PatchMapping("{id}/laboral")
    public ResponseEntity<ClienteDiasLaboralesDto> setDiasLaborales(@PathVariable Long id, @RequestBody ClienteDiasLaboralesDto diasLaborales){
        ClienteDiasLaboralesDto clienteDiasLaboralesDto = clienteService.setDiasLaborales(id,diasLaborales);
        return ResponseEntity.ok(clienteDiasLaboralesDto);
    }

    @PatchMapping("{id}/personal")
    public ResponseEntity<ClienteDatosPersonalesDto> setDatosPersonales(@PathVariable Long id, @RequestBody @Valid ClienteDatosPersonalesDto datosPersonales){
        ClienteDatosPersonalesDto clienteDatosPersonalesDto = clienteService.setDatosPersonales(id,datosPersonales);
        return ResponseEntity.ok(clienteDatosPersonalesDto);
    }

    /*METODOS POST*/


}
