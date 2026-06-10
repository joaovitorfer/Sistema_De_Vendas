package com.ufla.usuarios;

public class Lojista extends Usuario {
	private String cnpj;
	
	public Lojista(int id, String nomeUsuario, String email, String senha, String cnpj) {
		super(id, nomeUsuario, email, senha);
		this.cnpj = cnpj;
	}
	
	//CNPJ
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public void cadastrarProduto() {
		System.out.println("Produto cadastrado.");
	}

	public void atualizarEstoque() {
		System.out.println("Estoque atualizado.");
	}
}
