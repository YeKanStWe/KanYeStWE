package com.ebottini.microservicocategorias.categorias.services;

import com.ebottini.microservicocategorias.categorias.entities.CategoriaMeme;
import com.ebottini.microservicocategorias.categorias.repositories.CategoriaMemeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ServiceMemes {

    private CategoriaMemeRepository categoriaRepo;

    private static final Logger log =
            LoggerFactory.getLogger(ServiceMemes.class);

    @Autowired
    private CategoriaMemeRepository repositorioCategoriaMeme;

    private final RestTemplate rest = new RestTemplate();

    private void validarUsuario(Long usuarioId) {
        rest.getForEntity(
                "http://localhost:8081/usuarios/" + usuarioId, Void.class);
        log.info("usuario validado");
    }

    public CategoriaMeme novaCategoriaMeme(CategoriaMeme categoriaMeme) {
        validarUsuario(categoriaMeme.getUsuarioId());
        log.info("Nova Categoria");
        return repositorioCategoriaMeme.save(categoriaMeme);
    }

    public List<CategoriaMeme> listaTodasCategorias() {
        return repositorioCategoriaMeme.findAll();
    }

    @GetMapping("/categorias/{id}")
    public ResponseEntity<Void> existe(@PathVariable Long id) {
        log.info("envio usuarios");
        return categoriaRepo.existsById(id) ? ResponseEntity.ok().build()
                : ResponseEntity.notFound().build();
    }
}