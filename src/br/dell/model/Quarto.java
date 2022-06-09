package br.dell.model;

public class Quarto {
	private String numero;
	private Hospede hospede;
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Hospede getHospede() {
		return hospede;
	}
	public void setHospede(Hospede hospede) {
		this.hospede = hospede;
	}
	public Quarto(String numero, Hospede hospede) {
		super();
		this.numero = numero;
		hospede = hospede;
	}
	public Quarto() {

	}
	
	
	

}
