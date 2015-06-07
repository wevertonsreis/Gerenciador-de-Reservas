package br.com.gerenciador.reserva.dao;

import java.util.List;

import br.com.gerenciador.reserva.bo.Reserva;

public interface ReservaDAO {
	
	public void inserir(Reserva reserva) throws Exception;
	
	public List<Reserva> buscarPorNumeroVoo(String numeroVoo) throws Exception;
	
}
