package com.ufla.compras;

import com.ufla.produtos.Produto;

public class ItemPedido {
	private int quantidade;
	private float precoUnitario;
	private Produto produto;
	
	public float calcularSubtotal() {
		
		return precoUnitario*quantidade;
	}
}
