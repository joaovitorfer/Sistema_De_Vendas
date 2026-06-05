package com.ufla.produtos;

public class LED extends ComponenteEletronico {
    private String cor;
    private float tensao;

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