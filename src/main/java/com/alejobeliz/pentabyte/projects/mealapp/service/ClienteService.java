package com.alejobeliz.pentabyte.projects.mealapp.service;

import com.alejobeliz.pentabyte.projects.mealapp.dto.in.RegistroCliente;
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
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    //private final PasswordEncoder passwordEncoder; LUEGO PONER EL ENCODER DE SPRING SECURITY

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
        if(!clienteDb.getActivo()){
            throw new RuntimeException("El cliente está desactivado");
        }
        clienteDb.modificarDiasLaborales(clienteDb,diasLaborales);
        clienteRepository.save(clienteDb);
        return  new ClienteDiasLaboralesDto(clienteDb);
        }

    public ClienteDatosPersonalesDto setDatosPersonales(Long id, ClienteDatosPersonalesDto datosPersonales) {
        Cliente clienteDb = clienteRepository.getClienteById(id).orElseThrow(()->new EntityNotFoundException("No se encuentra el cliente con id: " + id));
        if(!clienteDb.getActivo()){
            throw new RuntimeException("El cliente está desactivado");
        }
        clienteDb.modificarDatosPersonales(clienteDb,datosPersonales);
        clienteRepository.save(clienteDb);
        return new ClienteDatosPersonalesDto(clienteDb);
    }

    public ClienteDto registrarCliente(RegistroCliente nuevoCliente) {
        Optional<Cliente> clienteExsitente = clienteRepository.findClienteByCorreo(nuevoCliente.correo());
        if (clienteExsitente.isPresent()) {
            throw new EntityNotFoundException("Ya existe el usuario con correo: " + nuevoCliente.correo());
        }
        String contraseniaEncriptada = nuevoCliente.contrasenia();//Aca habria que poner el metodo Encoder de spring security
        Cliente cliente = new Cliente(nuevoCliente.nombre(), nuevoCliente.apellido(), nuevoCliente.documento(), nuevoCliente.correo(), contraseniaEncriptada);
        clienteRepository.save(cliente);
        return new ClienteDto (cliente);
    }

    public void desactivarCliente(Long id) {
        Cliente clienteDb=clienteRepository.getClienteById(id).orElseThrow(()->new EntityNotFoundException("No se encuentra el cliente con id: " + id));
        clienteDb.desactivarCliente();
        //borro todos los pedidos asociados a ese cliente?
        clienteRepository.save(clienteDb);
    }


    public ClienteDto activarCliente(Long id) {
        Cliente clienteDb=clienteRepository.getClienteById(id).orElseThrow(()->new EntityNotFoundException("No se encuentra el cliente con id: " + id));
        clienteDb.activarCliente();
        clienteRepository.save(clienteDb);
        return new ClienteDto(clienteDb);
    }

    public void borrarCliente(Long id) {
        Cliente clienteDb=clienteRepository.getClienteById(id).orElseThrow(()->new EntityNotFoundException("No se encuentra el cliente con id: " + id));
        clienteRepository.delete(clienteDb);
    }
}
