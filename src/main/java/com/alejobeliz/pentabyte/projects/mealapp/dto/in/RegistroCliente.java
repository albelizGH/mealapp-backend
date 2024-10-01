package com.alejobeliz.pentabyte.projects.mealapp.dto.in;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record RegistroCliente(
        @NotBlank
        String nombre,
        @NotBlank
        String apellido,
        @Size(min = 8, max = 8, message = "El documento debe tener 8 dígitos")
        @Pattern(regexp = "\\d{8}", message = "El documento debe contener solo dígitos")
        String documento,
        @NotBlank
        String correo,
        String contrasenia
) {
}
