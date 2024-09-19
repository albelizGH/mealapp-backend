package com.alejobeliz.pentabyte.projects.mealapp.service;

import com.alejobeliz.pentabyte.projects.mealapp.dto.Cliente.ClienteDatosPersonalesDto;
import com.alejobeliz.pentabyte.projects.mealapp.dto.Cliente.ClienteDiasLaboralesDto;
import com.alejobeliz.pentabyte.projects.mealapp.dto.Cliente.ClienteDto;
import com.alejobeliz.pentabyte.projects.mealapp.mapper.Mapper;
import com.alejobeliz.pentabyte.projects.mealapp.model.cliente.Cliente;
import com.alejobeliz.pentabyte.projects.mealapp.repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;
    private Mapper mapper;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository, Mapper mapper) {
        this.clienteRepository = clienteRepository;
        this.mapper=mapper;
    }

/*    public Page<ClienteDto> getAllClientes(Pageable pageable){
        Page<Cliente> clientes = clienteRepository.findAll(pageable);
        return clientes.stream().map(cliente -> mapper.map(cliente,ClienteDto.class)).collect(Collectors.toList());
    }*/

    //FIJARME POR QUE NO ANDA EL PAGEABLE
    public List<ClienteDto> getAllClientes(){
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream().map(cliente -> mapper.map(cliente,ClienteDto.class)).collect(Collectors.toList());
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

    public ClienteDto getCliente(Long id) {
        ClienteDto clienteDto=clienteRepository.findById(id)
                .map(cliente -> mapper.map(cliente,ClienteDto.class))
                .orElseThrow(()->new EntityNotFoundException("No se encuentra el cliente con id: " + id));
        return clienteDto;
    }

    public ClienteDiasLaboralesDto getDiasLaborales(Long id){
        return clienteRepository.findDiasLaboralesById(id).orElseThrow(()->new EntityNotFoundException("No se encuentra el cliente con id: " + id));
    }
}
