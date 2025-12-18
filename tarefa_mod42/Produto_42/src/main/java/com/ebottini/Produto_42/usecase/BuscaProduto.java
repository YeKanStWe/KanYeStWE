package com.ebottini.Produto_42.usecase;

import ch.qos.logback.core.status.Status;
import com.ebottini.Produto_42.domain.Produto;
import com.ebottini.Produto_42.exception.EntityNotFoundException;
import com.ebottini.Produto_42.repository.IProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;

@Service
public class BuscaProduto {

    private IProdutoRepository produtoRepository;

    @Autowired
    public BuscaProduto(IProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Page<Produto> buscar(Pageable pageable) {
        return produtoRepository.findAll((org.springframework.data.domain.Pageable) pageable);
    }

    public Page<Produto> buscar(Pageable pageable, Status status) {
        return produtoRepository.findAllByStatus(pageable, status);
    }

    public Produto buscarPorCodigo(String codigo) {
        return produtoRepository.findByCodigo(codigo)
                .orElseThrow(() -> new EntityNotFoundException(Produto.class, "codigo", codigo));
    }


}
