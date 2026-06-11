package com.ufla.main;

import java.util.List;
import java.util.Scanner;

import com.ufla.Servicos.GerenciadorProdutosCSV;
import com.ufla.compras.ItemPedido;
import com.ufla.compras.Pedido;
import com.ufla.produtos.Produto;
import com.ufla.usuarios.Cliente;
import com.ufla.usuarios.Lojista;

/**
 * Classe principal do sistema de vendas.
 * Responsável por inicializar os dados, carregar os produtos
 * e exibir os menus de interação para clientes e lojistas.
 *
 * @author Grupo 2 - UFLA
 * @version 1.0
 */
public class Main {

    /** Scanner utilizado para leitura de dados do teclado. */
    private static Scanner sc = new Scanner(System.in);

    /** Lista de produtos disponíveis no sistema. */
    private static List<Produto> produtos;

    /** Cliente padrão utilizado para testes e operações de compra. */
    private static Cliente cliente = new Cliente(
            1,
            "cliente",
            "cliente@email.com",
            "123",
            "11111111111",
            "999999999",
            "Rua A");

    /** Lojista padrão utilizado para gerenciamento dos produtos. */
    private static Lojista lojista = new Lojista(
            2,
            "lojista",
            "lojista@email.com",
            "123",
            "12345678000100");

    /** Identificador utilizado para geração de novos pedidos. */
    private static int idPedido = 1;

