package com.ufla.produtos;

public class Resistor extends ComponenteEletronico {
    private float resistencia;
    private float potencia;

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