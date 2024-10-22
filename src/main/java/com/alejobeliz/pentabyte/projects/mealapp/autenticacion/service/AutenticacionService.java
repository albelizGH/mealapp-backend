package com.alejobeliz.pentabyte.projects.mealapp.autenticacion.service;

import com.alejobeliz.pentabyte.projects.mealapp.autenticacion.dto.CredencialesDto;
import com.alejobeliz.pentabyte.projects.mealapp.infra.security.JwtService;
import com.alejobeliz.pentabyte.projects.mealapp.infra.security.TokenWeb;
import com.alejobeliz.pentabyte.projects.mealapp.infra.security.UserDetailService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AutenticacionService {

    private AuthenticationManager authenticationManager;
    private JwtService jwtService;
    private UserDetailService userDetailService;

    public AutenticacionService(AuthenticationManager authenticationManager, JwtService jwtService,UserDetailService userDetailService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.userDetailService=userDetailService;
    }

    public TokenWeb autenticarLogin(CredencialesDto credenciales){
        UsernamePasswordAuthenticationToken tokenDeAutenticacion = new UsernamePasswordAuthenticationToken(credenciales.correo(),credenciales.contrasenia());
        Authentication authenticacion = authenticationManager.authenticate(tokenDeAutenticacion);
        return new TokenWeb(jwtService.crearToken(authenticacion));
    }
}
