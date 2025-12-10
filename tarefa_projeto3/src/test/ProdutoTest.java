package test;

import main.dao.IProdutoDAO;
import main.dao.ProdutoDAO;
import main.domain.Produto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProdutoTest {

    private IProdutoDAO produtoDAO;

    @Test
    public void cadastrarTest() throws Exception {
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("100");
        produto.setNome("Teclado");
        produto.setPreco(150.00);

        Integer countCad = produtoDAO.cadastrar(produto);
        assertTrue(countCad == 1);

        Produto produtoBD = produtoDAO.buscar("100");
        assertNotNull(produtoBD);
        assertEquals("100", produtoBD.getCodigo());
        assertEquals("Teclado", produtoBD.getNome());
        assertEquals(150.00, produtoBD.getPreco());

        Integer countDel = produtoDAO.excluir(produtoBD);
        assertTrue(countDel == 1);
    }

    @Test
    public void buscarTest() throws Exception {
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("100");
        produto.setNome("Teclado");
        produto.setPreco(150.00);

        Integer countCad = produtoDAO.cadastrar(produto);
        assertTrue(countCad == 1);

        Produto produtoBD = produtoDAO.buscar("100");
        assertNotNull(produtoBD);
        assertEquals("100", produtoBD.getCodigo());
        assertEquals("Teclado", produtoBD.getNome());
        assertEquals(150.00, produtoBD.getPreco());

        Integer countDel = produtoDAO.excluir(produtoBD);
        assertTrue(countDel == 1);
    }

    @Test
    public void excluirTest() throws Exception {
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("100");
        produto.setNome("Teclado");
        produto.setPreco(150.00);

        assertTrue(produtoDAO.cadastrar(produto) == 1);

        Produto produtoBD = produtoDAO.buscar("100");
        assertNotNull(produtoBD);

        assertTrue(produtoDAO.excluir(produtoBD) == 1);

        assertNull(produtoDAO.buscar("100"));
    }

    @Test
    public void buscarTodosTest() throws Exception {
        produtoDAO = new ProdutoDAO();

        Produto p1 = new Produto();
        p1.setCodigo("100");
        p1.setNome("Teclado");
        p1.setPreco(150.00);
        assertTrue(produtoDAO.cadastrar(p1) == 1);

        Produto p2 = new Produto();
        p2.setCodigo("200");
        p2.setNome("Mouse");
        p2.setPreco(80.00);
        assertTrue(produtoDAO.cadastrar(p2) == 1);

        List<Produto> list = produtoDAO.buscarTodos();
        assertNotNull(list);
        assertEquals(2, list.size());

        int countDel = 0;
        for (Produto prod : list) {
            produtoDAO.excluir(prod);
            countDel++;
        }
        assertEquals(2, countDel);

        list = produtoDAO.buscarTodos();
        assertEquals(0, list.size());
    }

    @Test
    public void atualizarTest() throws Exception {
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("100");
        produto.setNome("Teclado");
        produto.setPreco(150.00);

        assertTrue(produtoDAO.cadastrar(produto) == 1);

        Produto produtoBD = produtoDAO.buscar("100");
        assertNotNull(produtoBD);

        produtoBD.setCodigo("200");
        produtoBD.setNome("Teclado Gamer");
        produtoBD.setPreco(350.00);

        assertTrue(produtoDAO.atualizar(produtoBD) == 1);

        assertNull(produtoDAO.buscar("100"));

        Produto novoBD = produtoDAO.buscar("200");
        assertNotNull(novoBD);
        assertEquals("200", novoBD.getCodigo());
        assertEquals("Teclado Gamer", novoBD.getNome());
        assertEquals(350.00, novoBD.getPreco());

        List<Produto> list = produtoDAO.buscarTodos();
        for (Produto prod : list) {
            produtoDAO.excluir(prod);
        }
    }
}
