package com.ufla.produtos;

public abstract class ComponenteEletronico extends Produto {
    private String fabricante;
    private String datasheet;

    public ComponenteEletronico(int idProduto, String nome, double preco, String descricao, int estoque, String fabricante, String datasheet) {
        super(idProduto, nome, preco, descricao, estoque);
        this.fabricante = fabricante;
        this.datasheet = datasheet;
    }

    @Override
    public void exibirDetalhesTecnicos() {
        System.out.println("Fabricante: " + fabricante);
        System.out.println("Datasheet: " + datasheet);
    }

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