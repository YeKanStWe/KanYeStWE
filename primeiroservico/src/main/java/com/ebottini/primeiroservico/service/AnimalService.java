package com.ebottini.primeiroservico.service;

import com.ebottini.primeiroservico.entidades.Animal;
import com.ebottini.primeiroservico.repository.AnimalRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AnimalService {

    private final AnimalRepository repo;

    public AnimalService(AnimalRepository repo) {
        this.repo = repo;
    }

    public Animal cadastrar(Animal a) {
        if (a.getDataChegada() == null) {
            a.setDataChegada(Date.valueOf(LocalDate.now())); // data atual em Java
        }
        return repo.save(a);
    }

    public Map<String, Long> resgatesPorFuncionario(Date inicio, Date fim) {
        return repo.contarResgatesPorFuncionario(inicio, fim)
                .stream()
                .collect(Collectors.toMap(
                        r -> (String) r[0],
                        r -> (Long) r[1]
                ));
    }
}
