package com.ufla.produtos;

/**
 * Representa um cabo eletrônico comercializado pela loja.
 * Herda as características de um componente eletrônico e
 * adiciona informações específicas como tipo e comprimento.
 *
 * @author Grupo 2 - UFLA
 * @version 1.0
 */
public class Cabo extends ComponenteEletronico {

    /** Tipo do cabo (USB, HDMI, Ethernet, etc.). */
    private String tipoCabo;

    /** Comprimento do cabo em metros. */
    private float comprimento;

    /**
     * Cria um novo cabo eletrônico.
     *
     * @param idProduto identificador do produto
     * @param nome nome do produto
     * @param preco preço do produto
     * @param descricao descrição do produto
     * @param estoque quantidade disponível em estoque
     * @param fabricante fabricante do produto
     * @param datasheet documento técnico do produto
     * @param tipoCabo tipo do cabo
     * @param comprimento comprimento do cabo em metros
     */
    public Cabo(int idProduto, String nome, double preco, String descricao,
                int estoque, String fabricante, String datasheet,
                String tipoCabo, float comprimento) {
        super(idProduto, nome, preco, descricao, estoque, fabricante, datasheet);
        this.tipoCabo = tipoCabo;
        this.comprimento = comprimento;
    }

    /**
     * Exibe os detalhes técnicos do cabo, incluindo as
     * informações herdadas da classe ComponenteEletronico.
     */
    @Override
    public void exibirDetalhesTecnicos() {
        super.exibirDetalhesTecnicos();
        System.out.println("Tipo de Cabo: " + tipoCabo);
        System.out.println("Comprimento: " + comprimento + " metros");
    }

    /**
     * Retorna o tipo do cabo.
     *
     * @return tipo do cabo
     */
    public String getTipoCabo() {
        return tipoCabo;
    }

    /**
     * Define o tipo do cabo.
     *
     * @param tipoCabo novo tipo do cabo
     */
    public void setTipoCabo(String tipoCabo) {
        this.tipoCabo = tipoCabo;
    }

    /**
     * Retorna o comprimento do cabo em metros.
     *
     * @return comprimento do cabo
     */
    public float getComprimento() {
        return comprimento;
    }

    /**
     * Define o comprimento do cabo em metros.
     *
     * @param comprimento novo comprimento do cabo
     */
    public void setComprimento(float comprimento) {
        this.comprimento = comprimento;
    }
}