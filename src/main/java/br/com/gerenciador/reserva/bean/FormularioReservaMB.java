package br.com.gerenciador.reserva.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.gerenciador.reserva.bo.Reserva;
import br.com.gerenciador.reserva.service.ReservaService;
import br.com.gerenciador.reserva.util.FacesMessageUtil;

@ManagedBean
@ViewScoped
public class FormularioReservaMB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private ReservaService reservaService;
	private Reserva reserva;
	
	public void init() {
		reservaService = new ReservaService();
	}

	public void preparaFormulario() {
		if(reserva ==  null){
			reserva = new Reserva();
		}
	}
	
	public String salvar() {
		try {
			reservaService.inserirReserva(reserva);
			FacesMessageUtil.adicionarMensagemDeSucesso();
		} catch (Exception e) {
			e.printStackTrace();
			FacesMessageUtil.adicionarMensagemDeErro();
		}
		return null;
	}
	
	public String atualizar() {
		try {
			//TODO IMPLEMENTAR ATUALIZAR
			FacesMessageUtil.adicionarMensagemDeSucesso();
		} catch (Exception e) {
			e.printStackTrace();
			FacesMessageUtil.adicionarMensagemDeErro();
		}
		return null;
	}
	
	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
	
}
