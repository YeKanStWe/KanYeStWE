package com.ebottini.Produto_42.usecase;

import com.ebottini.Produto_42.domain.Produto;
import com.ebottini.Produto_42.exception.EntityNotFoundException;
import com.ebottini.Produto_42.repository.IProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroProduto {

    private IProdutoRepository produtoRepository;

    @Autowired
    public CadastroProduto(IProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto cadastrar(@Valid Produto produto) {
        produto.setStatus(Produto.Status.ATIVO);
        return this.produtoRepository.insert(produto);
    }

    public Produto atualizar(@Valid Produto produto) {
        return this.produtoRepository.save(produto);
    }

    public void remover(String id) {
        Produto prod = produtoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Produto.class, "id", id));
        prod.setStatus(Produto.Status.INATIVO);
        this.produtoRepository.save(prod);
        //this.produtoRepository.deleteById(id);
    }

}
