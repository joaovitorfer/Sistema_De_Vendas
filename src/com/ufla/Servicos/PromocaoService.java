package com.ufla.Servicos;

import com.ufla.produtos.Produto;

public class PromocaoService {

private int limiteEstoqueAlto;
private int limiteEstoqueBaixo;
private float percentualDesconto;

    public PromocaoService(int limiteEstoqueAlto, int limiteEstoqueBaixo, float percentualDesconto) {
        this.limiteEstoqueAlto = limiteEstoqueAlto;
        this.limiteEstoqueBaixo = limiteEstoqueBaixo;
        this.percentualDesconto = percentualDesconto;
    }

    public boolean verificarEstoqueAlto(Produto produto){
        return produto.getEstoque() >= limiteEstoqueAlto;
    }

    public boolean verificarEstoqueBaixo(Produto produto){
        return produto.getEstoque() <= limiteEstoqueBaixo;
    }

    public void aplicarPromocaoAutomatica(Produto produto){
        if (verificarEstoqueAlto(produto) || verificarEstoqueBaixo(produto)) {
            float novoPreco = (float)(produto.getPreco() - (produto.getPreco() * (percentualDesconto / 100)));

            produto.setPreco(novoPreco);

            System.out.println("Promoção aplicada ao produto: " + produto.getNome() + ". Novo preço: R$" + produto.getPreco());
        } else {
            System.out.println("Produto " + produto.getNome() + " não se qualifica para a promoção.");
        }
    
    }
}
