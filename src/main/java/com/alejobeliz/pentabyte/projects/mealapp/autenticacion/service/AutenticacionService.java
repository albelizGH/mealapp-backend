package com.alejobeliz.pentabyte.projects.mealapp.autenticacion.service;

import com.alejobeliz.pentabyte.projects.mealapp.autenticacion.dto.CredencialesDto;
import com.alejobeliz.pentabyte.projects.mealapp.cliente.Cliente;
import com.alejobeliz.pentabyte.projects.mealapp.infra.security.ClienteUserDetail;
import com.alejobeliz.pentabyte.projects.mealapp.infra.security.JwtService;
import com.alejobeliz.pentabyte.projects.mealapp.infra.security.TokenAcceso;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AutenticacionService {

    private AuthenticationManager authenticationManager;
    private JwtService jwtService;

    public AutenticacionService(AuthenticationManager authenticationManager, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    public TokenAcceso autenticarLogin(CredencialesDto credenciales){
        Authentication authenticacion = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(credenciales.correo(),credenciales.contrasenia()));
        ClienteUserDetail clienteUserDetail = (ClienteUserDetail) authenticacion.getPrincipal();
        Cliente cliente = clienteUserDetail.getCliente();
        return new TokenAcceso(jwtService.crearToken(cliente));
    }

}
