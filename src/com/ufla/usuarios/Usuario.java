package com.ufla.usuarios;

public abstract class Usuario {
	private int id;
	private String nomeUsuario;
	private String email;
	private String senha;
	
	public Usuario(int id, String nomeUsuario, String email, String senha){
			this.id = id;
			this.nomeUsuario = nomeUsuario;
			setEmail(email);
			this.senha = senha;
	}

	//ID'
	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id = id;
	}

	//Nome de usuario
		public String getNomeUsuario(){
		return nomeUsuario;
	}
	
	public void setNomeUsuario(String nomeUsuario){
		this.nomeUsuario = nomeUsuario;
	}

	//Email
		public String getEmail(){
		return email;
	}
	
		public void setEmail(String email){
			if (email != null && email.contains("@")){
				this.email = email;
		} else {
			System.out.println("Formato de email invalido");
		}
	}
	
	//Senha
		public String getSenha(){
		return senha;
	}

	public void setSenha(String senha){
		this.senha = senha;
	}

	public void login() {
		System.out.println(nomeUsuario + " entrou no sistema.");
	}
	
	public void logout() {
		System.out.println(nomeUsuario + " encerrou a sessão.");
	}
}
