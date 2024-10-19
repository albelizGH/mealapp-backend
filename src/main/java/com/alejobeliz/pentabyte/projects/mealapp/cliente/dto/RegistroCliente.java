package com.alejobeliz.pentabyte.projects.mealapp.cliente.dto;

import jakarta.validation.constraints.Email;
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
        @Email
        String correo,
        @NotBlank(message = "La contraseña es requerida.")
        @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres.")
        @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
                message = "La contraseña debe incluir una letra mayúscula, una letra minúscula, un número y un carácter especial.")
        String contrasenia
) {
}