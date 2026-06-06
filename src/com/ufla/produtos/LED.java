package com.ufla.produtos;

public class LED extends ComponenteEletronico {
    private String cor;
    private float tensao;

    public LED(int idProduto, String nome, double preco, String descricao, int estoque, String fabricante, String datasheet, String cor, float tensao) {
        super(idProduto, nome, preco, descricao, estoque, fabricante, datasheet);
        this.cor = cor;
        this.tensao = tensao;
    }

    @Override
    public void exibirDetalhesTecnicos() {
        super.exibirDetalhesTecnicos();
        System.out.println("Cor: " + cor);
        System.out.println("Tensão: " + tensao + " V");
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public float getTensao() {
        return tensao;
    }

    public void setTensao(float tensao) {
        this.tensao = tensao;
    }
}