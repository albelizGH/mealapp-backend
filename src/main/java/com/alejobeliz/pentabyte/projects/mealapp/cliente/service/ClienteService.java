package com.alejobeliz.pentabyte.projects.mealapp.cliente.service;

import com.alejobeliz.pentabyte.projects.mealapp.autenticacion.dto.CredencialesDto;
import com.alejobeliz.pentabyte.projects.mealapp.cliente.Cliente;
import com.alejobeliz.pentabyte.projects.mealapp.cliente.dto.*;
import com.alejobeliz.pentabyte.projects.mealapp.cliente.mapper.ClienteMapper;
import com.alejobeliz.pentabyte.projects.mealapp.cliente.repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final PasswordEncoder passwordEncoder;

    public ClienteService(ClienteRepository clienteRepository, PasswordEncoder passwordEncoder) {
        this.clienteRepository = clienteRepository;
        this.passwordEncoder = passwordEncoder;
    }

    //FIJARME POR QUE NO ANDA EL PAGEAB
    public List<ClienteDto> getAllClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream()
                .map(cliente -> new ClienteDto(cliente))
                .collect(Collectors.toList());
    }

    public ClienteDto getCliente(Long id) {
        ClienteDto clienteDto=clienteRepository.findById(id)
                .map(ClienteDto::new)
                .orElseThrow(()->new EntityNotFoundException("No se encuentra el cliente con id: " + id));
        return clienteDto;
    }

    public List<DiasLaboralesDto> getDiasLaborales(Long id){
        Cliente clienteDb = clienteRepository.getClienteById(id).get();
        return  new ClienteMapper().mapearAListaDiasLAboralesDto(clienteDb);
    }

    public DatosPersonalesDto getDatosPersoanles(Long id) {
        return clienteRepository.findDatosPersonalesById(id).orElseThrow(()->new EntityNotFoundException("No se encuentra el cliente con id: " + id));
    }

    @Transactional
    public void setDiasLaborales(Long id, ClienteDiasLaboralesDto diasLaborales) {
        Cliente clienteDb = clienteRepository.getClienteById(id).get();
        clienteDb.modificarDiasLaborales(clienteDb,diasLaborales);
        clienteRepository.save(clienteDb);
        }

    public DatosPersonalesDto setDatosPersonales(Long id, DatosPersonalesDto datosPersonales) {
        Cliente clienteDb = clienteRepository.getClienteById(id).orElseThrow(()->new EntityNotFoundException("No se encuentra el cliente con id: " + id));
        if(!clienteDb.getActivo()){
            throw new RuntimeException("El cliente está desactivado");
        }
        clienteDb.modificarDatosPersonales(clienteDb,datosPersonales);
        clienteRepository.save(clienteDb);
        return new DatosPersonalesDto(clienteDb);
    }

    public ClienteDto registrarCliente(RegistroCliente nuevoCliente) {
        Optional<Cliente> clienteExsitente = clienteRepository.findClienteByCorreo(nuevoCliente.correo());
        if (clienteExsitente.isPresent()) {
            throw new EntityNotFoundException("Ya existe el usuario con correo: " + nuevoCliente.correo());
        }
        String contraseniaEncriptada =passwordEncoder.encode(nuevoCliente.contrasenia());
        Cliente cliente = new Cliente(nuevoCliente.nombre(), nuevoCliente.apellido(), nuevoCliente.documento(), nuevoCliente.correo(), contraseniaEncriptada);
        clienteRepository.save(cliente);
        return new ClienteDto (cliente);
    }

    public void desactivarCliente(CredencialesDto credenciales) {
        Cliente clienteDb=clienteRepository.findClienteByCorreo(credenciales.correo()).orElseThrow(()->new EntityNotFoundException("El correo ingresado no esta registrado"));
          /*VERIFICAR SI LA CONTRASEÑA ES CORRECTA
        PERO ANTES DE ESO HAY QUE DESENCRIPTAR LA QUE VIENE DE LA BASE DE DATOS PORQUE ESTARIA ENCRIPTADA
        SI LA CONTRASEÑA ES CORRECTA AHI SI ACTIVAMOS*/
        clienteDb.desactivarCliente();
        //borro todos los pedidos asociados a ese cliente?
        clienteRepository.save(clienteDb);
    }


    public ClienteDto activarCliente(CredencialesDto credenciales) {
        Cliente clienteDb=clienteRepository.findClienteByCorreo(credenciales.correo()).orElseThrow(()->new EntityNotFoundException("El correo ingresado no esta registrado"));
        /*VERIFICAR SI LA CONTRASEÑA ES CORRECTA
        PERO ANTES DE ESO HAY QUE DESENCRIPTAR LA QUE VIENE DE LA BASE DE DATOS PORQUE ESTARIA ENCRIPTADA
        SI LA CONTRASEÑA ES CORRECTA AHI SI ACTIVAMOS*/

        if(clienteDb.getActivo()){
            throw new RuntimeException("El cliente ya se encuentra activo");
        }
        clienteDb.activarCliente();
        clienteRepository.save(clienteDb);
        return new ClienteDto(clienteDb);
    }

    public void borrarCliente(Long id) {
        Cliente clienteDb=clienteRepository.getClienteById(id).orElseThrow(()->new EntityNotFoundException("No se encuentra el cliente con id: " + id));
        clienteRepository.delete(clienteDb);
    }
}
