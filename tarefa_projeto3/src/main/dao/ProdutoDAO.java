package main.dao;

import main.domain.Produto;
import main.jdbc.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO implements IProdutoDAO {

    @Override
    public Integer cadastrar(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = getSqlInsert();
            stm = connection.prepareStatement(sql);
            adicionarParametrosInsert(stm, produto);
            return stm.executeUpdate();
        } finally {
            closeConnection(connection, stm, null);
        }
    }

    @Override
    public Integer atualizar(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = getSqlUpdate();
            stm = connection.prepareStatement(sql);
            adicionarParametrosUpdate(stm, produto);
            return stm.executeUpdate();
        } finally {
            closeConnection(connection, stm, null);
        }
    }

    @Override
    public Produto buscar(String codigo) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Produto produto = null;

        try {
            connection = ConnectionFactory.getConnection();
            String sql = getSqlSelect();
            stm = connection.prepareStatement(sql);
            adicionarParametrosSelect(stm, codigo);
            rs = stm.executeQuery();

            if (rs.next()) {
                produto = new Produto();
                produto.setId(rs.getLong("ID"));
                produto.setNome(rs.getString("NOME"));
                produto.setCodigo(rs.getString("CODIGO"));
                produto.setPreco(rs.getDouble("PRECO"));
            }

        } finally {
            closeConnection(connection, stm, rs);
        }
        return produto;
    }

    @Override
    public Integer excluir(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;

        try {
            connection = ConnectionFactory.getConnection();
            String sql = getSqlDelete();
            stm = connection.prepareStatement(sql);
            adicionarParametrosDelete(stm, produto);
            return stm.executeUpdate();

        } finally {
            closeConnection(connection, stm, null);
        }
    }

    @Override
    public List<Produto> buscarTodos() throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Produto> lista = new ArrayList<>();

        try {
            connection = ConnectionFactory.getConnection();
            String sql = getSqlSelectAll();
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                Produto p = new Produto();
                p.setId(rs.getLong("ID"));
                p.setNome(rs.getString("NOME"));
                p.setCodigo(rs.getString("CODIGO"));
                p.setPreco(rs.getDouble("PRECO"));
                lista.add(p);
            }

        } finally {
            closeConnection(connection, stm, rs);
        }
        return lista;
    }

    private String getSqlInsert() {
        return "INSERT INTO TB_PRODUTO (ID, CODIGO, NOME, PRECO) VALUES (nextval('SQ_PRODUTO'), ?, ?, ?)";
    }

    private String getSqlUpdate() {
        return "UPDATE TB_PRODUTO SET NOME = ?, CODIGO = ?, PRECO = ? WHERE ID = ?";
    }

    private String getSqlDelete() {
        return "DELETE FROM TB_PRODUTO WHERE CODIGO = ?";
    }

    private String getSqlSelect() {
        return "SELECT * FROM TB_PRODUTO WHERE CODIGO = ?";
    }

    private String getSqlSelectAll() {
        return "SELECT * FROM TB_PRODUTO";
    }

    private void adicionarParametrosInsert(PreparedStatement stm, Produto produto) throws SQLException {
        stm.setString(1, produto.getCodigo());
        stm.setString(2, produto.getNome());
        stm.setDouble(3, produto.getPreco());
    }

    private void adicionarParametrosUpdate(PreparedStatement stm, Produto produto) throws SQLException {
        stm.setString(1, produto.getNome());
        stm.setString(2, produto.getCodigo());
        stm.setDouble(3, produto.getPreco());
        stm.setLong(4, produto.getId());
    }

    private void adicionarParametrosDelete(PreparedStatement stm, Produto produto) throws SQLException {
        stm.setString(1, produto.getCodigo());
    }

    private void adicionarParametrosSelect(PreparedStatement stm, String codigo) throws SQLException {
        stm.setString(1, codigo);
    }

    private void closeConnection(Connection connection, PreparedStatement stm, ResultSet rs) {
        try {
            if (rs != null && !rs.isClosed()) rs.close();
            if (stm != null && !stm.isClosed()) stm.close();
            if (connection != null && !connection.isClosed()) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
