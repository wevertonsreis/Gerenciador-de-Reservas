package br.com.gerenciador.reserva.service.validator;

import javax.persistence.NoResultException;

import br.com.gerenciador.reserva.bo.Voo;
import br.com.gerenciador.reserva.dao.VooDAO;
import br.com.gerenciador.reserva.exception.RegraNegocioException;

public class VooValidator {
	
	private VooDAO vooDAO;
	private Voo voo;
	
	public VooValidator(VooDAO vooDAO, Voo voo) {
		super();
		this.vooDAO = vooDAO;
		this.voo = voo;
	}

	public void validar() throws Exception {
		try {
			Voo outroVoo = vooDAO.buscarPorNumero(voo.getNumero());
			if(outroVoo != null && !outroVoo.equals(voo)){
				throw new RegraNegocioException("Já existe outro Voo com esse número.");
			}
		} catch (NoResultException nre) {
			return;
		}
	}
	
}
