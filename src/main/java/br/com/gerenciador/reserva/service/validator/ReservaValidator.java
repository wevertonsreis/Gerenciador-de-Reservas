package br.com.gerenciador.reserva.service.validator;

import br.com.gerenciador.reserva.bo.Reserva;
import br.com.gerenciador.reserva.exception.RegraNegocioException;

public class ReservaValidator {
	
	private Reserva reserva;
	
	public ReservaValidator(Reserva reserva) {
		super();
		this.reserva = reserva;
	}

	public void validar() throws Exception {
		if(reserva.getVoo().getAcentosDisponiveis() < 1){
			throw new RegraNegocioException("Voo não possui acentos disponéveis para reserva.");
		}
	}
	
}
