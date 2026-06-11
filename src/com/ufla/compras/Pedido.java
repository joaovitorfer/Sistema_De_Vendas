package com.ufla.compras;

import java.util.ArrayList;

/**
 * Representa um pedido finalizado contendo os itens comprados,
 * o valor total da compra e informações sobre seu status.
 *
 * @author Grupo 2 - UFLA
 * @version 1.0
 */
public class Pedido {

    /** Identificador único do pedido. */
    private int idPedido;

    /** Valor total do pedido. */
    private float valorTotal;

    /** Status atual do pedido. */
    private String status;

    /** Data de criação ou finalização do pedido. */
    private String data;

    /** Lista de itens pertencentes ao pedido. */
    private ArrayList<ItemPedido> itens;

    /**
     * Cria um novo pedido a partir dos itens fornecidos.
     * O status inicial é definido como "concluido" e o valor
     * total é calculado automaticamente.
     *
     * @param idPedido identificador do pedido
     * @param itens lista de itens do pedido
     */
    public Pedido(int idPedido, ArrayList<ItemPedido> itens) {
        this.idPedido = idPedido;
        this.itens = itens;
        this.status = "concluido";
        this.valorTotal = calcularTotal();
    }

    /**
     * Calcula o valor total do pedido somando os subtotais
     * de todos os itens.
     *
     * @return valor total do pedido
     */
    public float calcularTotal() {
        float total = 0;

        for (ItemPedido item : itens) {
            total += item.calcularSubtotal();
        }

        return total;
    }

    /**
     * Gera uma fatura simplificada contendo a quantidade total
     * de produtos, valor total e status do pedido.
     *
     * @return texto formatado da fatura
     */
    public String gerarFatura() {
        String fatura = "\nTotal de produtos: " + calcularQuantidadeProdutos() +
                "\nValor total: " + valorTotal +
                "\nStatus: " + status;
        return fatura;
    }

    /**
     * Retorna o identificador do pedido.
     *
     * @return id do pedido
     */
    public int getIdPedido() {
        return idPedido;
    }

    /**
     * Retorna o valor total do pedido.
     *
     * @return valor total
     */
    public float getValorTotal() {
        return valorTotal;
    }

    /**
     * Retorna o status atual do pedido.
     *
     * @return status do pedido
     */
    public String getStatus() {
        return status;
    }

    /**
     * Define um novo status para o pedido.
     *
     * @param status novo status do pedido
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Calcula a quantidade total de produtos no pedido,
     * considerando as quantidades de cada item.
     *
     * @return quantidade total de produtos
     */
    public int calcularQuantidadeProdutos() {
        int total = 0;

        for (ItemPedido item : itens) {
            total += item.getQuantidade();
        }

        return total;
    }

    /**
     * Retorna a data associada ao pedido.
     *
     * @return data do pedido
     */
    public String getData() {
        return data;
    }

    /**
     * Retorna a lista de itens do pedido.
     *
     * @return lista de itens
     */
    public ArrayList<ItemPedido> getItens() {
        return itens;
    }
}