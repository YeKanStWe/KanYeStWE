package com.ebottini.primeiroservico.controller;

import com.ebottini.primeiroservico.entidades.Animal;
import com.ebottini.primeiroservico.repository.AnimalRepository;
import com.ebottini.primeiroservico.service.AnimalService;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/animais")
public class AnimalController {

    private final AnimalRepository repository;
    private final AnimalService service;

    public AnimalController(AnimalRepository repository, AnimalService service) {
        this.repository = repository;
        this.service = service;
    }

    @GetMapping
    public List<Animal> findAll() {
        return repository.findAll();
    }

    @PostMapping
    public Animal create(@RequestBody Animal animal) {
        return service.cadastrar(animal);
    }

    @GetMapping("/not-adopted")
    public List<Animal> findNotAdopted() {
        return repository.findNotAdopted();
    }

    @GetMapping("/adopted")
    public List<Animal> findAdopted() {
        return repository.findAdopted();
    }

    @GetMapping("/resgates")
    public Map<String, Long> resgatesPorFuncionario(
            @RequestParam Date inicio,
            @RequestParam Date fim) {

        return service.resgatesPorFuncionario(inicio, fim);
    }
}
