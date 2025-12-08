package test;

import main.dao.IClienteDAO;
import main.domain.Cliente;
import main.exception.TipoChaveNaoEncontradaException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import test.dao.ClienteDaoMock;

public class ClienteDAOTest {
    private IClienteDAO clienteDao;
    private Cliente cliente;
    public ClienteDAOTest(){
        clienteDao = new ClienteDaoMock();
    }
    @Before
    public void init() throws TipoChaveNaoEncontradaException {
        cliente = new Cliente();
        cliente.setCpf(12345678910L);
        cliente.setNome("alfonso");
        cliente.setTelefone(12345678L);
        cliente.setEndereco("rua muritiba");
        cliente.setNumero(12);
        cliente.setCidade("curitiba");
        cliente.setEstado("parana");
        clienteDao.cadastrar(cliente);
    }
    @Test
    public void pesquisarCliente(){
        Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());

        Assert.assertNotNull(clienteConsultado);
    }
    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException {
        boolean retorno = clienteDao.cadastrar(cliente);
        Assert.assertTrue(retorno);
    }

    @Test
    public void excluirCliente(){
        clienteDao.excluir(cliente.getCpf());
    }
    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("pedro");
        clienteDao.alterar(cliente);
        Assert.assertEquals("pedro",cliente.getNome());
    }
}