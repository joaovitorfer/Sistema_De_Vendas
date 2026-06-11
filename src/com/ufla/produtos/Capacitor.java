package com.ufla.produtos;

/**
 * Representa um capacitor disponível para venda no sistema.
 * <p>
 * Um capacitor é um componente eletrônico que armazena energia
 * elétrica em um campo elétrico, sendo caracterizado principalmente
 * por sua capacitância e tensão máxima de operação.
 * </p>
 *
 * @author Grupo 2 - UFLA
 * @version 1.0
 */
public class Capacitor extends ComponenteEletronico {

    /** Valor da capacitância do capacitor em Farads (F). */
    private float capacitancia;

    /** Tensão máxima suportada pelo capacitor em Volts (V). */
    private float voltagem;

    /**
     * Constrói um novo capacitor.
     *
     * @param idProduto identificador único do produto
     * @param nome nome do capacitor
     * @param preco preço do produto
     * @param descricao descrição do capacitor
     * @param estoque quantidade disponível em estoque
     * @param fabricante fabricante do componente
     * @param datasheet link ou referência ao datasheet do componente
     * @param capacitancia valor da capacitância em Farads (F)
     * @param voltagem tensão máxima de operação em Volts (V)
     */
    public Capacitor(int idProduto, String nome, double preco,
                     String descricao, int estoque,
                     String fabricante, String datasheet,
                     float capacitancia, float voltagem) {
        super(idProduto, nome, preco, descricao, estoque, fabricante, datasheet);
        this.capacitancia = capacitancia;
        this.voltagem = voltagem;
    }

    /**
     * Exibe os detalhes técnicos do capacitor.
     * Além das informações herdadas de ComponenteEletronico,
     * mostra a capacitância e a tensão de operação.
     */
    @Override
    public void exibirDetalhesTecnicos() {
        super.exibirDetalhesTecnicos();
        System.out.println("Capacitância: " + capacitancia + " F");
        System.out.println("Voltagem: " + voltagem + " V");
    }

    /**
     * Retorna a capacitância do capacitor.
     *
     * @return capacitância em Farads (F)
     */
    public float getCapacitancia() {
        return capacitancia;
    }

    /**
     * Define a capacitância do capacitor.
     *
     * @param capacitancia nova capacitância em Farads (F)
     */
    public void setCapacitancia(float capacitancia) {
        this.capacitancia = capacitancia;
    }

    /**
     * Retorna a tensão máxima suportada pelo capacitor.
     *
     * @return tensão em Volts (V)
     */
    public float getVoltagem() {
        return voltagem;
    }

    /**
     * Define a tensão máxima suportada pelo capacitor.
     *
     * @param voltagem nova tensão em Volts (V)
     */
    public void setVoltagem(float voltagem) {
        this.voltagem = voltagem;
    }
}