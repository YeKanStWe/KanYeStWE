package main.dao.generics;

import main.domain.Cliente;
import main.domain.Persistente;
import main.exception.TipoChaveNaoEncontradaException;

public interface IGenericService <T extends Persistente> {
    public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException;

    Cliente consultar(Long valor);

    void excluir(Long valor);

    void alterar(T entity) throws TipoChaveNaoEncontradaException;
}
