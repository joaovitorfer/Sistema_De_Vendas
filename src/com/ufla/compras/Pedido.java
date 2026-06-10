package com.ufla.compras;

import java.util.ArrayList;

public class Pedido {

	private int idPedido;
	private float valorTotal;
	private String status;
	private String data;
	private ArrayList<ItemPedido> itens;

    public Pedido(int idPedido, ArrayList<ItemPedido> itens) {
        this.idPedido = idPedido;
        this.itens = itens;
        this.status = "Pendente";
        this.data = "";
        this.valorTotal = calcularTotal();
    }

	public float calcularTotal() {
		float total = 0;

		for (ItemPedido item : itens) {
			total += item.calcularSubtotal();
		}

		return total;
	}

	public String gerarFatura(){
		String fatura = "idPedido: " + idPedido +
                "\nvalor total: " + valorTotal +
                "\nstatus: " + status +
                "\ndata: " + data;
		return fatura; 
	}

	public int getIdPedido() {
		return idPedido;
	}

	public float getValorTotal() {
		return valorTotal;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getData() {
		return data;
	}

	public ArrayList<ItemPedido> getItens() {
		return itens;
	}
}
