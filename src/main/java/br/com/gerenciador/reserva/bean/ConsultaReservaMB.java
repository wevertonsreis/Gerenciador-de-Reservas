package br.com.gerenciador.reserva.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.gerenciador.reserva.bo.Reserva;
import br.com.gerenciador.reserva.service.ReservaService;
import br.com.gerenciador.reserva.util.FacesMessageUtil;

@ManagedBean
@ViewScoped
public class ConsultaReservaMB implements Serializable {

	private static final long serialVersionUID = 840848370181804352L;

	private ReservaService reservaService;
	private String numeroVoo;
	private List<Reserva> listaDeReserva;
	
	@PostConstruct
	public void init() {
		reservaService = new ReservaService();
	}
	
	public String pesquisar() {
		try {
			listaDeReserva = reservaService.buscarReservaPorNumeroVoo(numeroVoo);
			
			if(listaDeReserva.isEmpty()){
				FacesMessageUtil.adicionarMensagem(null, FacesMessage.SEVERITY_WARN, FacesMessageUtil.TITULO_AVISO_PADRAO, FacesMessageUtil.DETALHE_NENHUM_RESULTADO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			FacesMessageUtil.adicionarMensagemDeErro();
		}
		return null;
	}
	
	public String getNumeroVoo() {
		return numeroVoo;
	}
	
	public void setNumeroVoo(String numeroVoo) {
		this.numeroVoo = numeroVoo;
	}
	
	public List<Reserva> getListaDeReserva() {
		return listaDeReserva;
	}
	
	public void setListaDeReserva(List<Reserva> listaDeReserva) {
		this.listaDeReserva = listaDeReserva;
	}
	
}