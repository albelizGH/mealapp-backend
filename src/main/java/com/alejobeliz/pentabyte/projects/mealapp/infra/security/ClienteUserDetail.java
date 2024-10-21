package com.alejobeliz.pentabyte.projects.mealapp.infra.security;

import com.alejobeliz.pentabyte.projects.mealapp.cliente.Cliente;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class ClienteUserDetail implements UserDetails {

    private final Cliente cliente;

    public ClienteUserDetail(Cliente cliente) {
        this.cliente = cliente;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + cliente.getRol().name()));
    }

    @Override
    public String getPassword() {
        return cliente.getContrasenia();
    }

    @Override
    public String getUsername() {
        return cliente.getCorreo();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return cliente.getActivo();
    }

    public Long getClienteId() {
        return cliente.getId();
    }

    // Nuevo método para obtener el cliente
    public Cliente getCliente() {
        return cliente;
    }
}
