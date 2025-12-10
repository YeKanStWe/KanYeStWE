package main.dao;

import main.domain.Cliente;
import main.jdbc.ConnectionFactory;

import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements IClienteDAO {

    @Override
    public Integer cadastrar(Cliente cliente) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = getSqlInsert();
            stm = connection.prepareStatement(sql);
            adicionarParametrosInsert(stm, cliente);
            return stm.executeUpdate();
        } catch(Exception e) {
            throw e;
        } finally {
            closeConnection(connection, stm, null);
        }
    }

    @Override
    public Integer atualizar(Cliente cliente) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = getSqlUpdate();
            stm = connection.prepareStatement(sql);
            adicionarParametrosUpdate(stm, cliente);
            return stm.executeUpdate();
        } catch(Exception e) {
            throw e;
        } finally {
            closeConnection(connection, stm, null);
        }
    }

    @Override
    public Cliente buscar(String cpf) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Cliente cliente = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = getSqlSelect();
            stm = connection.prepareStatement(sql);
            adicionarParametrosSelect(stm, cpf);
            rs = stm.executeQuery();

            if (rs.next()) {
                cliente = new Cliente();
                Long id = rs.getLong("ID");
                String nome = rs.getString("NOME");
                String cpfRs = rs.getString("CPF");
                cliente.setId(id);
                cliente.setNome(nome);
                cliente.setCpf(cpfRs);
            }
        } catch(Exception e) {
            throw e;
        } finally {
            closeConnection(connection, stm, rs);
        }
        return cliente;
    }

    @Override
    public Integer excluir(Cliente cliente) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = getSqlDelete();
            stm = connection.prepareStatement(sql);
            adicionarParametrosDelete(stm, cliente);
            return stm.executeUpdate();
        } catch(Exception e) {
            throw e;
        } finally {
            closeConnection(connection, stm, null);
        }
    }

    @Override
    public List<Cliente> buscarTodos() throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Cliente> list = new ArrayList<>();
        Cliente cliente = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = getSqlSelectAll();
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                cliente = new Cliente();
                Long id = rs.getLong("ID");
                String nome = rs.getString("NOME");
                String cpf = rs.getString("CPF");
                cliente.setId(id);
                cliente.setNome(nome);
                cliente.setCpf(cpf);
                list.add(cliente);
            }
        } catch(Exception e) {
            throw e;
        } finally {
            closeConnection(connection, stm, rs);
        }
        return list;
    }

    private String getSqlInsert() {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO TB_CLIENTE_2 (ID, CPF, NOME) ");
        sb.append("VALUES (nextval('SQ_CLIENTE_2'), ?, ?)");
        return sb.toString();
    }

    private void adicionarParametrosInsert(PreparedStatement stm, Cliente cliente) throws SQLException {
        stm.setString(1, cliente.getCpf());
        stm.setString(2, cliente.getNome());
    }

    private String getSqlUpdate() {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE TB_CLIENTE_2 ");
        sb.append("SET NOME = ?, CPF = ? ");
        sb.append("WHERE ID = ?");
        return sb.toString();
    }

    private void adicionarParametrosUpdate(PreparedStatement stm, Cliente cliente) throws SQLException {
        stm.setString(1, cliente.getNome());
        stm.setString(2, cliente.getCpf());
        stm.setLong(3, cliente.getId());
    }

    private String getSqlDelete() {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM TB_CLIENTE_2 ");
        sb.append("WHERE CPF = ?");
        return sb.toString();
    }

    private void adicionarParametrosDelete(PreparedStatement stm, Cliente cliente) throws SQLException {
        stm.setString(1, cliente.getCpf());
    }

    private String getSqlSelect() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM TB_CLIENTE_2 ");
        sb.append("WHERE CPF = ?");
        return sb.toString();
    }

    private void adicionarParametrosSelect(PreparedStatement stm, String cpf) throws SQLException {
        stm.setString(1, cpf);
    }

    private String getSqlSelectAll() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM TB_CLIENTE_2");
        return sb.toString();
    }

    private void closeConnection(Connection connection, PreparedStatement stm, ResultSet rs) {
        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            if (stm != null && !stm.isClosed()) {
                stm.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
}
