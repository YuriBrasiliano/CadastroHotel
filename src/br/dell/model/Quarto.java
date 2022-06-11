package br.dell.model;

public class Quarto {
	private String numero;
	private Hospede hospede;
	private String dta_entrada;
	private String dta_saida;
	
	public String getDta_entrada() {
		return dta_entrada;
	}
	public void setDta_entrada(String dta_entrada) {
		this.dta_entrada = dta_entrada;
	}
	public String getDta_saida() {
		return dta_saida;
	}
	public void setDta_saida(String dta_saida) {
		this.dta_saida = dta_saida;
	}
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
