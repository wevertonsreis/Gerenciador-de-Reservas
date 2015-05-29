package br.com.gerenciador.cotacao.cotacao.bo;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import br.com.gerenciador.cotacao.generico.bo.GenericoBO;

@Entity
public class SolicitacaoCotacao extends GenericoBO {
	
	private static final long serialVersionUID = 1L;

	private Date dataInicio;
	
	private Date dataFim;
	
	@OneToMany
	@JoinColumn(name = "solicitacao_id")
	private List<Cotacao> listaDeCotacoes;
	
	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	
	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public List<Cotacao> getListaDeCotacoes() {
		return listaDeCotacoes;
	}

	public void setListaDeCotacoes(List<Cotacao> listaDeCotacoes) {
		this.listaDeCotacoes = listaDeCotacoes;
	}
	
}
