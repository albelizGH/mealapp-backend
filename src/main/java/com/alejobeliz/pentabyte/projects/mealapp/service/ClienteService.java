package com.alejobeliz.pentabyte.projects.mealapp.service;

import com.alejobeliz.pentabyte.projects.mealapp.model.cliente.dto.ClienteDatosPersonalesDto;
import com.alejobeliz.pentabyte.projects.mealapp.model.cliente.dto.ClienteDiasLaboralesDto;
import com.alejobeliz.pentabyte.projects.mealapp.model.cliente.dto.ClienteDto;
import com.alejobeliz.pentabyte.projects.mealapp.model.cliente.Cliente;
import com.alejobeliz.pentabyte.projects.mealapp.repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    //FIJARME POR QUE NO ANDA EL PAGEAB
    public List<ClienteDto> getAllClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream()
                .map(cliente -> new ClienteDto(
                        cliente.getId().toString(),
                        cliente.getNombre(),
                        cliente.getApellido(),
                        cliente.getDocumento(),
                        new ClienteDiasLaboralesDto(cliente)
                ))
                .collect(Collectors.toList());
    }

    public ClienteDto getCliente(Long id) {
        ClienteDto clienteDto=clienteRepository.findById(id)
                .map(ClienteDto::new)
                .orElseThrow(()->new EntityNotFoundException("No se encuentra el cliente con id: " + id));
        return clienteDto;
    }

    public ClienteDiasLaboralesDto getDiasLaborales(Long id){
        return clienteRepository.findDiasLaboralesById(id).orElseThrow(()->new EntityNotFoundException("No se encuentra el cliente con id: " + id));
    }

    public ClienteDatosPersonalesDto getDatosPersoanles(Long id) {
        return clienteRepository.findDatosPersonalesById(id).orElseThrow(()->new EntityNotFoundException("No se encuentra el cliente con id: " + id));
    }

    @Transactional
    public ClienteDiasLaboralesDto setDiasLaborales(Long id, ClienteDiasLaboralesDto diasLaborales) {
        Cliente clienteDb = clienteRepository.getClienteById(id).orElseThrow(()->new EntityNotFoundException("No se encuentra el cliente con id: " + id));
        modificarDiasLaborales(clienteDb,diasLaborales);
        clienteRepository.save(clienteDb);
        return  new ClienteDiasLaboralesDto(clienteDb);
        }
















    private void modificarDiasLaborales(Cliente cliente, ClienteDiasLaboralesDto diasLaboralesDto) {
        cliente.setLunes(diasLaboralesDto.lunes());
        cliente.setMartes(diasLaboralesDto.martes());
        cliente.setMiercoles(diasLaboralesDto.miercoles());
        cliente.setJueves(diasLaboralesDto.jueves());
        cliente.setViernes(diasLaboralesDto.viernes());
    }

    private void modificarDatosPersonales(Cliente cliente, ClienteDatosPersonalesDto datosPersonalesDto) {
        if (datosPersonalesDto.nombre() != null) {
            cliente.setNombre(datosPersonalesDto.nombre().trim());
        }
        if (datosPersonalesDto.apellido() != null) {
            cliente.setApellido(datosPersonalesDto.apellido().trim());
        }
        if (datosPersonalesDto.documento() != null) {
            cliente.setDocumento(datosPersonalesDto.documento().trim());
        }
    }

    public ClienteDatosPersonalesDto setDatosPersonales(Long id, ClienteDatosPersonalesDto datosPersonales) {
        Cliente clienteDb = clienteRepository.getClienteById(id).orElseThrow(()->new EntityNotFoundException("No se encuentra el cliente con id: " + id));
        modificarDatosPersonales(clienteDb,datosPersonales);
        clienteRepository.save(clienteDb);
        return new ClienteDatosPersonalesDto(clienteDb);
    }
}
