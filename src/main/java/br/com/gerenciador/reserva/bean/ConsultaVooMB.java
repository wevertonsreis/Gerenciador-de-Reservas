package br.com.gerenciador.reserva.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.gerenciador.reserva.bo.Voo;
import br.com.gerenciador.reserva.service.VooService;
import br.com.gerenciador.reserva.util.FacesMessageUtil;

@ManagedBean
@ViewScoped
public class ConsultaVooMB implements Serializable {

	private static final long serialVersionUID = 5372263029471316409L;
	
	private VooService vooService;
	private String numeroVoo;
	private List<Voo> listaDeVoo;
	
	@PostConstruct
	public void init() {
		vooService = new VooService();
		listaDeVoo = new ArrayList<Voo>();
	}
	
	public String pesquisar() {
		try {
			listaDeVoo.clear();	
			if(numeroVoo != null && !numeroVoo.isEmpty()){
				Voo voo = vooService.buscarVooPorNumero(numeroVoo);
				if(voo != null){
					listaDeVoo.add(voo);					
				}
			}else {
				listaDeVoo = vooService.buscarTodosVoo();
			}	
			if(listaDeVoo.isEmpty()){
				FacesMessageUtil.adicionarMensagem(null, FacesMessage.SEVERITY_WARN, FacesMessageUtil.TITULO_AVISO_PADRAO, FacesMessageUtil.DETALHE_NENHUM_RESULTADO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			FacesMessageUtil.adicionarMensagemDeErro();
		}
		return null;
	}
	
	public String deletar(Voo voo) {
		try {
			vooService.deletarVoo(voo);
			listaDeVoo.remove(voo);
			FacesMessageUtil.adicionarMensagemDeSucesso();
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

	public List<Voo> getListaDeVoo() {
		return listaDeVoo;
	}

	public void setListaDeVoo(List<Voo> listaDeVoo) {
		this.listaDeVoo = listaDeVoo;
	}
	
}