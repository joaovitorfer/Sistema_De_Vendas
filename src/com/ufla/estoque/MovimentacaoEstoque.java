package com.ufla.estoque;

import com.ufla.produtos.Produto;

/**
 * Representa uma movimentação de estoque de um produto,
 * podendo ser uma entrada ou saída de unidades.
 * Armazena informações sobre o tipo da movimentação,
 * quantidade movimentada, data e produto associado.
 *
 * @author Grupo 2 - UFLA
 * @version 1.0
 */
public class MovimentacaoEstoque {

    /** Tipo da movimentação (Entrada ou Saída). */
    private String tipoMovimentacao;

    /** Quantidade de unidades movimentadas. */
    private int quantidade;

    /** Data em que a movimentação ocorreu. */
    private String dataMovimentacao;

    /** Produto associado à movimentação. */
    private Produto produto;

    /**
     * Cria uma nova movimentação de estoque.
     *
     * @param tipoMovimentacao tipo da movimentação (Entrada ou Saída)
     * @param quantidade quantidade movimentada
     * @param dataMovimentacao data da movimentação
     * @param produto produto associado à movimentação
     */
    public MovimentacaoEstoque(String tipoMovimentacao, int quantidade,
                               String dataMovimentacao, Produto produto) {
        this.tipoMovimentacao = tipoMovimentacao;
        this.quantidade = quantidade;
        this.dataMovimentacao = dataMovimentacao;
        this.produto = produto;
    }

    /**
     * Registra uma entrada de produtos no estoque,
     * aumentando a quantidade disponível.
     */
    public void registrarEntrada() {
        produto.setEstoque(produto.getEstoque() + quantidade);
    }

    /**
     * Registra uma saída de produtos do estoque,
     * reduzindo a quantidade disponível.
     * A operação não é realizada caso a quantidade
     * solicitada seja maior que o estoque disponível.
     */
    public void registrarSaida() {
        if (quantidade > produto.getEstoque()) {
            System.out.println("Quantidade maior que o estoque disponível.");
            return;
        }
        produto.setEstoque(produto.getEstoque() - quantidade);
    }

    /**
     * Retorna a data da movimentação.
     *
     * @return data da movimentação
     */
    public String getDataMovimentacao() {
        return dataMovimentacao;
    }

    /**
     * Retorna o produto associado à movimentação.
     *
     * @return produto movimentado
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * Retorna a quantidade movimentada.
     *
     * @return quantidade movimentada
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * Retorna o tipo da movimentação.
     *
     * @return tipo da movimentação
     */
    public String getTipoMovimentacao() {
        return tipoMovimentacao;
    }
}