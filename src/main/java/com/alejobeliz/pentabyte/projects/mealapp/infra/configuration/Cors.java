package com.alejobeliz.pentabyte.projects.mealapp.infra.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
    public class Cors implements WebMvcConfigurer {

  /*  @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT", "PATCH");
    }*/


    //AHORA QUE YA TENGO CONFIGURADA LA SEGURIDAD PUEDO PERMITIR PETICIONES DE CUALQUIER ORIGEN
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*") // Permitir todos los patrones de origen
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT", "PATCH")
                .allowedHeaders("*"); // Permitir todas las cabeceras
    }
}