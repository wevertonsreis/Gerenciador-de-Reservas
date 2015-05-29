package br.com.gerenciador.cotacao.cadastro.cidade.service;

import br.com.gerenciador.cotacao.cadastro.bo.Cidade;

public interface CidadeServiceLocal {
	
	public Cidade inserirCidade(Cidade cidade) throws Exception;
	
	public Cidade buscarCidadePorId(Long id) throws Exception;
	
}
