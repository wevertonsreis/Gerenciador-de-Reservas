package br.com.gerenciador.cotacao.cadastro.bo;

import java.math.BigDecimal;

import javax.persistence.Entity;

import br.com.gerenciador.cotacao.generico.bo.GenericoBO;

@Entity
public class Produto extends GenericoBO {

	private static final long serialVersionUID = 1L;
	
	private String nome;
	
	private String descricao;
	
	private BigDecimal precoBase;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPrecoBase() {
		return precoBase;
	}

	public void setPrecoBase(BigDecimal precoBase) {
		this.precoBase = precoBase;
	}

}