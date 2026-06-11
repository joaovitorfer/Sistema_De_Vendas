package com.ufla.compras;

import com.ufla.produtos.Produto;

/**
 * Representa um item pertencente a um pedido ou carrinho de compras.
 * Cada item associa um produto à sua quantidade e ao preço unitário
 * registrado no momento da adição ao carrinho.
 *
 * @author Grupo 2 - UFLA
 * @version 1.0
 */
public class ItemPedido {

    /** Quantidade do produto no pedido. */
    private int quantidade;

    /** Preço unitário do produto. */
    private double precoUnitario;

    /** Produto associado ao item do pedido. */
    private Produto produto;

    /**
     * Cria um novo item de pedido.
     *
     * @param produto produto associado ao item
     * @param quantidade quantidade desejada do produto
     */
    public ItemPedido(Produto produto, int quantidade) {
        this.produto = produto;
        this.precoUnitario = produto.getPreco();
        setQuantidade(quantidade);
    }

    /**
     * Calcula o subtotal do item.
     *
     * @return valor total do item (quantidade × preço unitário)
     */
    public double calcularSubtotal() {
        return quantidade * precoUnitario;
    }

    /**
     * Retorna a quantidade do produto.
     *
     * @return quantidade do produto
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * Define a quantidade do produto.
     * A quantidade deve ser maior que zero.
     *
     * @param quantidade nova quantidade do produto
     */
    public void setQuantidade(int quantidade) {
        if (quantidade > 0) {
            this.quantidade = quantidade;
        } else {
            System.err.println("Quantidade deve ser maior que zero.");
        }
    }

    /**
     * Retorna o preço unitário do produto.
     *
     * @return preço unitário
     */
    public double getPrecoUnitario() {
        return precoUnitario;
    }

    /**
     * Retorna o produto associado ao item.
     *
     * @return produto do item
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * Retorna uma representação textual do item do pedido,
     * contendo nome do produto, quantidade, preço unitário
     * e subtotal.
     *
     * @return descrição formatada do item
     */
    @Override
    public String toString() {
        return produto.getNome()
                + " | Quantidade: " + quantidade
                + " | Preço Unitário: R$ " + precoUnitario
                + " | Subtotal: R$ " + calcularSubtotal();
    }
}