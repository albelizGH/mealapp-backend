package com.alejobeliz.pentabyte.projects.mealapp.domain.tipodeplato;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


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

}
