package com.alejobeliz.pentabyte.projects.mealapp.model.cliente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity(name = "Cliente")
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "documento")
    private String documento;

    @Column(name = "correo")
    private String correo;

    @Column(name = "contrasenia")
    private String contrasenia;

    @Column(name="fecha_alta")
    private LocalDateTime fechaDeAlta;

    @Column(name="fecha_baja")
    private LocalDateTime fechaDeBaja;

    @Column(name = "lunes")
    private Boolean lunes;

    @Column(name = "martes")
    private Boolean martes;

    @Column(name = "miercoles")
    private Boolean miercoles;

    @Column(name = "jueves")
    private Boolean jueves;

    @Column(name = "viernes")
    private Boolean viernes;

    public Cliente(String nombre, String apellido, String documento, String correo, String contrasenia, LocalDate fechaDeAlta, LocalDate fechaDeBaja, Boolean lunes, Boolean martes, Boolean miercoles, Boolean jueves, Boolean viernes) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.fechaDeAlta = LocalDateTime.now();
        this.fechaDeBaja = null;
        this.lunes = lunes;
        this.martes = martes;
        this.miercoles = miercoles;
        this.jueves = jueves;
        this.viernes = viernes;
    }
}