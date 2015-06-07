package br.com.gerenciador.reserva.dao;

import br.com.gerenciador.reserva.bo.Passageiro;

public interface PassageiroDAO {

	public void inserir(Passageiro entidade) throws Exception;
	
	public Passageiro buscarPorCPF(String cpf) throws Exception;
	
}
