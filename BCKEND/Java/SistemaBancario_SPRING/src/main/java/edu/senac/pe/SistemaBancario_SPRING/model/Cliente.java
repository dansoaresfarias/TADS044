package edu.senac.pe.SistemaBancario_SPRING.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Cliente {
	@Id
    @Column(nullable = false, length = 14, name = "cpf")
    private String cpf;

    @Column(nullable = false, length = 100, name = "nome")
    private String nome;

    @Column(nullable = false, columnDefinition = "date", name = "dataNasc")
    private String dataNasc;

    @Column(nullable = false, columnDefinition = "int", name = "rg")
    private Integer rg;

    @Column(nullable = false, length = 45, unique = true, name = "email")
    private String email;

    @Column(nullable = false, length = 25, unique = true, name = "telefone")
    private String telefone;

    // Construtor padrão exigido pelo JPA
    public Cliente() {
    }

    // Construtor completo (mantém o seu original)
    public Cliente(String nome, String cpf, String dataNasc, Integer rg, String email, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
        this.rg = rg;
        this.email = email;
        this.telefone = telefone;
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
