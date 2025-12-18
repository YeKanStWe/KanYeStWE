package com.ebottini.Produto_42.controller;

import ch.qos.logback.core.status.Status;
import com.ebottini.Produto_42.domain.Produto;
import com.ebottini.Produto_42.usecase.BuscaProduto;
import com.ebottini.Produto_42.usecase.CadastroProduto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoResource {

    private BuscaProduto buscaProduto;

    private CadastroProduto cadastroProduto;

    @Autowired
    public ProdutoResource(BuscaProduto buscaProduto,
                           CadastroProduto cadastroProduto) {
        this.buscaProduto = buscaProduto;
        this.cadastroProduto = cadastroProduto;
    }

    @GetMapping
    @Operation(summary = "Busca uma lista paginada de produtos")
    public ResponseEntity<Page<Produto>> buscar(Pageable pageable) {
        return ResponseEntity.ok(buscaProduto.buscar(pageable));
    }

    @GetMapping(value = "/status/{status}")
    @Operation(summary = "Busca uma lista paginada de produtos por status")
    public ResponseEntity<Page<Produto>> buscarPorStatus(Pageable pageable,
                                                         @PathVariable(value = "status", required = true) Status status) {
        return ResponseEntity.ok(buscaProduto.buscar(pageable, status));
    }

    @GetMapping(value = "/{codigo}")
    @Operation(summary = "Busca um produto pelo codigo")
    public ResponseEntity<Produto> buscarPorCodigo(String codigo) {
        return ResponseEntity.ok(buscaProduto.buscarPorCodigo(codigo));
    }

    @PostMapping
    @Operation(summary = "Cadastrar um produto")
    public ResponseEntity<Produto> cadastrar(@RequestBody @Valid Produto produto) {
        return ResponseEntity.ok(cadastroProduto.cadastrar(produto));
    }

    @PutMapping
    @Operation(summary = "Atualiza um produto")
    public ResponseEntity<Produto> atualizar(@RequestBody @Valid Produto produto) {
        return ResponseEntity.ok(cadastroProduto.atualizar(produto));
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Remove um produto pelo seu identificador único")
    public ResponseEntity<String> remover(@PathVariable(value = "id") String id) {
        cadastroProduto.remover(id);
        return ResponseEntity.ok("Removido com sucesso");
    }
}
