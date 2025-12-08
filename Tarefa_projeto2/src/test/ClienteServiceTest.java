package test;

import main.dao.IClienteDAO;
import main.domain.Cliente;
import main.exception.TipoChaveNaoEncontradaException;
import main.services.ClienteService;
import main.services.IClienteService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import test.dao.ClienteDaoMock;
import test.service.ClienteServiceMock;

public class ClienteServiceTest {

    private IClienteService clienteService;

    private Cliente cliente;
    public ClienteServiceTest(){
    clienteService = new ClienteServiceMock();
    }
    @Before
    public void init() throws TipoChaveNaoEncontradaException {
        cliente = new Cliente();
        cliente.setCpf(12345678910L);
        cliente.setNome("alfonso");
        cliente.setNumero(12345678);
        cliente.setEndereco("rua muritiba");
        cliente.setNumero(12);
        cliente.setCidade("curitiba");
        cliente.setEstado("parana");
        clienteService.cadastrar(cliente);
    }
    @Test
    public void pesquisarCliente(){
        Cliente clienteConsultado = clienteService.consultar(cliente.getCpf());

        Assert.assertNotNull(clienteConsultado);
    }
    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException {
        boolean retorno = clienteService.cadastrar(cliente);
        Assert.assertTrue(retorno);
    }
    @Test
    public void excluirCliente(){
        clienteService.excluir(cliente.getCpf());
    }
    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("pedro");
        clienteService.alterar(cliente);
        Assert.assertEquals("pedro",cliente.getNome());
    }
}
