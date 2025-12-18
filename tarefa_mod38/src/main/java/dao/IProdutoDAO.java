package dao;

public interface IProdutoDAO extends IGenericDAO<Produto, String>{

    List<Produto> filtrarProdutos(String query);

}
