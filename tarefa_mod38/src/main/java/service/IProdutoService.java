package service;

public interface IProdutoService extends IGenericService<Produto, String> {

    List<Produto> filtrarProdutos(String query);

}
