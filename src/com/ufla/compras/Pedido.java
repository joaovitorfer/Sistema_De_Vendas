package com.ufla.compras;

public class Pedido {

    private int idPedido;
    private double valorTotal;
    private String status;
    private String data;

    public Pedido(int idPedido, double valorTotal, String status, String data) {
        this.idPedido = idPedido;
        this.valorTotal = valorTotal;
        this.status = status;
        this.data = data;
    }

    public String gerarFatura() {
        return "idPedido: " + idPedido +
               "\nvalor total: " + valorTotal +
               "\nstatus: " + status +
               "\ndata: " + data;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        if (valorTotal >= 0) {
            this.valorTotal = valorTotal;
        }
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

    public void setData(String data) {
        this.data = data;
    }
}