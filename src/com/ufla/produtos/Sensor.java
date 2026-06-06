package com.ufla.produtos;

public class Sensor extends ComponenteEletronico {
    private String tipoSensor;
    private float precisao;

    public Sensor(int idProduto, String nome, double preco, String descricao, int estoque, String fabricante, String datasheet, String tipoSensor, float precisao) {
        super(idProduto, nome, preco, descricao, estoque, fabricante, datasheet);
        this.tipoSensor = tipoSensor;
        this.precisao = precisao;
    }

    @Override
    public void exibirDetalhesTecnicos() {
        super.exibirDetalhesTecnicos();
        System.out.println("Tipo de Sensor: " + tipoSensor);
        System.out.println("Precisão: " + precisao + " %");
    }

    public String getTipoSensor() {
        return tipoSensor;
    }

    public void setTipoSensor(String tipoSensor) {
        this.tipoSensor = tipoSensor;
    }

    public float getPrecisao() {
        return precisao;
    }

    public void setPrecisao(float precisao) {
        this.precisao = precisao;
    }
}