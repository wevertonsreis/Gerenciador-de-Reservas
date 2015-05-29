package br.com.gerenciador.cotacao.cadastro.cidade.dao;

import javax.persistence.EntityManager;

import br.com.gerenciador.cotacao.cadastro.bo.Cidade;
import br.com.gerenciador.cotacao.cadastro.cidade.dao.CidadeDAO;
import br.com.gerenciador.cotacao.generico.dao.GenericoDAO;

public class CidadeDAO extends GenericoDAO<Cidade> {

	public CidadeDAO(EntityManager entityManager) {
		super(Cidade.class, entityManager);
	}

}
