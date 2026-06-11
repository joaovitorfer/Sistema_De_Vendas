package com.ufla.produtos;

/**
 * Representa um sensor disponível para venda no sistema.
 * <p>
 * Um sensor é um componente eletrônico capaz de detectar ou medir
 * grandezas físicas, químicas ou ambientais, convertendo-as em sinais
 * que podem ser processados por sistemas eletrônicos. Suas principais
 * características são o tipo de sensor e sua precisão.
 * </p>
 *
 * @author Grupo 2 - UFLA
 * @version 1.0
 */
public class Sensor extends ComponenteEletronico {

    /** Tipo do sensor (temperatura, pressão, proximidade, etc.). */
    private String tipoSensor;

    /** Precisão do sensor em porcentagem (%). */
    private float precisao;

    /**
     * Constrói um novo sensor.
     *
     * @param idProduto identificador único do produto
     * @param nome nome do sensor
     * @param preco preço do produto
     * @param descricao descrição do produto
     * @param estoque quantidade disponível em estoque
     * @param fabricante fabricante do componente
     * @param datasheet referência ou link para o datasheet
     * @param tipoSensor tipo do sensor
     * @param precisao precisão do sensor em porcentagem (%)
     */
    public Sensor(int idProduto, String nome, double preco,
                  String descricao, int estoque,
                  String fabricante, String datasheet,
                  String tipoSensor, float precisao) {
        super(idProduto, nome, preco, descricao, estoque, fabricante, datasheet);
        this.tipoSensor = tipoSensor;
        this.precisao = precisao;
    }

    /**
     * Exibe os detalhes técnicos do sensor.
     * Além das informações herdadas de ComponenteEletronico,
     * mostra o tipo e a precisão do sensor.
     */
    @Override
    public void exibirDetalhesTecnicos() {
        super.exibirDetalhesTecnicos();
        System.out.println("Tipo de Sensor: " + tipoSensor);
        System.out.println("Precisão: " + precisao + " %");
    }

    /**
     * Retorna o tipo do sensor.
     *
     * @return tipo do sensor
     */
    public String getTipoSensor() {
        return tipoSensor;
    }

    /**
     * Define o tipo do sensor.
     *
     * @param tipoSensor novo tipo do sensor
     */
    public void setTipoSensor(String tipoSensor) {
        this.tipoSensor = tipoSensor;
    }

    /**
     * Retorna a precisão do sensor.
     *
     * @return precisão em porcentagem (%)
     */
    public float getPrecisao() {
        return precisao;
    }

    /**
     * Define a precisão do sensor.
     *
     * @param precisao nova precisão em porcentagem (%)
     */
    public void setPrecisao(float precisao) {
        this.precisao = precisao;
    }
}