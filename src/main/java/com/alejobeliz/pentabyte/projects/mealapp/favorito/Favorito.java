package com.alejobeliz.pentabyte.projects.mealapp.favorito;

import com.alejobeliz.pentabyte.projects.mealapp.cliente.Cliente;
import com.alejobeliz.pentabyte.projects.mealapp.plato.Plato;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Favorito")
@Table(name = "favoritos")
public class Favorito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne()
    @JoinColumn(name = "plato_id")
    private Plato plato;

    public Favorito(Cliente cliente,Plato plato){
        this.cliente=cliente;
        this.plato=plato;
    }
}
