package com.ebottini.microservicocategorias.categorias.controller;

import com.ebottini.microservicocategorias.categorias.entities.CategoriaMeme;
import com.ebottini.microservicocategorias.categorias.services.ServiceMemes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/memelandia")
public class CategoriaMemeController {

    private static final Logger log =
            LoggerFactory.getLogger(CategoriaMemeController.class);

    @Autowired
    private ServiceMemes servicoMeme;

    @GetMapping("/categorias")
    public List<CategoriaMeme> buscaCategorias() {
        log.info("busca categorias");
        return servicoMeme.listaTodasCategorias();

    }

    @PostMapping("/categorias")
    public CategoriaMeme novaCategoria(@RequestBody CategoriaMeme categoriaMeme) {
        log.info("nova categoria");
        return servicoMeme.novaCategoriaMeme(categoriaMeme);
    }
}
