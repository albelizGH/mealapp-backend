package com.alejobeliz.pentabyte.projects.mealapp.model.pedido;

import com.alejobeliz.pentabyte.projects.mealapp.model.cliente.Cliente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;


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
    private LocalDateTime fechaDePedido;

    @Column(name = "semana_entrega")
    private LocalDate semanaDeEntrega;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private Estado estado;

    @ManyToOne()
    @JoinColumn(name="cliente_id")
    private Cliente cliente;

    public Pedido(Cliente cliente){
        this.fechaDePedido=LocalDateTime.now();
        LocalDate fechaDePedidoLocal = fechaDePedido.toLocalDate();
        this.semanaDeEntrega = fechaDePedidoLocal.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        this.estado=Estado.Pendiente;
        this.cliente=cliente;
    }

}
