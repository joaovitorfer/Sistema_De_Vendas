package com.ufla.produtos;

/**
 * Classe abstrata que representa um produto comercializado pelo sistema.
 * <p>
 * Todo produto possui um identificador, nome, preço, descrição e
 * quantidade em estoque. Além disso, define comportamentos comuns
 * que podem ser utilizados ou sobrescritos pelas subclasses.
 * </p>
 *
 * @author Grupo 2 - UFLA
 * @version 1.0
 */
public abstract class Produto {

    /** Identificador único do produto. */
    private int idProduto;

    /** Nome do produto. */
    private String nome;

    /** Preço do produto. */
    private double preco;

    /** Descrição do produto. */
    private String descricao;

    /** Quantidade disponível em estoque. */
    private int estoque;

    /**
     * Constrói um novo produto.
     *
     * @param idProduto identificador único do produto
     * @param nome nome do produto
     * @param preco preço do produto
     * @param descricao descrição do produto
     * @param estoque quantidade disponível em estoque
     */
    public Produto(int idProduto, String nome, double preco,
                   String descricao, int estoque) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.estoque = estoque;
    }

    /**
     * Exibe os detalhes técnicos do produto.
     * <p>
     * Este método deve ser implementado pelas subclasses,
     * que definirão quais informações técnicas serão exibidas.
     * </p>
     */
    public abstract void exibirDetalhesTecnicos();

    /**
     * Aplica desconto ao produto.
     * <p>
     * Método disponível para implementação futura.
     * </p>
     */
    public void aplicarDesconto() {

    }

    /**
     * Atualiza a quantidade em estoque do produto.
     * <p>
     * Método disponível para implementação futura.
     * </p>
     */
    public void atualizarEstoque() {

    }

    /**
     * Retorna o identificador do produto.
     *
     * @return identificador do produto
     */
    public int getIdProduto() {
        return idProduto;
    }

    /**
     * Define o identificador do produto.
     *
     * @param idProduto novo identificador do produto
     */
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    /**
     * Retorna o nome do produto.
     *
     * @return nome do produto
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do produto.
     *
     * @param nome novo nome do produto
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o preço do produto.
     *
     * @return preço do produto
     */
    public double getPreco() {
        return preco;
    }

    /**
     * Define o preço do produto.
     *
     * @param preco novo preço do produto
     */
    public void setPreco(float preco) {
        if (preco > 0) {
            this.preco = preco;
        } else {
            System.out.println("Preço inválido. O preço deve ser maior que zero.");
        }
    }

    /**
     * Retorna a descrição do produto.
     *
     * @return descrição do produto
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Define a descrição do produto.
     *
     * @param descricao nova descrição do produto
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Retorna a quantidade disponível em estoque.
     *
     * @return quantidade em estoque
     */
    public int getEstoque() {
        return estoque;
    }

    /**
     * Define a quantidade disponível em estoque.
     *
     * @param estoque nova quantidade em estoque
     */
    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
}