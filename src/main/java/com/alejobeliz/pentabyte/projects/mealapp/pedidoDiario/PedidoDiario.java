package com.alejobeliz.pentabyte.projects.mealapp.pedidoDiario;

import com.alejobeliz.pentabyte.projects.mealapp.pedidoSemanal.PedidoSemanal;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "PedidoDiario")
@Table(name = "pedidos_diarios")
public class PedidoDiario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "dia")
    private Dia dia;

    @Column(name = "fecha_entrega")
    private LocalDate fechaDeEntrega;

    @ManyToOne()
    @JoinColumn(name = "pedido_id")
    private PedidoSemanal pedidoSemanal;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private Estado estado;

    public PedidoDiario(Dia dia, PedidoSemanal pedidoSemanal){
        this.dia=dia;
        this.fechaDeEntrega=LocalDate.now().with(TemporalAdjusters.next(dia.toDayOfWeek()));
        this.pedidoSemanal = pedidoSemanal;
        this.estado=Estado.Pendiente;
    }

}
