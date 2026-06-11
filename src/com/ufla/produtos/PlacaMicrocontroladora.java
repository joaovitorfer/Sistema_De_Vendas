package com.ufla.produtos;

/**
 * Representa uma placa microcontroladora disponível para venda no sistema.
 * <p>
 * Uma placa microcontroladora é um dispositivo eletrônico utilizado
 * em projetos de automação, robótica e sistemas embarcados. Suas
 * principais características incluem o processador utilizado e a
 * quantidade de memória disponível.
 * </p>
 *
 * @author Grupo 2 - UFLA
 * @version 1.0
 */
public class PlacaMicrocontroladora extends ComponenteEletronico {

    /** Modelo ou tipo do processador da placa. */
    private String processador;

    /** Quantidade de memória disponível em megabytes (MB). */
    private int memoria;

    /**
     * Constrói uma nova placa microcontroladora.
     *
     * @param idProduto identificador único do produto
     * @param nome nome da placa
     * @param preco preço do produto
     * @param descricao descrição da placa
     * @param estoque quantidade disponível em estoque
     * @param fabricante fabricante da placa
     * @param datasheet referência ou link para o datasheet
     * @param processador modelo ou tipo do processador
     * @param memoria quantidade de memória em megabytes (MB)
     */
    public PlacaMicrocontroladora(int idProduto, String nome, double preco,
                                  String descricao, int estoque,
                                  String fabricante, String datasheet,
                                  String processador, int memoria) {
        super(idProduto, nome, preco, descricao, estoque, fabricante, datasheet);
        this.processador = processador;
        this.memoria = memoria;
    }

    /**
     * Exibe os detalhes técnicos da placa microcontroladora.
     * Além das informações herdadas de ComponenteEletronico,
     * mostra o processador e a quantidade de memória.
     */
    @Override
    public void exibirDetalhesTecnicos() {
        super.exibirDetalhesTecnicos();
        System.out.println("Processador: " + processador);
        System.out.println("Memória: " + memoria + " MB");
    }

    /**
     * Retorna o processador da placa.
     *
     * @return modelo ou tipo do processador
     */
    public String getProcessador() {
        return processador;
    }

    /**
     * Define o processador da placa.
     *
     * @param processador novo processador
     */
    public void setProcessador(String processador) {
        this.processador = processador;
    }

    /**
     * Retorna a quantidade de memória da placa.
     *
     * @return memória em megabytes (MB)
     */
    public int getMemoria() {
        return memoria;
    }

    /**
     * Define a quantidade de memória da placa.
     *
     * @param memoria nova quantidade de memória em megabytes (MB)
     */
    public void setMemoria(int memoria) {
        this.memoria = memoria;
    }
}