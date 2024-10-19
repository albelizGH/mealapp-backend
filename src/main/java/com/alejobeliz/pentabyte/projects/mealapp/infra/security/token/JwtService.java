package com.alejobeliz.pentabyte.projects.mealapp.infra.security.token;

import com.alejobeliz.pentabyte.projects.mealapp.cliente.Cliente;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Service
public class JwtService {

    @Value("${jwt.secret.key}")
    private String secretKey;

    @Value("${jwt.expiration.time.seconds}")
    private int expiracionEnSegundos;

    public String generarToken(Cliente cliente) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);
            return JWT.create()
                    .withIssuer("MealApp.Prep")
                    .withSubject(cliente.getCorreo())
                    .withExpiresAt(generarFechaExpiracion(cliente))
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new IllegalArgumentException("Error al generar token JWT: " + exception.getMessage(), exception);
        }
    }

    public String validarYObtenerCorreoDelToken(String tokenJWT) {
        try {
            Algorithm algoritmo = Algorithm.HMAC256(secretKey);
            return JWT.require(algoritmo)
                    .withIssuer("MealApp.Prep")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            throw new IllegalArgumentException("Token JWT inválido o expirado: " + exception.getMessage(), exception);
        }
    }

    private Instant generarFechaExpiracion(Cliente cliente) {
        if (cliente.getRol() != null && cliente.getRol().name().equalsIgnoreCase("local")) {
            return calcularFechaExpiracionLocal();
        } else {
            return calcularFechaExpiracionGeneral();
        }
    }

    private Instant calcularFechaExpiracionLocal() {
        ZonedDateTime ahora = ZonedDateTime.now(ZoneId.of("-03:00"));
        ZonedDateTime fechaExpiracion = ahora.withHour(23).withMinute(59).withSecond(0).withNano(0);

        // Si ya pasó el tiempo, el token expira el día siguiente.
        if (ahora.isAfter(fechaExpiracion)) {
            fechaExpiracion = fechaExpiracion.plusDays(1);
        }

        return fechaExpiracion.toInstant();
    }

    private Instant calcularFechaExpiracionGeneral() {
        ZonedDateTime ahora = ZonedDateTime.now(ZoneId.of("-03:00"));
        return ahora.plusSeconds(expiracionEnSegundos).toInstant();
    }

}
