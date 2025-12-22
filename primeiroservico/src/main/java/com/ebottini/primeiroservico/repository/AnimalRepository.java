package com.ebottini.primeiroservico.repository;

import com.ebottini.primeiroservico.entidades.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    @Query("SELECT a FROM Animal a WHERE a.dataAdocao IS NULL ORDER BY a.dataChegada")
    List<Animal> findNotAdopted();

    @Query("SELECT a FROM Animal a WHERE a.dataAdocao IS NOT NULL")
    List<Animal> findAdopted();

    @Query("""
        SELECT a.nomeRecebedor, COUNT(a)
        FROM Animal a
        WHERE a.dataChegada BETWEEN :inicio AND :fim
        GROUP BY a.nomeRecebedor
    """)
    List<Object[]> contarResgatesPorFuncionario(
            @Param("inicio") Date inicio,
            @Param("fim") Date fim
    );
}
