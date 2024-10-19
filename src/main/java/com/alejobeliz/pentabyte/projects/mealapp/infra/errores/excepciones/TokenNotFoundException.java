package com.alejobeliz.pentabyte.projects.mealapp.infra.errores.excepciones;

public class TokenNotFoundException extends RuntimeException {
    public TokenNotFoundException(String message) {
        super(message);
    }
}
