package com.ufla.estoque;

import com.ufla.produtos.Produto;

public class MovimentacaoEstoque {
	private String tipoMovimentacao;
	private int quantidade;
	private String dataMovimentacao;
	private Produto produto;
	
	public MovimentacaoEstoque(String tipoMovimentacao, int quantidade, String dataMovimentacao, Produto produto) {
		this.tipoMovimentacao = tipoMovimentacao;
		this.quantidade = quantidade;
		this.dataMovimentacao = dataMovimentacao;
		this.produto = produto;
	}

	public void registrarEntrada() {
		produto.setEstoque(produto.getEstoque() + quantidade);
	}
	public void registrarSaida() {
		if (quantidade > produto.getEstoque()) {
			System.out.println("Quantidade maior que o estoque disponível.");
			return;
		}
		produto.setEstoque(produto.getEstoque() - quantidade);
	}

	public String getDataMovimentacao() {
		return dataMovimentacao;
	}

	public Produto getProduto() {
		return produto;
	}
	
	public int getQuantidade() {
		return quantidade;
	}

	public String getTipoMovimentacao() {
		return tipoMovimentacao;
	}
}
