package com.ufla.usuarios;

/**
 * Representa um lojista do sistema.
 * <p>
 * A classe herda de {@code Usuario} e adiciona informações
 * específicas relacionadas ao vendedor, como o CNPJ.
 * Além disso, disponibiliza operações relacionadas ao
 * gerenciamento de produtos e estoque.
 * </p>
 *
 * @author Grupo 2 - UFLA
 * @version 1.0
 */
public class Lojista extends Usuario {

    /**
     * Cadastro Nacional da Pessoa Jurídica (CNPJ) do lojista.
     */
    private String cnpj;

    /**
     * Cria um novo lojista.
     *
     * @param id identificador único do lojista
     * @param nomeUsuario nome de usuário
     * @param email endereço de e-mail
     * @param senha senha de acesso
     * @param cnpj CNPJ da empresa ou estabelecimento
     */
    public Lojista(int id, String nomeUsuario, String email, String senha, String cnpj) {
        super(id, nomeUsuario, email, senha);
        this.cnpj = cnpj;
    }

    /**
     * Retorna o CNPJ do lojista.
     *
     * @return CNPJ do lojista
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * Define um novo CNPJ para o lojista.
     *
     * @param cnpj novo CNPJ
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * Realiza o cadastro de um produto no sistema.
     * <p>
     * Este método representa a funcionalidade de inclusão
     * de novos produtos pelo lojista.
     * </p>
     */
    public void cadastrarProduto() {
        System.out.println("Produto cadastrado.");
    }

    /**
     * Atualiza a quantidade disponível de produtos em estoque.
     * <p>
     * Este método representa a funcionalidade de gerenciamento
     * de estoque realizada pelo lojista.
     * </p>
     */
    public void atualizarEstoque() {
        System.out.println("Estoque atualizado.");
    }
}