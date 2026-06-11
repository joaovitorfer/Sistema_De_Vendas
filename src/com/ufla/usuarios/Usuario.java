package com.ufla.usuarios;

/**
 * Classe abstrata que representa um usuário genérico do sistema.
 *
 * <p>Esta classe serve como superclasse para os diferentes tipos de
 * usuários, armazenando informações comuns como identificador, nome
 * de usuário, e-mail e senha. Além disso, fornece funcionalidades
 * básicas de autenticação, como login e logout.</p>
 *
 * <p>Por ser abstrata, não pode ser instanciada diretamente, devendo
 * ser herdada por classes concretas como Cliente e Lojista.</p>
 *
 * @author Grupo 2 - UFLA
 * @version 1.0
 */
public abstract class Usuario {

    /** Identificador único do usuário. */
    private int id;

    /** Nome de usuário utilizado para identificação no sistema. */
    private String nomeUsuario;

    /** Endereço de e-mail do usuário. */
    private String email;

    /** Senha de acesso do usuário. */
    private String senha;

    /**
     * Constrói um novo usuário.
     *
     * @param id Identificador único do usuário.
     * @param nomeUsuario Nome de usuário.
     * @param email E-mail do usuário.
     * @param senha Senha de acesso.
     */
    public Usuario(int id, String nomeUsuario, String email, String senha) {
        this.id = id;
        this.nomeUsuario = nomeUsuario;
        setEmail(email);
        this.senha = senha;
    }

    /**
     * Retorna o identificador do usuário.
     *
     * @return ID do usuário.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o identificador do usuário.
     *
     * @param id Novo identificador.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna o nome de usuário.
     *
     * @return Nome de usuário.
     */
    public String getNomeUsuario() {
        return nomeUsuario;
    }

    /**
     * Define o nome de usuário.
     *
     * @param nomeUsuario Novo nome de usuário.
     */
    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    /**
     * Retorna o endereço de e-mail do usuário.
     *
     * @return E-mail do usuário.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o endereço de e-mail do usuário.
     *
     * <p>O e-mail deve conter o caractere '@' para ser considerado válido.</p>
     *
     * @param email Novo e-mail do usuário.
     */
    public void setEmail(String email) {
        if (email != null && email.contains("@")) {
            this.email = email;
        } else {
            System.out.println("Formato de email invalido");
        }
    }

    /**
     * Retorna a senha do usuário.
     *
     * @return Senha cadastrada.
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Define a senha do usuário.
     *
     * @param senha Nova senha.
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * Realiza o login do usuário no sistema.
     */
    public void login() {
        System.out.println(nomeUsuario + " entrou no sistema.");
    }

    /**
     * Realiza o logout do usuário no sistema.
     */
    public void logout() {
        System.out.println(nomeUsuario + " encerrou a sessão.");
    }
}
