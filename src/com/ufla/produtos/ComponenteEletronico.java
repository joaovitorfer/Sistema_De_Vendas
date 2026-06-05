package com.ufla.produtos;

public class ComponenteEletronico extends Produto {
    private String fabricante;
    private String datasheet;

    public boolean validarEspecificacao() {
    	boolean conferir = false;
    	
    	return conferir;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getDatasheet() {
        return datasheet;
    }

    public void setDatasheet(String datasheet) {
        this.datasheet = datasheet;
    }
}