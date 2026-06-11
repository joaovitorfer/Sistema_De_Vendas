package com.ufla.Servicos;

import com.ufla.produtos.Produto;

/**
 * Classe responsável por gerenciar promoções automáticas de produtos.
 * A aplicação de descontos é realizada com base nos limites de estoque
 * configurados para estoque alto ou estoque baixo.
 *
 * @author Grupo 2 - UFLA
 * @version 1.0
 */
public class PromocaoService {

    /** Quantidade mínima para considerar um estoque alto. */
    private int limiteEstoqueAlto;

    /** Quantidade máxima para considerar um estoque baixo. */
    private int limiteEstoqueBaixo;

    /** Percentual de desconto aplicado aos produtos elegíveis. */
    private float percentualDesconto;

    /**
     * Cria um novo serviço de promoções.
     *
     * @param limiteEstoqueAlto quantidade mínima para estoque alto
     * @param limiteEstoqueBaixo quantidade máxima para estoque baixo
     * @param percentualDesconto percentual de desconto a ser aplicado
     */
    public PromocaoService(int limiteEstoqueAlto,
                           int limiteEstoqueBaixo,
                           float percentualDesconto) {

        this.limiteEstoqueAlto = limiteEstoqueAlto;
        this.limiteEstoqueBaixo = limiteEstoqueBaixo;
        this.percentualDesconto = percentualDesconto;
    }

    /**
     * Verifica se o produto possui estoque considerado alto.
     *
     * @param produto produto a ser analisado
     * @return {@code true} se o estoque for maior ou igual ao limite definido,
     *         caso contrário {@code false}
     */
    public boolean verificarEstoqueAlto(Produto produto) {
        return produto.getEstoque() >= limiteEstoqueAlto;
    }

    /**
     * Verifica se o produto possui estoque considerado baixo.
     *
     * @param produto produto a ser analisado
     * @return {@code true} se o estoque for menor ou igual ao limite definido,
     *         caso contrário {@code false}
     */
    public boolean verificarEstoqueBaixo(Produto produto) {
        return produto.getEstoque() <= limiteEstoqueBaixo;
    }

    /**
     * Aplica automaticamente uma promoção ao produto caso ele
     * possua estoque alto ou estoque baixo.
     * O desconto é calculado com base no percentual configurado.
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