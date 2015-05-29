package br.com.gerenciador.cotacao.cotacao.bo;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.com.gerenciador.cotacao.cadastro.bo.Fornecedor;
import br.com.gerenciador.cotacao.generico.bo.GenericoBO;

@Entity
public class Cotacao extends GenericoBO {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	private SolicitacaoCotacao solicitacao;
	
	@ManyToOne
	private Fornecedor fornecedor;
	
	@Enumerated(value = EnumType.STRING)
	private SituacaoCotacao situacao;
	
	@OneToMany
	@JoinColumn(name = "cotacao_id")
	private List<ItemProduto> itemsProdutos;

	private Date prazoPagamento;
	
	private Date prazoEntrega;
	
	private String observacao;

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public SituacaoCotacao getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoCotacao situacao) {
		this.situacao = situacao;
	}

	public List<ItemProduto> getItemsProdutos() {
		return itemsProdutos;
	}

	public void setItemsProdutos(List<ItemProduto> itemsProdutos) {
		this.itemsProdutos = itemsProdutos;
	}

	public Date getPrazoPagamento() {
		return prazoPagamento;
	}

	public void setPrazoPagamento(Date prazoPagamento) {
		this.prazoPagamento = prazoPagamento;
	}

	public Date getPrazoEntrega() {
		return prazoEntrega;
	}

	public void setPrazoEntrega(Date prazoEntrega) {
		this.prazoEntrega = prazoEntrega;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public SolicitacaoCotacao getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(SolicitacaoCotacao solicitacao) {
		this.solicitacao = solicitacao;
	}	
	
}