package br.com.gerenciador.cotacao.cadastro.cidade.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.gerenciador.cotacao.cadastro.bo.Cidade;
import br.com.gerenciador.cotacao.cadastro.cidade.service.CidadeService;
import br.com.gerenciador.cotacao.cadastro.cidade.service.CidadeServiceLocal;
import br.com.gerenciador.cotacao.util.FacesMessageUtil;

@ManagedBean
@ViewScoped
public class FormularioCidadeMB implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private CidadeServiceLocal cidadeService;
	
	private Cidade cidade;
	
	@PostConstruct
	public void init() {
		cidadeService = new CidadeService();
		cidade = new Cidade();
	}

	public String salvar() {
		try {
			cidadeService.inserirCidade(cidade);
			cidade = new Cidade();
			FacesMessageUtil.adicionarMensagemDeSucesso();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

}