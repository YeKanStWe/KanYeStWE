package dao;

public interface IClienteDAO extends IGenericDAO<Cliente, Long>{

    List<Cliente> filtrarClientes(String query);

}