package br.com.gerenciador.reserva.bo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import br.com.gerenciador.reserva.generico.bo.GenericoBO;

@Entity
public class Voo extends GenericoBO {

	private static final long serialVersionUID = 2632293462572191599L;

	private String numero;
	
	private String origem;
	
	private String destino;
	
	private Integer acentosDisponiveis;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "voo_id")
	private List<Reserva> reservas;
	
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public Integer getAcentosDisponiveis() {
		return acentosDisponiveis;
	}

	public void setAcentosDisponiveis(Integer acentosDisponiveis) {
		this.acentosDisponiveis = acentosDisponiveis;
	}
	
}