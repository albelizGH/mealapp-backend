package com.alejobeliz.pentabyte.projects.mealapp.infra.errores;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class TratadorDeErrores {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorPersonalizado> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });

        ErrorPersonalizado response = new ErrorPersonalizado(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), "Fallo en la validación", errors);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorPersonalizado> handleEntityNotFoundException(EntityNotFoundException ex) {
        ErrorPersonalizado response = new ErrorPersonalizado(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                "Entidad no encontrada",
                Map.of("error", ex.getMessage())
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}

