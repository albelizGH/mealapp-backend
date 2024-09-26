package com.alejobeliz.pentabyte.projects.mealapp.model.pedidosdia;

import com.alejobeliz.pentabyte.projects.mealapp.model.pedido.Pedido;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "PedidoDia")
@Table(name = "pedidos_dia")
public class PedidoDia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "dia")
    private Dia dia;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    public PedidoDia(Dia dia, Pedido pedido){
        this.dia=dia;
        this.pedido=pedido;
    }

}
