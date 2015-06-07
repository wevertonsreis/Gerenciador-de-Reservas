package br.com.gerenciador.reserva.dao.impl;

import javax.persistence.TypedQuery;

import br.com.gerenciador.reserva.bo.Voo;
import br.com.gerenciador.reserva.dao.VooDAO;
import br.com.gerenciador.reserva.generico.dao.GenericoDAO;
import br.com.gerenciador.reserva.util.JPAUtil;

public class VooDAOImpl extends GenericoDAO<Voo> implements VooDAO {

	public VooDAOImpl() {
		super(Voo.class, JPAUtil.getEntityManager());
	}

	@Override
	public Voo buscarPorNumero(String numeroVoo) throws Exception {
		StringBuilder builderQuery = new StringBuilder();
		builderQuery.append("FROM Voo voo").append(" ");
		builderQuery.append("WHERE voo.numero = :numero");
		TypedQuery<Voo> query = entityManager.createQuery(builderQuery.toString(), Voo.class);
		query.setParameter("numero", numeroVoo);
		return query.getSingleResult();
	}

}
