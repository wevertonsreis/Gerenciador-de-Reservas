package br.com.gerenciador.reserva.service;

import java.io.Serializable;
import java.util.List;

import javax.persistence.NoResultException;

import br.com.gerenciador.reserva.bo.Voo;
import br.com.gerenciador.reserva.dao.VooDAO;
import br.com.gerenciador.reserva.dao.impl.VooDAOImpl;
import br.com.gerenciador.reserva.exception.RegraNegocioException;
import br.com.gerenciador.reserva.service.validator.VooValidator;
import br.com.gerenciador.reserva.util.JPAUtil;

public class VooService implements Serializable {
	
	private static final long serialVersionUID = 5284110507063108052L;
	
	private VooDAO vooDAO;

	public VooService() {
		vooDAO = new VooDAOImpl();
	}
	
	public Voo buscarVooPorId(Long id) throws Exception {
		return vooDAO.buscarPorId(id);
	}
	
	public Voo buscarVooPorNumero(String numero) throws Exception {
		Voo voo = null;
		try {
			voo = vooDAO.buscarPorNumero(numero);
		} catch (NoResultException nre) {
			return null;
		}
		return voo;
	}
	
	public Voo inserirVoo(Voo voo) throws Exception {
		VooValidator validator = new VooValidator(vooDAO, voo);
		JPAUtil.getEntityTransaction().begin();
		try {
			validator.validar();
			vooDAO.inserir(voo);	
		} catch (RegraNegocioException rne){
			JPAUtil.getEntityTransaction().rollback();
			throw rne;
		} catch (Exception e) {
			JPAUtil.getEntityTransaction().rollback();
			e.printStackTrace();
			throw new Exception("Falha ao inserir Voo");
		}
		JPAUtil.getEntityTransaction().commit();
		return voo;
	}
	
	public Voo atualizarVoo(Voo voo) throws Exception {
		VooValidator validator = new VooValidator(vooDAO, voo);
		JPAUtil.getEntityTransaction().begin();
		try {
			validator.validar();
			voo = vooDAO.atualizar(voo);
		} catch (RegraNegocioException rne){
			JPAUtil.getEntityTransaction().rollback();
			throw rne;
		} catch (Exception e) {
			JPAUtil.getEntityTransaction().rollback();
			e.printStackTrace();
			throw new Exception("Falha ao atualizar Voo");
		}
		JPAUtil.getEntityTransaction().commit();
		return voo;
	}
	
	public void deletarVoo(Voo voo) throws Exception {
		JPAUtil.getEntityTransaction().begin();
		try {
			vooDAO.deletar(voo);
		} catch (Exception e) {
			JPAUtil.getEntityTransaction().rollback();
			e.printStackTrace();
			throw new Exception("Falha ao deletar Voo");
		}
		JPAUtil.getEntityTransaction().commit();
	}
	
	public List<Voo> buscarTodosVoo() throws Exception {
		return vooDAO.buscarTodos();
	}
	
}