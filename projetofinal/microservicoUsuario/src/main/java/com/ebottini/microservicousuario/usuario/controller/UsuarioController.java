package com.ebottini.microservicousuario.usuario.controller;

import com.ebottini.microservicousuario.usuario.entities.Usuario;
import com.ebottini.microservicousuario.usuario.services.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/memelandia")
public class UsuarioController {

    private static final Logger log =
            LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    private UsuarioService servicoUsuario;

    @GetMapping("/usuarios")
    public List<Usuario> buscaUsuarios() {
        log.info("busca usuarios");
        return servicoUsuario.listaTodosUsuarios();
    }

    @PostMapping("/usuarios")
    public Usuario novoUsuario(@RequestBody Usuario usuario) {
        log.info("novo usuario");
        return servicoUsuario.novoUsuario(usuario);
    }
}
