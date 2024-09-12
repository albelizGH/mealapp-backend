package com.alejobeliz.pentabyte.projects.mealapp.domain.pedido;

import com.alejobeliz.pentabyte.projects.mealapp.domain.cliente.Cliente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Pedido")
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_pedido")
    private Date fechaDePedido;

    @Column(name = "semana_entrega")
    private Date semanaDeEntrega;

    @Column(name = "estado")
    private Estado estado;

    @ManyToOne
    @JoinColumn(name="cliente_id")
    private Cliente cliente;
}
