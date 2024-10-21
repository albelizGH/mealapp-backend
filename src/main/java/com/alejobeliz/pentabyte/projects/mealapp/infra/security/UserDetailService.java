package com.alejobeliz.pentabyte.projects.mealapp.infra.security;


import com.alejobeliz.pentabyte.projects.mealapp.cliente.Cliente;
import com.alejobeliz.pentabyte.projects.mealapp.cliente.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService {

    private ClienteRepository clienteRepository;

    @Autowired
    public UserDetailService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public ClienteUserDetail loadUserByUsername(String correo) throws UsernameNotFoundException {
        Cliente clienteDb= clienteRepository.findClienteByCorreo(correo)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario con correo " + correo + " no esta registrado."));
        if (!clienteDb.getActivo()) {
            throw new IllegalStateException("El usuario con correo " + correo + " está inactivo.");
        }
        return new ClienteUserDetail(clienteDb);
    }


}