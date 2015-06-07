package br.com.gerenciador.reserva.dao.impl;

import javax.persistence.TypedQuery;

import br.com.gerenciador.reserva.bo.Passageiro;
import br.com.gerenciador.reserva.dao.PassageiroDAO;
import br.com.gerenciador.reserva.generico.dao.GenericoDAO;
import br.com.gerenciador.reserva.util.JPAUtil;

public class PassageiroDAOImpl extends GenericoDAO<Passageiro> implements PassageiroDAO {

	public PassageiroDAOImpl() {
		super(Passageiro.class, JPAUtil.getEntityManager());
	}

	@Override
	public Passageiro buscarPorCPF(String cpf) throws Exception {
		StringBuilder builderQuery = new StringBuilder();
		builderQuery.append("FROM Passageiro passageiro").append(" ");
		builderQuery.append("WHERE passageiro.cpf :cpf");
		TypedQuery<Passageiro> query = entityManager.createQuery(builderQuery.toString(), Passageiro.class);
		query.setParameter("cpf", cpf);
		return query.getSingleResult();
	}

}
