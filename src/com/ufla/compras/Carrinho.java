package com.ufla.compras;

import java.util.ArrayList;

import com.ufla.produtos.Produto;

public class Carrinho {

    private int idCarrinho;
    private String dataCriacao;
    private String status;
    private ArrayList<ItemPedido> itens;

    public Carrinho(int idCarrinho, String dataCriacao, String status) {
        this.idCarrinho = idCarrinho;
        this.dataCriacao = dataCriacao;
        this.status = status;
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Produto produto, int quantidade) {
        ItemPedido item = new ItemPedido(produto, quantidade);
        itens.add(item);
    }

    public void removerItem(Produto produto) {
        itens.removeIf(item ->
                item.getProduto().getIdProduto() == produto.getIdProduto());
    }

    public double calcularTotal() {
        double total = 0;

        for (ItemPedido item : itens) {
            total += item.calcularSubtotal();
        }

        return total;
    }

    public void listarItens() {
        if (itens.isEmpty()) {
            System.out.println("Carrinho vazio.");
            return;
        }

        for (ItemPedido item : itens) {
            System.out.println(item);
        }
    }

    public int getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(int idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(ArrayList<ItemPedido> itens) {
        this.itens = itens;
    }
}