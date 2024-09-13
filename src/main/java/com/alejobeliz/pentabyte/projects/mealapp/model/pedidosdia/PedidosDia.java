package com.alejobeliz.pentabyte.projects.mealapp.model.pedidosdia;

import com.alejobeliz.pentabyte.projects.mealapp.model.detallepedidos.DetallePedido;
import com.alejobeliz.pentabyte.projects.mealapp.model.pedido.Pedido;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "PedidoDia")
@Table(name = "pedidos_dia")
public class PedidosDia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "dia")
    private Dia dia;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @JsonIgnore
    @OneToMany(mappedBy = "pedidosDia")
    private List<DetallePedido> detallesDePedidos;

}
