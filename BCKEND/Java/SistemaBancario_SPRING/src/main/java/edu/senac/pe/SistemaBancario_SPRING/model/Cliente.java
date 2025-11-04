package edu.senac.pe.SistemaBancario_SPRING.model;

public class Cliente {
	private String nome;
	private String cpf;
	private String dataNasc;
	private Integer rg;
	private String email;
	private String telefone;
	// private Endereco endereco;

	public Cliente(String nome, String cpf, String dataNasc, Integer rg, String email, String telefone) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.dataNasc = dataNasc;
		this.rg = rg;
		this.email = email;
		this.telefone = telefone;
		// this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/*public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}*/

	public String getCpf() {
		return cpf;
	}

	public String getDataNasc() {
		return dataNasc;
	}

	public Integer getRg() {
		return rg;
	}

	@Override
	public String toString() {
		return "Cliente, " + nome + ", CPF: " + cpf + ", nacido em " + dataNasc + ", portador do RG: " + rg + ", e-mail: " + email + ", telefone: "
				+ telefone; // + ", endereco: " + endereco;
	}
}
