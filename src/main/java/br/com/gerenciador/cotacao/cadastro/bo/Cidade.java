package br.com.gerenciador.cotacao.cadastro.bo;

import javax.persistence.Entity;

import br.com.gerenciador.cotacao.generico.bo.GenericoBO;

@Entity
public class Cidade extends GenericoBO {

	private static final long serialVersionUID = 1L;
	
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}