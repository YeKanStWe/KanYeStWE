package com.ebottini.microservicomemes.memes.services;


import com.ebottini.microservicomemes.memes.entities.Meme;
import com.ebottini.microservicomemes.memes.repositories.MemeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ServiceMemes {

    private static final Logger log =
            LoggerFactory.getLogger(ServiceMemes.class);

    @Autowired
    private MemeRepository repositorioMeme;

    private final RestTemplate rest = new RestTemplate();

    private void validarUsuario(Long usuarioId) {
        rest.getForEntity(
                "http://localhost:8081/usuarios/" + usuarioId, Void.class);
        log.info("usuario validado");
    }

    private void validarCategoria(Long categoriaId) {
        rest.getForEntity(
                "http://localhost:8081/categoria/" + categoriaId, Void.class);
        log.info("categoria validada");
    }

    public Meme novoMeme(Meme meme) {
        validarUsuario(meme.getUsuarioId());
        validarCategoria(meme.getCategoriaId());
        log.info("Novo meme");
        return repositorioMeme.save(meme);
    }


    public List<Meme> listaTodosMemes() {
        return repositorioMeme.findAll();
    }
}