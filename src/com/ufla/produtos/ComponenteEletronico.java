package com.ufla.produtos;

/**
 * Classe abstrata que representa um componente eletrônico do sistema.
 * <p>
 * Todo componente eletrônico possui um fabricante e um datasheet,
 * além das características básicas definidas na classe Produto.
 * Esta classe serve como base para componentes específicos, como
 * resistores, capacitores, sensores, entre outros.
 * </p>
 *
 * @author Grupo 2 - UFLA
 * @version 1.0
 */
public abstract class ComponenteEletronico extends Produto {

    /** Nome do fabricante do componente eletrônico. */
    private String fabricante;

    /** Referência ou endereço do datasheet do componente. */
    private String datasheet;

    /**
     * Constrói um novo componente eletrônico.
     *
     * @param idProduto identificador único do produto
     * @param nome nome do produto
     * @param preco preço do produto
     * @param descricao descrição do produto
     * @param estoque quantidade disponível em estoque
     * @param fabricante fabricante do componente
     * @param datasheet referência ou link para o datasheet
     */
    public ComponenteEletronico(int idProduto, String nome, double preco,
                                String descricao, int estoque,
                                String fabricante, String datasheet) {
        super(idProduto, nome, preco, descricao, estoque);
        this.fabricante = fabricante;
        this.datasheet = datasheet;
    }

    /**
     * Exibe os detalhes técnicos do componente eletrônico.
     * Mostra o fabricante e a referência do datasheet.
     */
    @Override
    public void exibirDetalhesTecnicos() {
        System.out.println("Fabricante: " + fabricante);
        System.out.println("Datasheet: " + datasheet);
    }

    /**
     * Valida as especificações técnicas do componente.
     * <p>
     * Este método pode ser sobrescrito pelas subclasses para implementar
     * regras específicas de validação.
     * </p>
     *
     * @return {@code true} se as especificações forem válidas;
     *         {@code false} caso contrário
     */
    public boolean validarEspecificacao() {
        boolean conferir = false;

        return conferir;
    }

    /**
     * Retorna o fabricante do componente.
     *
     * @return nome do fabricante
     */
    public String getFabricante() {
        return fabricante;
    }

    /**
     * Define o fabricante do componente.
     *
     * @param fabricante novo fabricante
     */
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    /**
     * Retorna a referência do datasheet.
     *
     * @return datasheet do componente
     */
    public String getDatasheet() {
        return datasheet;
    }

    /**
     * Define a referência do datasheet.
     *
     * @param datasheet novo datasheet do componente
     */
    public void setDatasheet(String datasheet) {
        this.datasheet = datasheet;
    }
}