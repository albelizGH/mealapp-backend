package com.alejobeliz.pentabyte.projects.mealapp.cliente.dto;

import com.alejobeliz.pentabyte.projects.mealapp.cliente.Cliente;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record DatosPersonalesDto(
        String nombre,
        String apellido,
        @Size(min = 8, max = 8, message = "El documento debe tener 8 dígitos")
        @Pattern(regexp = "\\d{8}", message = "El documento debe contener solo dígitos")
        String documento) {

        public DatosPersonalesDto(Cliente cliente) {
                this(cliente.getNombre(), cliente.getApellido(), cliente.getDocumento());
        }
}
