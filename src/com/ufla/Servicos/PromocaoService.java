package com.ufla.Servicos;

import com.ufla.produtos.Produto;

/**
 * Classe responsável por gerenciar promoções automáticas com base
 * na quantidade de itens em estoque.
 * <p>
 * A promoção é aplicada quando o estoque de um produto atinge
 * um limite considerado alto ou baixo, reduzindo seu preço
 * de acordo com um percentual de desconto configurado.
 * </p>
 *
 * @author Grupo 2 - UFLA
 * @version 1.0
 */
public class PromocaoService {

    /**
     * Quantidade mínima para considerar o estoque alto.
     */
    private int limiteEstoqueAlto;

    /**
     * Quantidade máxima para considerar o estoque baixo.
     */
    private int limiteEstoqueBaixo;

    /**
     * Percentual de desconto aplicado aos produtos elegíveis.
     */
    private float percentualDesconto;

    /**
     * Constrói um serviço de promoções automáticas.
     *
     * @param limiteEstoqueAlto quantidade mínima para caracterizar estoque alto
     * @param limiteEstoqueBaixo quantidade máxima para caracterizar estoque baixo
     * @param percentualDesconto percentual de desconto a ser aplicado
     */
    public PromocaoService(int limiteEstoqueAlto, int limiteEstoqueBaixo, float percentualDesconto) {
        this.limiteEstoqueAlto = limiteEstoqueAlto;
        this.limiteEstoqueBaixo = limiteEstoqueBaixo;
        this.percentualDesconto = percentualDesconto;
    }

    /**
     * Verifica se o produto possui estoque considerado alto.
     *
     * @param produto produto a ser analisado
     * @return {@code true} se o estoque for maior ou igual ao limite
     *         configurado; {@code false} caso contrário
     */
    public boolean verificarEstoqueAlto(Produto produto) {
        return produto.getEstoque() >= limiteEstoqueAlto;
    }

    /**
     * Verifica se o produto possui estoque considerado baixo.
     *
     * @param produto produto a ser analisado
     * @return {@code true} se o estoque for menor ou igual ao limite
     *         configurado; {@code false} caso contrário
     */
    public boolean verificarEstoqueBaixo(Produto produto) {
        return produto.getEstoque() <= limiteEstoqueBaixo;
    }

    /**
     * Aplica automaticamente um desconto ao produto caso ele
     * possua estoque alto ou baixo.
     * <p>
     * O novo preço é calculado com base no percentual de desconto
     * configurado no serviço.
     * </p>
     *
     * @param produto produto que poderá receber o desconto
     */
    public void aplicarPromocaoAutomatica(Produto produto) {

        if (verificarEstoqueAlto(produto) || verificarEstoqueBaixo(produto)) {

            float novoPreco = (float) (produto.getPreco()
                    - (produto.getPreco() * (percentualDesconto / 100)));

            produto.setPreco(novoPreco);

            System.out.println(
                    "Promoção aplicada ao produto: "
                            + produto.getNome()
                            + ". Novo preço: R$"
                            + produto.getPreco());

        } else {

            System.out.println(
                    "Produto "
                            + produto.getNome()
                            + " não se qualifica para a promoção.");
        }
    }
}