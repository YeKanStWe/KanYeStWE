package main.services;

import main.domain.Cliente;
import main.dao.IClienteDAO;
import main.domain.Persistente;
import main.exception.TipoChaveNaoEncontradaException;

public class ClienteService implements IClienteService {
    private IClienteDAO clienteDAO;

    public ClienteService(IClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    @Override
    public Boolean cadastrar(Persistente entity) throws TipoChaveNaoEncontradaException {
        return true;
    }

    @Override
    public Cliente consultar(Long valor) {
        return null;
    }

    @Override
    public void excluir(Long valor) {

    }

    @Override
    public void alterar(Persistente entity) throws TipoChaveNaoEncontradaException {

    }
}