    /**
     * Método principal do programa.
     * Carrega os produtos cadastrados, exibe o menu principal
     * e direciona o usuário para as funcionalidades de cliente
     * ou lojista.
     *
     * @param args argumentos da linha de comando (não utilizados)
     */
    public static void main(String[] args) {

        produtos = GerenciadorProdutosCSV.carregarProdutos();

        int opcao;

        do {

            System.out.println("\n=== SISTEMA DE VENDAS ===");
            System.out.println("1 - Cliente");
            System.out.println("2 - Lojista");
            System.out.println("0 - Sair");

            opcao = sc.nextInt();

            switch (opcao) {

                case 1:
                    menuCliente();
                    break;

                case 2:
                    menuLojista();
                    break;
            }

        } while (opcao != 0);

        System.out.println("Sistema encerrado.");
    }
    /**
 * Exibe o menu do cliente e permite realizar operações
 * relacionadas ao carrinho de compras e aos pedidos.
 * O menu permanece ativo até que o usuário escolha
 * a opção de voltar ao menu principal.
 */
private static void menuCliente() {

    int opcao;

    do {

        System.out.println("\n=== MENU CLIENTE ===");
        System.out.println("1 - Listar produtos");
        System.out.println("2 - Adicionar ao carrinho");
        System.out.println("3 - Ver carrinho");
        System.out.println("4 - Remover item");
        System.out.println("5 - Finalizar pedido");
        System.out.println("0 - Voltar");

        opcao = sc.nextInt();

        switch (opcao) {

            case 1:
                listarProdutos();
                break;

            case 2:
                adicionarAoCarrinho();
                break;

            case 3:
                mostrarCarrinho();
                break;

            case 4:
                removerDoCarrinho();
                break;

            case 5:
                finalizarPedido();
                break;
        }

    } while (opcao != 0);
}

/**
 * Exibe o menu do lojista e permite gerenciar os
 * produtos cadastrados, incluindo consulta,
 * atualização de estoque e salvamento dos dados.
 * O menu permanece ativo até que o usuário escolha
 * retornar ao menu principal.
 */
private static void menuLojista() {

    int opcao;

    do {

        System.out.println("\n=== MENU LOJISTA ===");
        System.out.println("1 - Listar produtos");
        System.out.println("2 - Alterar estoque");
        System.out.println("3 - Salvar produtos");
        System.out.println("0 - Voltar");

        opcao = sc.nextInt();

        switch (opcao) {

            case 1:
                listarProdutos();
                break;

            case 2:
                alterarEstoque();
                break;

            case 3:
                GerenciadorProdutosCSV.salvarProdutos(produtos);
                System.out.println("Produtos salvos.");
                break;
        }

    } while (opcao != 0);
}
/**
 * Exibe na tela a lista de produtos disponíveis no sistema,
 * apresentando o identificador, nome, preço e quantidade
 * em estoque de cada produto.
 */
private static void listarProdutos() {

    System.out.println("\n=== PRODUTOS ===");

    for (Produto p : produtos) {

        System.out.println(
                p.getIdProduto()
                        + " - "
                        + p.getNome()
                        + " | R$ "
                        + p.getPreco()
                        + " | Estoque: "
                        + p.getEstoque());
    }
}

/**
 * Procura um produto na lista de produtos cadastrados
 * a partir do seu identificador.
 *
 * @param id identificador do produto a ser pesquisado
 * @return o produto encontrado ou {@code null} caso não exista
 */
private static Produto buscarProduto(int id) {

    for (Produto p : produtos) {

        if (p.getIdProduto() == id) {
            return p;
        }
    }

    return null;
}

/**
 * Permite ao cliente adicionar um produto ao carrinho de compras.
 * O método exibe os produtos disponíveis, solicita o identificador
 * e a quantidade desejada e adiciona o item ao carrinho do cliente.
 * Caso o produto informado não exista, uma mensagem de erro é exibida.
 */
private static void adicionarAoCarrinho() {

    listarProdutos();

    System.out.print("ID do produto: ");
    int id = sc.nextInt();

    Produto produto = buscarProduto(id);

    if (produto == null) {

        System.out.println("Produto não encontrado.");
        return;
    }

    System.out.print("Quantidade: ");
    int quantidade = sc.nextInt();

    cliente.getCarrinho()
            .adicionarItem(produto, quantidade);

    System.out.println("Produto adicionado.");
}
/**
 * Exibe os itens atualmente presentes no carrinho de compras
 * do cliente, bem como o valor total calculado da compra.
 */
private static void mostrarCarrinho() {

    System.out.println("\n=== CARRINHO ===");

    for (ItemPedido item : cliente.getCarrinho().getItens()) {

        System.out.println(item);
    }

    System.out.println(
            "Total: R$ " + cliente.getCarrinho().calcularTotal());
}

/**
 * Remove um produto do carrinho de compras do cliente a partir
 * do identificador informado pelo usuário.
 */
private static void removerDoCarrinho() {

    System.out.print("ID do produto: ");
    int id = sc.nextInt();

    cliente.getCarrinho()
            .removerItem(id);

    System.out.println("Item removido.");
}

/**
 * Finaliza o pedido com os itens presentes no carrinho do cliente.
 * Após a confirmação, gera e exibe a fatura do pedido, incrementa
 * o identificador de pedidos e salva as alterações dos produtos.
 */
private static void finalizarPedido() {

    Pedido pedido = cliente.getCarrinho().finalizarPedido(idPedido);

    if (pedido == null) {
        return;
    }

    idPedido++;

    System.out.println("\n=== PEDIDO ===");
    System.out.println(pedido.gerarFatura());

    GerenciadorProdutosCSV.salvarProdutos(produtos);
}

/**
 * Permite ao lojista alterar a quantidade em estoque de um produto.
 * O método solicita o identificador do produto, localiza o item
 * correspondente e atualiza seu estoque com o novo valor informado.
 * Caso o produto não seja encontrado, uma mensagem de erro é exibida.
 */
private static void alterarEstoque() {

    listarProdutos();

    System.out.print("ID do produto: ");
    int id = sc.nextInt();

    Produto produto = buscarProduto(id);

    if (produto == null) {

        System.out.println("Produto não encontrado.");
        return;
    }

    System.out.print("Novo estoque: ");
    int estoque = sc.nextInt();

    produto.setEstoque(estoque);

    System.out.println("Estoque atualizado.");
    }
}