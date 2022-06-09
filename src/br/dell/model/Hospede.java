package br.dell.model;

public class Hospede {
	private String CPF;
	private String RG;
	private String nome;
	private int idade;
	private String endereco;
	
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public String getRG() {
		return RG;
	}
	public void setRG(String rG) {
		RG = rG;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Hospede(String cPF, String rG, String nome, int idade, String endereco) {
		super();
		CPF = cPF;
		RG = rG;
		this.nome = nome;
		this.idade = idade;
		this.endereco = endereco;
	}
	public Hospede() {
	}
	
	
}
