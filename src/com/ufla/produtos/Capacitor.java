package com.ufla.produtos;

public class Capacitor extends ComponenteEletronico {
    private float capacitancia;
    private float voltagem;

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