package com.ufla.produtos;

public class Cabo extends ComponenteEletronico {
    private String tipoCabo;
    private float comprimento;

    public Cabo(int idProduto, String nome, double preco, String descricao, int estoque, String fabricante, String datasheet, String tipoCabo, float comprimento) {
        super(idProduto, nome, preco, descricao, estoque, fabricante, datasheet);
        this.tipoCabo = tipoCabo;
        this.comprimento = comprimento;
    }

    @Override
    public void exibirDetalhesTecnicos() {
        super.exibirDetalhesTecnicos();
        System.out.println("Tipo de Cabo: " + tipoCabo);
        System.out.println("Comprimento: " + comprimento + " metros");
    }
    
    public String getTipoCabo() {
        return tipoCabo;
    }

    public void setTipoCabo(String tipoCabo) {
        this.tipoCabo = tipoCabo;
    }

    public float getComprimento() {
        return comprimento;
    }

    public void setComprimento(float comprimento) {
        this.comprimento = comprimento;
    }
}