package com.ufla.produtos;

public class Capacitor extends ComponenteEletronico {
    private float capacitancia;
    private float voltagem;

    public Capacitor(int idProduto, String nome, double preco, String descricao, int estoque, String fabricante, String datasheet, float capacitancia, float voltagem) {
        super(idProduto, nome, preco, descricao, estoque, fabricante, datasheet);
        this.capacitancia = capacitancia;
        this.voltagem = voltagem;
    }

    @Override
    public void exibirDetalhesTecnicos() {
        super.exibirDetalhesTecnicos();
        System.out.println("Capacitância: " + capacitancia + " F");
        System.out.println("Voltagem: " + voltagem + " V");
    }

    public float getCapacitancia() {
        return capacitancia;
    }

    public void setCapacitancia(float capacitancia) {
        this.capacitancia = capacitancia;
    }

    public float getVoltagem() {
        return voltagem;
    }

    public void setVoltagem(float voltagem) {
        this.voltagem = voltagem;
    }
}