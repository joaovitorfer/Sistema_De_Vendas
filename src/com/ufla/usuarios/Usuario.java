package com.ufla.usuarios;

/**
 * Classe abstrata que representa um usuário do sistema.
 * <p>
 * Esta classe fornece os atributos e comportamentos comuns
 * a todos os tipos de usuários, como identificação, nome
 * de usuário, e-mail e senha.
 * </p>
 * <p>
 * As classes {@code Cliente} e {@code Lojista} herdam desta
 * classe e podem adicionar funcionalidades específicas.
 * </p>
 *
 * @author Grupo 2 - UFLA
 * @version 1.0
 */
public abstract class Usuario {

    /**
     * Identificador único do usuário.
     */
    private int id;

    /**
     * Nome de usuário utilizado para acesso ao sistema.
     */
    private String nomeUsuario;

    /**
     * Endereço de e-mail do usuário.
     */
    private String email;

    /**
     * Senha de autenticação do usuário.
     */
    private String senha;

    /**
     * Constrói um usuário com as informações básicas.
     *
     * @param id identificador único do usuário
     * @param nomeUsuario nome de usuário
     * @param email endereço de e-mail
     * @param senha senha de acesso
     */
    public Usuario(int id, String nomeUsuario, String email, String senha) {
        this.id = id;
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.senha = senha;
    }

    /**
     * Retorna o identificador do usuário.
     *
     * @return identificador do usuário
     */
    public int getId() {
        return id;
    }

    /**
     * Define o identificador do usuário.
     *
     * @param id novo identificador
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna o nome de usuário.
     *
     * @return nome de usuário
     */
    public String getNomeUsuario() {
        return nomeUsuario;
    }

    /**
     * Define o nome de usuário.
     *
     * @param nomeUsuario novo nome de usuário
     */
    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    /**
     * Retorna o endereço de e-mail do usuário.
     *
     * @return e-mail do usuário
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o endereço de e-mail do usuário.
     *
     * @param email novo endereço de e-mail
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retorna a senha do usuário.
     *
     * @return senha do usuário
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Define uma nova senha para o usuário.
     *
     * @param senha nova senha
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * Realiza o login do usuário no sistema.
     * <p>
     * Exibe uma mensagem indicando que o usuário entrou no sistema.
     * </p>
     */
    public void login() {
        System.out.println(nomeUsuario + " entrou no sistema.");
    }

    /**
     * Realiza o logout do usuário no sistema.
     * <p>
     * Exibe uma mensagem indicando que a sessão foi encerrada.
     * </p>
     */
    public void logout() {
        System.out.println(nomeUsuario + " encerrou a sessão.");
    }
}