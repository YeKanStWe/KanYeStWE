package dao;

import dao.generic.jpa.GenericJpaDB1DAO;
import domain.ProdutoJpa;

public class ProdutoJpaDAO extends GenericJpaDB1DAO<ProdutoJpa, Long> implements IProdutoJpaDAO {

    public ProdutoJpaDAO() {
        super(ProdutoJpa.class);
    }

}
