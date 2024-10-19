package com.alejobeliz.pentabyte.projects.mealapp.infra.security.autenticacion;


import com.alejobeliz.pentabyte.projects.mealapp.cliente.Cliente;
import com.alejobeliz.pentabyte.projects.mealapp.cliente.repository.ClienteRepository;
import com.alejobeliz.pentabyte.projects.mealapp.infra.security.ClienteUserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacionService implements UserDetailsService {

    private ClienteRepository clienteRepository;

    @Autowired
    public AutenticacionService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public ClienteUserDetail loadUserByUsername(String correo) throws UsernameNotFoundException {
        Cliente clienteDb= clienteRepository.findClienteByCorreo(correo)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario con correo " + correo + " no esta registrado."));

        if (!clienteDb.getActivo()) {
            //Por mas que el usuario tenga ya el token si lo desactivo como administrador no va a poder acceder a ningun recurso ya que lo verifico antes de seguir
            throw new IllegalStateException("El usuario con correo " + correo + " está inactivo.");
        }
        return new ClienteUserDetail(clienteDb);
    }

}
