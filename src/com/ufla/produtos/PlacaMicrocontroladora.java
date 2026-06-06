package com.ufla.produtos;

public class PlacaMicrocontroladora extends ComponenteEletronico {
    private String processador;
    private int memoria;

    public PlacaMicrocontroladora(int idProduto, String nome, double preco, String descricao, int estoque, String fabricante, String datasheet, String processador, int memoria) {
        super(idProduto, nome, preco, descricao, estoque, fabricante, datasheet);
        this.processador = processador;
        this.memoria = memoria;
    }

    @Override
    public void exibirDetalhesTecnicos() {
        super.exibirDetalhesTecnicos();
        System.out.println("Processador: " + processador);
        System.out.println("Memória: " + memoria + " MB");
    }

    public String getProcessador() {
        return processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

    public int getMemoria() {
        return memoria;
    }

    public void setMemoria(int memoria) {
        this.memoria = memoria;
    }
}