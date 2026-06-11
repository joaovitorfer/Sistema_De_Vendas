package com.ufla.produtos;

/**
 * Representa um cabo eletrônico comercializado pelo sistema.
 * Esta classe herda as características de um componente eletrônico
 * e adiciona informações específicas sobre o tipo e o comprimento do cabo.
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
     * Cria um novo cabo.
     *
     * @param idProduto identificador do produto
     * @param nome nome do produto
     * @param preco preço do produto
     * @param descricao descrição do produto
     * @param estoque quantidade disponível em estoque
     * @param fabricante fabricante do cabo
     * @param datasheet link ou referência ao datasheet
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
     * Exibe as informações técnicas do cabo,
     * incluindo os dados herdados do componente eletrônico.
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
     * Retorna o comprimento do cabo.
     *
     * @return comprimento em metros
     */
    public float getComprimento() {
        return comprimento;
    }

    /**
     * Define o comprimento do cabo.
     *
     * @param comprimento novo comprimento em metros
     */
    public void setComprimento(float comprimento) {
        this.comprimento = comprimento;
    }
}