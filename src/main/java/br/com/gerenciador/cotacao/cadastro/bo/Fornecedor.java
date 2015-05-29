package br.com.gerenciador.cotacao.cadastro.bo;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import br.com.gerenciador.cotacao.generico.bo.GenericoBO;

@Entity
public class Fornecedor extends GenericoBO {

	private static final long serialVersionUID = 1L;
	
	private String nome;
	
	@ManyToOne
	private Cidade cidade;
	
	private String telefone;
	
	private String email;
	
	@ManyToOne
	private Usuario usuario;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Cidade getCidade() {
		return cidade;
	}
	
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}