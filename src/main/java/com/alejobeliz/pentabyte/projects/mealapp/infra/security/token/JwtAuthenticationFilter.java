package com.alejobeliz.pentabyte.projects.mealapp.infra.security.token;

import com.alejobeliz.pentabyte.projects.mealapp.infra.errores.excepciones.TokenNotFoundException;
import com.alejobeliz.pentabyte.projects.mealapp.infra.security.ClienteUserDetail;
import com.alejobeliz.pentabyte.projects.mealapp.infra.security.autenticacion.AutenticacionService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final AutenticacionService autenticacionService;

    @Autowired
    public JwtAuthenticationFilter(JwtService jwtService, AutenticacionService autenticacionService) {
        this.jwtService = jwtService;
        this.autenticacionService = autenticacionService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {

            // Obtener el URI de la solicitud
            String path = request.getRequestURI();

            if (path.equals("/api/login") || path.equals("/api/cliente/activar")) {
                filterChain.doFilter(request, response);
                return; // Salir del método
            }

            //Obtener el token JWT de la solicitud
            String tokenJWT = obtenerToken(request);

            //Validar el token y obtener el correo del usuario
            String correo = jwtService.validarYObtenerCorreoDelToken(tokenJWT);

            //Cargar los detalles del usuario (ClienteUserDetail)
            ClienteUserDetail clienteUserDetail = autenticacionService.loadUserByUsername(correo);

            //Verificar si ya hay una autenticación en el contexto de seguridad en el caso de que mas adelante añada algun otro filtro anterior a este que autentifique al usuario
            if (SecurityContextHolder.getContext().getAuthentication() == null) {

                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(clienteUserDetail, null, clienteUserDetail.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }

            //Continuar con el filtro
            filterChain.doFilter(request, response);
        } catch (TokenNotFoundException | IllegalArgumentException e) {
            logger.error("Error de autenticación: " + e.getMessage());
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Token invalido o no proporcionado");
        }
    }

    //Busco en el encabezado en la parte de Authorization primero que este, y si esta quito la parte de Bearer para quedarme con el token
    private String obtenerToken(HttpServletRequest request) {
        var authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            return authorizationHeader.replace("Bearer ", "");
        }
        throw new TokenNotFoundException("Token no encontrado en el encabezado de Authorization");
    }

}
