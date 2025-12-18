package com.ebottini.Produto_42.repository;

import ch.qos.logback.core.status.Status;
import com.ebottini.Produto_42.domain.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.Optional;

@Repository
public interface IProdutoRepository extends MongoRepository<Produto, String> {

    Optional<Produto> findByCodigo(String codigo);

    Page<Produto> findAllByStatus(Pageable pageable, Status status);
}
