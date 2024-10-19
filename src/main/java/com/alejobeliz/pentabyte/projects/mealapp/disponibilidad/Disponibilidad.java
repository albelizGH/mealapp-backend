package com.alejobeliz.pentabyte.projects.mealapp.disponibilidad;


import com.alejobeliz.pentabyte.projects.mealapp.plato.Plato;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Disponibilidad")
@Table(name = "disponibilidades")
public class Disponibilidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

  @Column(name = "semana_inicio")
    private LocalDate semanaDeInicio;

    @ManyToOne
    @JoinColumn(name = "plato_id")
    private Plato plato;

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
}
