package com.alejobeliz.pentabyte.projects.mealapp.model.plato;

import com.alejobeliz.pentabyte.projects.mealapp.model.detallepedidos.DetallePedido;
import com.alejobeliz.pentabyte.projects.mealapp.model.disponibilidadsemanal.DisponibilidadSemanal;
import com.alejobeliz.pentabyte.projects.mealapp.model.favorito.Favorito;
import com.alejobeliz.pentabyte.projects.mealapp.model.tipodeplato.TipoDePlato;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Plato")
@Table(name = "platos")
public class Plato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "imagen")
    private String imagen;

    @Column(name = "cantidad_maxima")
    private Integer cantidadMaxima;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "cantidad_veces_pedido")
    private Integer cantidadDeVecesPedido;

    @ManyToOne
    @JoinColumn(name = "tipo_plato_id")
    private TipoDePlato tipoDePlato;

    @JsonIgnore
    @OneToMany(mappedBy = "plato")
    private List<Favorito> favoritos;

    @JsonIgnore
    @OneToMany(mappedBy = "plato")
    private List<DisponibilidadSemanal> disponibilidadesSemanales;

    @JsonIgnore
    @OneToMany(mappedBy = "plato")
    private List<DetallePedido> detallesDePedidos;
}
