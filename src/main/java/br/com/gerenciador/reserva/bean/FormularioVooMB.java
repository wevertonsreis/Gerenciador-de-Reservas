package br.com.gerenciador.reserva.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.gerenciador.reserva.bo.Voo;
import br.com.gerenciador.reserva.exception.RegraNegocioException;
import br.com.gerenciador.reserva.service.VooService;
import br.com.gerenciador.reserva.util.FacesMessageUtil;

@ManagedBean
@ViewScoped
public class FormularioVooMB implements Serializable {

	private static final long serialVersionUID = 2166970580437803531L;

	private VooService vooService;
	private Voo voo;
	
	@PostConstruct
	public void init() {
		vooService = new VooService();
	}

	public void preparaFormulario() {
		if(voo == null){
			voo = new Voo();
		}
	}
	
	public String salvar() {
		try {
			vooService.inserirVoo(voo);
			FacesMessageUtil.adicionarMensagemDeSucesso();
		} catch (RegraNegocioException rne){
			FacesMessageUtil.adicionarMensagem(null, FacesMessage.SEVERITY_WARN, FacesMessageUtil.TITULO_AVISO_PADRAO, rne.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			FacesMessageUtil.adicionarMensagemDeErro();
		}
		return null;
	}
	
	public String atualizar() {
		try {
			vooService.atualizarVoo(voo);
			FacesMessageUtil.adicionarMensagemDeSucesso();
		} catch (RegraNegocioException rne){
			FacesMessageUtil.adicionarMensagem(null, FacesMessage.SEVERITY_WARN, FacesMessageUtil.TITULO_AVISO_PADRAO, rne.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			FacesMessageUtil.adicionarMensagemDeErro();
		}
		return null;
	}
	
	public boolean isInclusao() {
		if(voo != null && voo.getId() != null){
			return false;
		}
		return true;
	}
	
	public boolean isEdicao() {
		if(isInclusao()){
			return false;
		}
		return true;
	}
	
	public Voo getVoo() {
		return voo;
	}

	public void setVoo(Voo voo) {
		this.voo = voo;
	}
	
}