package com.ufla.compras;

import java.util.ArrayList;

import com.ufla.produtos.Produto;

/**
 * Representa um carrinho de compras contendo itens selecionados pelo cliente.
 * Permite adicionar e remover produtos, calcular o valor total da compra
 * e finalizar o pedido.
 *
 * @author Grupo 2 - UFLA
 * @version 1.0
 */
public class Carrinho {

    /** Identificador único do carrinho. */
    private int idCarrinho;

    /** Data de criação do carrinho. */
    private String dataCriacao;

    /** Status atual do carrinho (Ativo ou Finalizado). */
    private String status;

    /** Lista de itens presentes no carrinho. */
    private ArrayList<ItemPedido> itens;

    /**
     * Cria um novo carrinho de compras.
     *
     * @param idCarrinho identificador do carrinho
     * @param dataCriacao data de criação do carrinho
     */
    public Carrinho(int idCarrinho, String dataCriacao) {
        this.idCarrinho = idCarrinho;
        this.dataCriacao = dataCriacao;
        this.status = "Ativo";
        this.itens = new ArrayList<>();
    }

    /**
     * Adiciona um produto ao carrinho.
     * Caso o produto já exista, sua quantidade é incrementada.
     * A quantidade adicionada não pode ultrapassar o estoque disponível.
     *
     * @param produto produto a ser adicionado
     * @param quantidade quantidade desejada
     */
    public void adicionarItem(Produto produto, int quantidade) {
        for (ItemPedido item : itens) {

            if (item.getProduto().getIdProduto() == produto.getIdProduto()) {

                if (item.getQuantidade() + quantidade > produto.getEstoque()) {
                    System.out.println("Quantidade maior que o estoque disponível.");
                    return;
                }

                item.setQuantidade(item.getQuantidade() + quantidade);
                return;
            }
        }

        if (quantidade > produto.getEstoque()) {
            System.out.println("Quantidade maior que o estoque disponível.");
            return;
        }

        itens.add(new ItemPedido(produto, quantidade));
    }

    /**
     * Remove um produto do carrinho pelo seu identificador.
     *
     * @param idProduto identificador do produto a ser removido
     */
    public void removerItem(int idProduto) {
        for (ItemPedido item : itens) {
            if (item.getProduto().getIdProduto() == idProduto) {
                itens.remove(item);
                return;
            }
        }
    }

    /**
     * Calcula o valor total do carrinho.
     *
     * @return soma dos subtotais de todos os itens
     */
    public float calcularTotal() {
        float total = 0;
        for (ItemPedido item : itens) {
            total += item.calcularSubtotal();
        }
        return total;
    }

    /**
     * Retorna o identificador do carrinho.
     *
     * @return id do carrinho
     */
    public int getIdCarrinho() {
        return idCarrinho;
    }

    /**
     * Retorna a data de criação do carrinho.
     *
     * @return data de criação
     */
    public String getDataCriacao() {
        return dataCriacao;
    }

    /**
     * Retorna o status atual do carrinho.
     *
     * @return status do carrinho
     */
    public String getStatus() {
        return status;
    }

    /**
     * Retorna a lista de itens presentes no carrinho.
     *
     * @return lista de itens
     */
    public ArrayList<ItemPedido> getItens() {
        return itens;
    }

    /**
     * Finaliza a compra, criando um pedido com os itens do carrinho.
     * Após a finalização, o estoque dos produtos é atualizado,
     * o status do carrinho é alterado para "Finalizado"
     * e os itens são removidos do carrinho.
     *
     * @param idPedido identificador do pedido a ser criado
     * @return objeto Pedido criado ou {@code null} caso o carrinho esteja vazio
     */
    public Pedido finalizarPedido(int idPedido) {
        if (itens.isEmpty()) {
            System.out.println("O carrinho está vazio. Adicione itens antes de finalizar o pedido.");
            return null;
        }

        Pedido pedido = new Pedido(idPedido, new ArrayList<>(itens));

        for (ItemPedido item : itens) {
            Produto produto = item.getProduto();
            int novaQuantidade = produto.getEstoque() - item.getQuantidade();
            produto.setEstoque(novaQuantidade);
        }

        this.status = "Finalizado";
        itens.clear();
        return pedido;
    }
}