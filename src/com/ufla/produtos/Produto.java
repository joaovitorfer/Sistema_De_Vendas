package com.ufla.produtos;

public abstract class Produto {
    private int idProduto;
    private String nome;
    private float preco;
    private String descricao;
    private int estoque;

    public Produto(int idProduto, String nome, double preco, String descricao, int estoque) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.preco = (float) preco;
        this.descricao = descricao;
        this.estoque = estoque;
    }

    public abstract void exibirDetalhesTecnicos();

    public void aplicarDesconto() {

    }

    public void atualizarEstoque() {

    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        if (preco > 0) {
            this.preco = preco;
        } else {
            System.out.println("Preço inválido. O preço deve ser maior que zero.");
        }
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
}