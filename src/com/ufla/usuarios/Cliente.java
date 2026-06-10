package com.ufla.usuarios;

import com.ufla.compras.Carrinho;
import java.time.LocalDate;

public class Cliente extends Usuario{
	private String cpf;
	private String telefone;
	private String endereco;
	private Carrinho carrinho;
	
	public Cliente(int id, String nomeUsuario, String email, String senha, String cpf, String telefone, String endereco) {
		super(id, nomeUsuario, email, senha);
		this.cpf = cpf;
		this.telefone = telefone;
		this.endereco = endereco;
		this.carrinho = new Carrinho(id, LocalDate.now().toString());
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
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Carrinho getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}

	public void cadastrar() {
		System.out.println("Cliente cadastrado.");
	}
	public void atualizar() {
		System.out.println("Cliente atualizado.");
	}

}
