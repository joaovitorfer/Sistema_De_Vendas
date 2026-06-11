package com.ufla.produtos;

/**
 * Representa um resistor disponível para venda no sistema.
 * <p>
 * Um resistor é um componente eletrônico utilizado para limitar
 * ou controlar a corrente elétrica em um circuito. Suas principais
 * características são a resistência elétrica e a potência suportada.
 * </p>
 *
 * @author Grupo 2 - UFLA
 * @version 1.0
 */
public class Resistor extends ComponenteEletronico {

    /** Valor da resistência elétrica em Ohms (Ω). */
    private float resistencia;

    /** Potência máxima suportada pelo resistor em Watts (W). */
    private float potencia;

    /**
     * Constrói um novo resistor.
     *
     * @param idProduto identificador único do produto
     * @param nome nome do resistor
     * @param preco preço do produto
     * @param descricao descrição do produto
     * @param estoque quantidade disponível em estoque
     * @param fabricante fabricante do componente
     * @param datasheet referência ou link para o datasheet
     * @param resistencia valor da resistência em Ohms (Ω)
     * @param potencia potência máxima suportada em Watts (W)
     */
    public Resistor(int idProduto, String nome, double preco,
                    String descricao, int estoque,
                    String fabricante, String datasheet,
                    float resistencia, float potencia) {
        super(idProduto, nome, preco, descricao, estoque, fabricante, datasheet);
        this.resistencia = resistencia;
        this.potencia = potencia;
    }

    /**
     * Exibe os detalhes técnicos do resistor.
     * Além das informações herdadas de ComponenteEletronico,
     * mostra a resistência elétrica e a potência suportada.
     */
    @Override
    public void exibirDetalhesTecnicos() {
        super.exibirDetalhesTecnicos();
        System.out.println("Resistência: " + resistencia + " Ω");
        System.out.println("Potência: " + potencia + " W");
    }

    /**
     * Retorna o valor da resistência elétrica.
     *
     * @return resistência em Ohms (Ω)
     */
    public float getResistencia() {
        return resistencia;
    }

    /**
     * Define o valor da resistência elétrica.
     *
     * @param resistencia nova resistência em Ohms (Ω)
     */
    public void setResistencia(float resistencia) {
        this.resistencia = resistencia;
    }

    /**
     * Retorna a potência máxima suportada.
     *
     * @return potência em Watts (W)
     */
    public float getPotencia() {
        return potencia;
    }

    /**
     * Define a potência máxima suportada.
     *
     * @param potencia nova potência em Watts (W)
     */
    public void setPotencia(float potencia) {
        this.potencia = potencia;
    }
}