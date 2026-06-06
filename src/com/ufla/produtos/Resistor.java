package com.ufla.produtos;

public class Resistor extends ComponenteEletronico {
    private float resistencia;
    private float potencia;

    public Resistor(int idProduto, String nome, double preco, String descricao, int estoque, String fabricante, String datasheet, float resistencia, float potencia) {
        super(idProduto, nome, preco, descricao, estoque, fabricante, datasheet);
        this.resistencia = resistencia;
        this.potencia = potencia;
    }

    @Override
    public void exibirDetalhesTecnicos() {
        super.exibirDetalhesTecnicos();
        System.out.println("Resistência: " + resistencia + " Ω");
        System.out.println("Potência: " + potencia + " W");
    }

    public float getResistencia() {
        return resistencia;
    }

    public void setResistencia(float resistencia) {
        this.resistencia = resistencia;
    }

    public float getPotencia() {
        return potencia;
    }

    public void setPotencia(float potencia) {
        this.potencia = potencia;
    }
}