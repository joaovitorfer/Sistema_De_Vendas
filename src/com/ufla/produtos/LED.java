package com.ufla.produtos;

/**
 * Representa um LED (Diodo Emissor de Luz) disponível para venda no sistema.
 * <p>
 * Um LED é um componente eletrônico capaz de emitir luz quando
 * percorrido por corrente elétrica. Suas principais características
 * são a cor emitida e a tensão de operação.
 * </p>
 *
 * @author Grupo 2 - UFLA
 * @version 1.0
 */
public class LED extends ComponenteEletronico {

    /** Cor da luz emitida pelo LED. */
    private String cor;

    /** Tensão de operação do LED em Volts (V). */
    private float tensao;

    /**
     * Constrói um novo LED.
     *
     * @param idProduto identificador único do produto
     * @param nome nome do LED
     * @param preco preço do produto
     * @param descricao descrição do produto
     * @param estoque quantidade disponível em estoque
     * @param fabricante fabricante do componente
     * @param datasheet referência ou link para o datasheet
     * @param cor cor emitida pelo LED
     * @param tensao tensão de operação em Volts (V)
     */
    public LED(int idProduto, String nome, double preco,
               String descricao, int estoque,
               String fabricante, String datasheet,
               String cor, float tensao) {
        super(idProduto, nome, preco, descricao, estoque, fabricante, datasheet);
        this.cor = cor;
        this.tensao = tensao;
    }

    /**
     * Exibe os detalhes técnicos do LED.
     * Além das informações herdadas de ComponenteEletronico,
     * mostra a cor e a tensão de operação.
     */
    @Override
    public void exibirDetalhesTecnicos() {
        super.exibirDetalhesTecnicos();
        System.out.println("Cor: " + cor);
        System.out.println("Tensão: " + tensao + " V");
    }

    /**
     * Retorna a cor emitida pelo LED.
     *
     * @return cor do LED
     */
    public String getCor() {
        return cor;
    }

    /**
     * Define a cor emitida pelo LED.
     *
     * @param cor nova cor do LED
     */
    public void setCor(String cor) {
        this.cor = cor;
    }

    /**
     * Retorna a tensão de operação do LED.
     *
     * @return tensão em Volts (V)
     */
    public float getTensao() {
        return tensao;
    }

    /**
     * Define a tensão de operação do LED.
     *
     * @param tensao nova tensão em Volts (V)
     */
    public void setTensao(float tensao) {
        this.tensao = tensao;
    }
}