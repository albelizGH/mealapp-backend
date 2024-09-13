package com.alejobeliz.pentabyte.projects.mealapp.model.pedido;

import com.alejobeliz.pentabyte.projects.mealapp.model.cliente.Cliente;
import com.alejobeliz.pentabyte.projects.mealapp.model.pedidosdia.PedidosDia;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


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
    private LocalDate fechaDePedido;

    @Column(name = "semana_entrega")
    private LocalDate semanaDeEntrega;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private Estado estado;

    @ManyToOne
    @JoinColumn(name="cliente_id")
    private Cliente cliente;

    @JsonIgnore
    @OneToMany(mappedBy = "pedido")
    private List<PedidosDia> pedidosDias;


}
