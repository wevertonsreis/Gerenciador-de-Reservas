package br.com.gerenciador.reserva.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.gerenciador.reserva.bo.Reserva;
import br.com.gerenciador.reserva.dao.ReservaDAO;
import br.com.gerenciador.reserva.generico.dao.GenericoDAO;
import br.com.gerenciador.reserva.util.JPAUtil;

public class ReservaDAOImpl extends GenericoDAO<Reserva> implements ReservaDAO {

	public ReservaDAOImpl() {
		super(Reserva.class, JPAUtil.getEntityManager());
	}

	@Override
	public List<Reserva> buscarPorNumeroVoo(String numeroVoo) throws Exception {
		StringBuilder builderQuery = new StringBuilder();
		builderQuery.append("FROM Reserva reserva").append(" ");
		builderQuery.append("WHERE reserva.voo.numero = :numero");
		TypedQuery<Reserva> query = entityManager.createQuery(builderQuery.toString(), Reserva.class);
		query.setParameter("numero", numeroVoo);
		return query.getResultList();
	}

}
