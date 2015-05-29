package br.com.gerenciador.cotacao.cotacao.bo;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import br.com.gerenciador.cotacao.cadastro.bo.Produto;
import br.com.gerenciador.cotacao.generico.bo.GenericoBO;

@Entity
public class ItemProduto extends GenericoBO {
	
	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Produto produto;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	private Cotacao cotacao;
	
	private Integer quantidade;
	
	private BigDecimal valor;

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Cotacao getCotacao() {
		return cotacao;
	}

	public void setCotacao(Cotacao cotacao) {
		this.cotacao = cotacao;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
}