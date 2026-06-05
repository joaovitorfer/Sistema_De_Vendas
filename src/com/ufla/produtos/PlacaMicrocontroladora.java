package com.ufla.produtos;

public class PlacaMicrocontroladora extends ComponenteEletronico {
    private String processador;
    private int memoria;

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