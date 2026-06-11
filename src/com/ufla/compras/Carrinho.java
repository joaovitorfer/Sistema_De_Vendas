package com.ufla.compras;

import java.util.ArrayList;

import com.ufla.produtos.Produto;

public class Carrinho {

	private int idCarrinho;
	private String dataCriacao;
	private String status;

	private ArrayList<ItemPedido> itens;
	
	public Carrinho(int idCarrinho, String dataCriacao) {
		this.idCarrinho = idCarrinho;
		this.dataCriacao = dataCriacao;
		this.status = "Ativo";
		this.itens = new ArrayList<>();
	}
	
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

	public void removerItem(int idProduto) {
		for (ItemPedido item : itens) {
			if (item.getProduto().getIdProduto() == idProduto) {
				itens.remove(item);
				return;
			}
		}
	}
	public float calcularTotal() {
		float total = 0;
		for (ItemPedido item : itens) {
			total += item.calcularSubtotal();
		}
		return total;
	}

	public int getIdCarrinho() {
		return idCarrinho;
	}

	public String getDataCriacao() {
		return dataCriacao;
	}

	public String getStatus() {
		return status;
	}

	public ArrayList<ItemPedido> getItens() {
		return itens;
	}

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
