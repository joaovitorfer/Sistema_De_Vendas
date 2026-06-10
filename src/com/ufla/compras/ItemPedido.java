package com.ufla.compras;

import com.ufla.produtos.Produto;

public class ItemPedido {
	private int quantidade;
	private double precoUnitario;
	private Produto produto;
	
	public ItemPedido(Produto produto, int quantidade) {
		this.produto = produto;
		this.precoUnitario = produto.getPreco();
		setQuantidade(quantidade);
	}
	public double calcularSubtotal() {
		return quantidade * precoUnitario;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		if (quantidade > 0) {
			this.quantidade = quantidade;
		} else {
			System.err.println("Quantidade deve ser maior que zero.");
		}
	}

	public double getPrecoUnitario() {
		return precoUnitario;
	}

	public Produto getProduto() {
		return produto;
	}

	@Override
	public String toString() {
		return produto.getNome()
				+ " | Quantidade: " + quantidade
				+ " | Preço Unitário: R$ " + precoUnitario
				+ " | Subtotal: R$ " + calcularSubtotal();
	}
}
