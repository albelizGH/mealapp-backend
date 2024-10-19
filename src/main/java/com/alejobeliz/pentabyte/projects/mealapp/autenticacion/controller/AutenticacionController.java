package com.alejobeliz.pentabyte.projects.mealapp.autenticacion.controller;

import com.alejobeliz.pentabyte.projects.mealapp.autenticacion.dto.CredencialesDto;
import com.alejobeliz.pentabyte.projects.mealapp.cliente.Cliente;
import com.alejobeliz.pentabyte.projects.mealapp.infra.security.ClienteUserDetail;
import com.alejobeliz.pentabyte.projects.mealapp.infra.security.token.JwtService;
import com.alejobeliz.pentabyte.projects.mealapp.infra.security.token.TokenAcceso;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class AutenticacionController {

    private AuthenticationManager authenticationManager;
    private JwtService jwtService;

    @Autowired
    public AutenticacionController(AuthenticationManager authenticationManager, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }
    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid CredencialesDto credenciales) {
        try {
            Authentication authenticationToken = new UsernamePasswordAuthenticationToken(credenciales.correo(), credenciales.contrasenia());
            Authentication usuarioAutenticado = authenticationManager.authenticate(authenticationToken);

            // Verificar el tipo de principal y obtener el Cliente
            if (usuarioAutenticado.getPrincipal() instanceof ClienteUserDetail) {
                ClienteUserDetail userDetails = (ClienteUserDetail) usuarioAutenticado.getPrincipal();
                Cliente cliente = userDetails.getCliente(); // Obtener el Cliente
                String JWToken = jwtService.generarToken(cliente); // Generar el token
                return ResponseEntity.ok(new TokenAcceso(JWToken));
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); // O manejar el caso de error
            }

        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } catch (DisabledException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Usuario desactivado.");
        }
    }


}

