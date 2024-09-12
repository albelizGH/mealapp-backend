package com.alejobeliz.pentabyte.projects.mealapp.domain.pedidosdia;

import com.alejobeliz.pentabyte.projects.mealapp.domain.pedido.Pedido;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "PedidoDia")
@Table(name = "pedidos_dia")
public class PedidosDia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dia")
    private Dia dia;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;
}
