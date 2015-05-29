package br.com.gerenciador.cotacao.cadastro.produto.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.gerenciador.cotacao.cadastro.bo.Produto;

@ManagedBean
@ViewScoped
public class FormularioProdutoMB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Produto produto;
	
	@PostConstruct
	public void init() {
		produto = new Produto();
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
}