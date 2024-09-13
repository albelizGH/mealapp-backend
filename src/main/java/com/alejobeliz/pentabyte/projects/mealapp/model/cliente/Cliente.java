package com.alejobeliz.pentabyte.projects.mealapp.model.cliente;

import com.alejobeliz.pentabyte.projects.mealapp.model.favorito.Favorito;
import com.alejobeliz.pentabyte.projects.mealapp.model.pedido.Pedido;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
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

    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    private List<Favorito> favoritos;
}