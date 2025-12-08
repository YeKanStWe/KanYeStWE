package test.service;

import main.domain.Cliente;
import main.domain.Persistente;
import main.exception.TipoChaveNaoEncontradaException;
import main.services.IClienteService;

public class ClienteServiceMock implements IClienteService {
    @Override
    public Boolean cadastrar(Persistente entity) throws TipoChaveNaoEncontradaException {
        return true;
    }

    @Override
    public Cliente consultar(Long valor) {
        Cliente cliente = new Cliente();
        cliente.setCpf(valor);
        return cliente;
    }

    @Override
    public void excluir(Long valor) {

    }

    @Override
    public void alterar(Persistente entity) throws TipoChaveNaoEncontradaException {

    }
}
