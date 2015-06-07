package br.com.gerenciador.reserva.util;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public class FacesMessageUtil {

	public static final String TITULO_SUCESSO_PADRAO = "Sucesso!";
	public static final String DETALHE_SUCESSO_PADRAO = "Ação realizada com sucesso.";
	public static final String TITULO_ERRO_PADRAO = "Erro!";
	public static final String DETALHE_ERRO_PADRAO = "Contate o administrador do sistema.";
	public static final String TITULO_AVISO_PADRAO = "Aviso!";
	public static final String DETALHE_NENHUM_RESULTADO = "Nenhum resultado encontrado.";

	public static FacesMessage adicionarMensagemDeSucesso() {
		return adicionarMensagemDeSucesso(TITULO_SUCESSO_PADRAO, DETALHE_SUCESSO_PADRAO);
	}

	public static FacesMessage adicionarMensagemDeErro() {
		return adicionarMensagemDeErro(TITULO_ERRO_PADRAO, DETALHE_ERRO_PADRAO);
	}

	public static FacesMessage adicionarMensagemDeSucesso(String titulo, String detalhe) {
		return adicionarMensagem(null, FacesMessage.SEVERITY_INFO, titulo, detalhe);
	}

	public static FacesMessage adicionarMensagemDeErro(String titulo, String detalhe) {
		return adicionarMensagem(null, FacesMessage.SEVERITY_ERROR, titulo, detalhe);
	}

	public static FacesMessage adicionarMensagem(String idComponente, Severity nivel, String titulo, String detalhe) {
		FacesMessage facesMessage = new FacesMessage(nivel, titulo, detalhe);
		FacesContext.getCurrentInstance().addMessage(idComponente, facesMessage);
		return facesMessage;
	}

}
