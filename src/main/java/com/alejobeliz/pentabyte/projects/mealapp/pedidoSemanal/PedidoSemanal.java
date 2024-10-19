package com.alejobeliz.pentabyte.projects.mealapp.pedidoSemanal;

import com.alejobeliz.pentabyte.projects.mealapp.cliente.Cliente;
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
@Entity(name = "PedidoSemanal")
@Table(name = "pedidos_semanales")
public class PedidoSemanal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_pedido")
    private LocalDateTime fechaDePedido;

    @Column(name = "semana_entrega")
    private LocalDate semanaDeEntrega;

    @ManyToOne()
    @JoinColumn(name="cliente_id")
    private Cliente cliente;

    public PedidoSemanal(Cliente cliente){
        this.fechaDePedido=LocalDateTime.now();
        LocalDate fechaDePedidoLocal = fechaDePedido.toLocalDate();
        this.semanaDeEntrega = fechaDePedidoLocal.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        this.cliente=cliente;
    }

}
