package com.alejobeliz.pentabyte.projects.mealapp.favorito.repository;

import com.alejobeliz.pentabyte.projects.mealapp.favorito.Favorito;
import com.alejobeliz.pentabyte.projects.mealapp.plato.Plato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FavoritoRepository extends JpaRepository<Favorito, Long> {

    @Query("""
            SELECT p.plato
            FROM Favorito p
            WHERE p.cliente.id = :id
            """)
    List<Plato> findAllByClienteId(Long id);

    @Query("""
            SELECT f
            FROM Favorito f
            WHERE f.cliente.id =:idCliente
            AND f.plato.id =:id
            """)
    Optional<Favorito> findFavoritoByClienteIdAndId(Long idCliente, Long id);

    @Query("""
    SELECT CASE WHEN COUNT(f) > 0 THEN TRUE ELSE FALSE END
    FROM Favorito f
    WHERE f.cliente.id = :idCliente
    AND f.plato.id = :platoId
""")
    Boolean isFavorite(Long idCliente, Long platoId);



}
