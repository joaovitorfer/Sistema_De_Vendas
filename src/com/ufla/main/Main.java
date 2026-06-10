package com.ufla.main;

import java.util.List;
import java.util.Scanner;

import com.ufla.Servicos.GerenciadorProdutosCSV;
import com.ufla.compras.ItemPedido;
import com.ufla.compras.Pedido;
import com.ufla.produtos.Produto;
import com.ufla.usuarios.Cliente;
import com.ufla.usuarios.Lojista;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    private static List<Produto> produtos;

    private static Cliente cliente = new Cliente(
            1,
            "cliente",
            "cliente@email.com",
            "123",
            "11111111111",
            "999999999",
            "Rua A");

    private static Lojista lojista = new Lojista(
            2,
            "lojista",
            "lojista@email.com",
            "123",
            "12345678000100");

    private static int idPedido = 1;

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

    private static Produto buscarProduto(int id) {

        for (Produto p : produtos) {

            if (p.getIdProduto() == id) {
                return p;
            }
        }

        return null;
    }

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

    private static void mostrarCarrinho() {

        System.out.println("\n=== CARRINHO ===");

        for (ItemPedido item : cliente.getCarrinho().getItens()) {

            System.out.println(item);
        }

        System.out.println(
                "Total: R$ " + cliente.getCarrinho().calcularTotal());
    }

    private static void removerDoCarrinho() {

        System.out.print("ID do produto: ");
        int id = sc.nextInt();

        cliente.getCarrinho()
                .removerItem(id);

        System.out.println("Item removido.");
    }

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
