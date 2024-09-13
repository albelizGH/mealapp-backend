package com.alejobeliz.pentabyte.projects.mealapp.model.tipodeplato;

import com.alejobeliz.pentabyte.projects.mealapp.model.plato.Plato;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "TipoDePlato")
@Table(name = "tipos_plato")
public class TipoDePlato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @JsonIgnore//Ignoro esta lista en el mapeo para no tener problemas de recursividad infinita
    @OneToMany(mappedBy = "tipoDePlato")//Hago la relacion bidireccional para poder acceder tambien desde Tipos de platos a todos los platos que contiene
    private List<Plato> platos;


}
