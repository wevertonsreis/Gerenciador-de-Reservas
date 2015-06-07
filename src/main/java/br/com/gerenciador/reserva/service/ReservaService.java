package br.com.gerenciador.reserva.service;

import java.util.List;

import br.com.gerenciador.reserva.bo.Passageiro;
import br.com.gerenciador.reserva.bo.Reserva;
import br.com.gerenciador.reserva.dao.PassageiroDAO;
import br.com.gerenciador.reserva.dao.ReservaDAO;
import br.com.gerenciador.reserva.dao.impl.PassageiroDAOImpl;
import br.com.gerenciador.reserva.dao.impl.ReservaDAOImpl;
import br.com.gerenciador.reserva.exception.RegraNegocioException;
import br.com.gerenciador.reserva.service.validator.ReservaValidator;
import br.com.gerenciador.reserva.util.JPAUtil;

public class ReservaService {

	private ReservaDAO reservaDAO;
	private PassageiroDAO passageiroDAO;

	public ReservaService() {
		reservaDAO = new ReservaDAOImpl();
		passageiroDAO = new PassageiroDAOImpl();
	}
	
	public Reserva inserirReserva(Reserva reserva) throws Exception {
		JPAUtil.getEntityTransaction().begin();
		try {
			ReservaValidator validator = new ReservaValidator(reserva);
			validator.validar();
			reserva.getVoo().setAcentosDisponiveis(reserva.getVoo().getAcentosDisponiveis() - 1);
			
			Passageiro passageiro = passageiroDAO.buscarPorCPF(reserva.getPassageiro().getCpf());
			if(passageiro == null){
				passageiroDAO.inserir(reserva.getPassageiro());
			}else{
				reserva.setPassageiro(passageiro);
			}
			reservaDAO.inserir(reserva);
		
		} catch (RegraNegocioException negocioException){
			JPAUtil.getEntityTransaction().rollback();
			throw negocioException;
		} catch (Exception e) {
			JPAUtil.getEntityTransaction().rollback();
			e.printStackTrace();
			throw new Exception("Falha ao inserir a Reserva");
		}
		JPAUtil.getEntityTransaction().commit();
		return reserva;
	}
	
	public List<Reserva> buscarReservaPorNumeroVoo(String numeroVoo) throws Exception {
		return reservaDAO.buscarPorNumeroVoo(numeroVoo);
	}
	
}