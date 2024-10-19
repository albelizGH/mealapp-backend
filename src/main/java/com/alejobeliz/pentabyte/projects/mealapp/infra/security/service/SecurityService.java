package com.alejobeliz.pentabyte.projects.mealapp.infra.security.service;

import com.alejobeliz.pentabyte.projects.mealapp.infra.security.ClienteUserDetail;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {

    public Long getIdDeUsuarioDesdeAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new IllegalStateException("Usuario no autenticado");
        }
        ClienteUserDetail userDetails = (ClienteUserDetail) authentication.getPrincipal();
        return userDetails.getClienteId();
    }
}
