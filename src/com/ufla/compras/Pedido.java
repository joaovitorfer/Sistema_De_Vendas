package com.ufla.compras;

public class Pedido {
	private int idPedido;
	private float valorTotal;
	private String status;
	private String date;
	
	public String gerarFatura(){
		String fatura = "idPedido: " + idPedido +
                "\nvalor total: " + valorTotal +
                "\nstatus: " + status +
                "\ndata: " + date;
		return fatura; 
	}
}
