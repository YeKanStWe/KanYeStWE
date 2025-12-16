package com.tarefa_mod33;

import com.tarefa_mod33.domain.Acessorio;
import com.tarefa_mod33.domain.Carro;
import com.tarefa_mod33.domain.Marca;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
class CarroTest {

    @Autowired
    EntityManager em;

    @Test
    void salvarRelacionamentos() {
        Marca m = new Marca(); m.setNome("Ford"); em.persist(m);
        Acessorio a = new Acessorio(); a.setDescricao("Ar"); em.persist(a);
        Carro c = new Carro(); c.setModelo("Ka"); c.setMarca(m); c.setAcessorios(List.of(a));
        em.persist(c);
        assertNotNull(c.getId());
    }
}
