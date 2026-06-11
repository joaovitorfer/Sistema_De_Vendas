package com.ufla.usuarios;

/**
 * Representa um lojista do sistema.
 *
 * <p>A classe Lojista herda os atributos e comportamentos da classe
 * {@code Usuario} e adiciona informações específicas relacionadas ao
 * vendedor, como o CNPJ. Além disso, disponibiliza funcionalidades para
 * cadastro de produtos e atualização de estoque.</p>
 *
 * @author Grupo 2 - UFLA
 * @version 1.0
 */
public class Lojista extends Usuario {

    /** CNPJ do lojista. */
    private String cnpj;

    /**
     * Constrói um novo lojista.
     *
     * @param id Identificador único do usuário.
     * @param nomeUsuario Nome de usuário do lojista.
     * @param email E-mail do lojista.
     * @param senha Senha de acesso ao sistema.
     * @param cnpj CNPJ da empresa ou vendedor.
     */
    public Lojista(int id, String nomeUsuario, String email, String senha, String cnpj) {
        super(id, nomeUsuario, email, senha);
        this.cnpj = cnpj;
    }

    /**
     * Retorna o CNPJ do lojista.
     *
     * @return CNPJ do lojista.
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * Define o CNPJ do lojista.
     *
     * @param cnpj Novo CNPJ do lojista.
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * Realiza o cadastro de um novo produto no sistema.
     */
    public void cadastrarProduto() {
        System.out.println("Produto cadastrado.");
    }

    /**
     * Atualiza a quantidade de produtos disponíveis em estoque.
     */
    public void atualizarEstoque() {
        System.out.println("Estoque atualizado.");
    }
}
