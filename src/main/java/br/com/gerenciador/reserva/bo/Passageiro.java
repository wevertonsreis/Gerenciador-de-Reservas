package br.com.gerenciador.reserva.bo;

import javax.persistence.Entity;

import br.com.gerenciador.reserva.generico.bo.GenericoBO;

@Entity
public class Passageiro extends GenericoBO {

	private static final long serialVersionUID = 2304741030438567947L;
	
	private String cpf;
	
	private String nome;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}