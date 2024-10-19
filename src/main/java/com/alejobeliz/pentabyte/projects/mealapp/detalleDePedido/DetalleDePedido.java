package com.alejobeliz.pentabyte.projects.mealapp.detalleDePedido;

import com.alejobeliz.pentabyte.projects.mealapp.pedidoDiario.PedidoDiario;
import com.alejobeliz.pentabyte.projects.mealapp.plato.Plato;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "DetalleDePedido")
@Table(name = "detalles_pedidos")
public class DetalleDePedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "comentario")
    private String comentario;

    @Column(name = "cantidad")
    private Integer cantidad;

    @ManyToOne()
    @JoinColumn(name = "pedido_dia_id")
    private PedidoDiario pedidoDiario;

    @ManyToOne()
    @JoinColumn(name = "plato_id")
    private Plato plato;
}
