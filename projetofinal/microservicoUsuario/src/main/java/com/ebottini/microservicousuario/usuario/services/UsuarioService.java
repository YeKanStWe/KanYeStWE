package com.ebottini.microservicousuario.usuario.services;

import com.ebottini.microservicousuario.usuario.controller.UsuarioController;
import com.ebottini.microservicousuario.usuario.entities.Usuario;
import com.ebottini.microservicousuario.usuario.repositories.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
public class UsuarioService {

    private static final Logger log =
            LoggerFactory.getLogger(UsuarioService.class);

    private UsuarioRepository usuarioRepo;

    @Autowired
    private UsuarioRepository repositorioUsuario;

    public Usuario novoUsuario(Usuario usuario) {
        log.info("novo usuario");
        return repositorioUsuario.save(usuario);
    }

    public List<Usuario> listaTodosUsuarios() {
        log.info("busca usuarios");
        return repositorioUsuario.findAll();
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Void> existe(@PathVariable Long id) {
        log.info("envio usuarios");
        return usuarioRepo.existsById(id) ? ResponseEntity.ok().build()
                : ResponseEntity.notFound().build();
    }

}
