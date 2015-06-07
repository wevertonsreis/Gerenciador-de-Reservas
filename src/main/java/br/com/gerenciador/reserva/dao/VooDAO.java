package br.com.gerenciador.reserva.dao;

import java.util.List;

import br.com.gerenciador.reserva.bo.Voo;

public interface VooDAO {
	
	public Voo buscarPorId(Object id) throws Exception;
	
	public void inserir(Voo voo) throws Exception;
	
	public Voo atualizar(Voo voo) throws Exception;
	
	public void deletar(Voo voo) throws Exception;
	
	public List<Voo> buscarTodos() throws Exception;
	
	public Voo buscarPorNumero(String numeroVoo) throws Exception;
}
