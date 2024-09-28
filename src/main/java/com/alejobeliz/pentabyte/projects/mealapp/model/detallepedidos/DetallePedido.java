package com.alejobeliz.pentabyte.projects.mealapp.model.detallepedidos;

import com.alejobeliz.pentabyte.projects.mealapp.model.pedidosdia.PedidoDia;
import com.alejobeliz.pentabyte.projects.mealapp.model.plato.Plato;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "DetallePedido")
@Table(name = "detalles_pedidos")
public class DetallePedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "comentario")
    private String comentario;

    @Column(name = "cantidad")
    private Integer cantidad;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pedido_dia_id")
    private PedidoDia pedidoDia;

    @ManyToOne()
    @JoinColumn(name = "plato_id")
    private Plato plato;
}
