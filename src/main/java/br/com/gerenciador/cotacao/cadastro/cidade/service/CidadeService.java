package br.com.gerenciador.cotacao.cadastro.cidade.service;

import java.io.Serializable;

import javax.persistence.Persistence;

import br.com.gerenciador.cotacao.cadastro.bo.Cidade;
import br.com.gerenciador.cotacao.cadastro.cidade.dao.CidadeDAO;

public class CidadeService implements CidadeServiceLocal, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private CidadeDAO cidadeDAO;

	public CidadeService() {
		super();
		cidadeDAO = new CidadeDAO(Persistence.createEntityManagerFactory("gerenciador-cotacao").createEntityManager());
	}

	@Override
	public Cidade inserirCidade(Cidade cidade) throws Exception {
		cidadeDAO.inserir(cidade);
		return cidade;
	}
	
	@Override
	public Cidade buscarCidadePorId(Long id) throws Exception {
		return cidadeDAO.buscarPorId(id);
	}

}