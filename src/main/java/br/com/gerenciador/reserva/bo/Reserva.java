package br.com.gerenciador.reserva.bo;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import br.com.gerenciador.reserva.generico.bo.GenericoBO;

@Entity
public class Reserva extends GenericoBO{

	private static final long serialVersionUID = 8144501817082754119L;
	
	@ManyToOne
	private Passageiro passageiro;
	
	@ManyToOne
	private Voo voo;
	
	public Passageiro getPassageiro() {
		return passageiro;
	}

	public void setPassageiro(Passageiro passageiro) {
		this.passageiro = passageiro;
	}

	public Voo getVoo() {
		return voo;
	}

	public void setVoo(Voo voo) {
		this.voo = voo;
	}
	
}