package com.ebottini.microservicomemes.memes.controller;

import com.ebottini.microservicomemes.memes.entities.Meme;
import com.ebottini.microservicomemes.memes.services.ServiceMemes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/memelandia")
public class MemeController {

    private static final Logger log =
            LoggerFactory.getLogger(MemeController.class);

    @Autowired
    private ServiceMemes servicoMeme;

    @GetMapping("/memes")
    public List<Meme> buscaMemes() {
        log.info("busca memes");
        return servicoMeme.listaTodosMemes();
    }

    @PostMapping("/memes")
    public Meme novoMeme(@RequestBody Meme meme) {
        log.info("novo meme");
        return servicoMeme.novoMeme(meme);
    }
}
