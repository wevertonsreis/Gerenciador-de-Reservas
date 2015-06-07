package br.com.gerenciador.reserva.service;

import br.com.gerenciador.reserva.bo.Passageiro;
import br.com.gerenciador.reserva.dao.PassageiroDAO;
import br.com.gerenciador.reserva.dao.impl.PassageiroDAOImpl;
import br.com.gerenciador.reserva.util.JPAUtil;

public class PassageiroService {
	
	private PassageiroDAO passageiroDAO;

	public PassageiroService() {
		this.passageiroDAO = new PassageiroDAOImpl();
	}
	
	public Passageiro inserirPassageiro(Passageiro passageiro) throws Exception {
		JPAUtil.getEntityTransaction().begin();
		try {
			passageiroDAO.inserir(passageiro);
		} catch (Exception e) {
			JPAUtil.getEntityTransaction().rollback();
			e.printStackTrace();
			throw new Exception("Falha ao inserir o Passageiro");
		}
		JPAUtil.getEntityTransaction().commit();
		return passageiro;
	}
	
	public Passageiro buscarPassageiroPorCPF(String cpf) throws Exception {
		return passageiroDAO.buscarPorCPF(cpf);
	}
	
}
