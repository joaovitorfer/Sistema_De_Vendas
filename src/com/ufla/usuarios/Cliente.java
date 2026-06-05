package com.ufla.usuarios;

public class Cliente extends Usuario{
	private String cpf;
	private String telefone;
	private String endereco;
	
	public Cliente(int id, String nomeUsuario, String email, String senha, String cpf, String telefone, String endereco) {
		super(id, nomeUsuario, email, senha);
		this.cpf = cpf;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	//CPF
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	//Telefone
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	//Endereco
	public String getEndereco() {
		return endereco;
	}
	
	public void cadastrar() {
		
	}
	public void atualizar() {
		
	}

}
