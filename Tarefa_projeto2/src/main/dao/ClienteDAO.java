package main.dao;

import main.dao.generics.GenericDAO;
import main.domain.Cliente;

public class ClienteDAO extends GenericDAO<Cliente> implements IClienteDAO {
    @Override
    public Class<Cliente> getTipoClasse() {
        return null;
    }

    @Override
    public void atualizarDados(Cliente entity, Cliente entityCadastrado) {

    }
}
