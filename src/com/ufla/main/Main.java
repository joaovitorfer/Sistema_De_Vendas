package com.ufla.main;

import java.util.List;
import java.util.Scanner;

import com.ufla.Servicos.GerenciadorProdutosCSV;
import com.ufla.compras.ItemPedido;
import com.ufla.compras.Pedido;
import com.ufla.produtos.Produto;
import com.ufla.usuarios.Cliente;
import com.ufla.usuarios.Lojista;
import com.ufla.Servicos.GerenciadorUsuariosCSV;
import com.ufla.usuarios.Usuario;
import com.ufla.Servicos.PromocaoService;

/**
 * Classe principal do Sistema de Vendas.
 * <p>
 * Responsável por inicializar a aplicação, carregar os dados de
 * produtos e usuários e controlar o fluxo de navegação entre
 * as áreas de cliente e lojista.
 * </p>
 *
 * @author Grupo 2 - UFLA
 * @version 1.0
 */
public class Main {

    /** Scanner utilizado para leitura das entradas do usuário. */
    private static Scanner sc = new Scanner(System.in);

    /** Lista contendo todos os produtos cadastrados no sistema. */
    private static List<Produto> produtos;

    /** Gerenciador responsável pela persistência dos usuários em arquivos CSV. */
    private static GerenciadorUsuariosCSV gerenciadorUsuarios =
            new GerenciadorUsuariosCSV();

    /** Lista de usuários carregados do arquivo CSV. */
    private static List<Usuario> usuarios =
            gerenciadorUsuarios.carregarUsuarios();

    /** Cliente atualmente autenticado no sistema. */
    private static Cliente clienteLogado = null;

    /** Lojista atualmente autenticado no sistema. */
    private static Lojista lojistaLogado = null;

    /** Identificador sequencial utilizado para geração de pedidos. */
    private static int idPedido = 1;

    /**
     * Método principal da aplicação.
     * <p>
     * Carrega os produtos cadastrados e exibe o menu principal,
     * permitindo ao usuário acessar a área de cliente,
     * a área de lojista ou encerrar o sistema.
     * </p>
     *
     * @param args argumentos de linha de comando (não utilizados)
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
                    areaCliente();
                    break;

                case 2:
                    areaLojista();
                    break;
            }

        } while (opcao != 0);

        System.out.println("Sistema encerrado.");
    }

    /**
     * Exibe o menu da área do cliente.
     * <p>
     * Permite que o usuário realize login, efetue seu cadastro
     * ou retorne ao menu principal do sistema.
     * </p>
     */
    private static void areaCliente() {

        int opcao;

        do {

            System.out.println("\n=== CLIENTE ===");
            System.out.println("1 - Login");
            System.out.println("2 - Registrar");
            System.out.println("0 - Voltar");

            opcao = sc.nextInt();

            switch (opcao) {

                case 1:
                    loginCliente();
                    break;

                case 2:
                    registrarCliente();
                    break;
            }

        } while (opcao != 0);
    }

/**
 * Exibe o menu da área do lojista.
 * <p>
 * Permite que o usuário realize login, efetue seu cadastro
 * ou retorne ao menu principal do sistema.
 * </p>
 */
private static void areaLojista() {

    int opcao;

    do {

        System.out.println("\n=== LOJISTA ===");
        System.out.println("1 - Login");
        System.out.println("2 - Registrar");
        System.out.println("0 - Voltar");

        opcao = sc.nextInt();

        switch (opcao) {

            case 1:
                loginLojista();
                break;

            case 2:
                registrarLojista();
                break;
        }

    } while (opcao != 0);
}

/**
 * Realiza a autenticação de um cliente no sistema.
 * <p>
 * Solicita o e-mail e a senha do usuário, verifica se as
 * credenciais correspondem a um cliente cadastrado e,
 * em caso de sucesso, define o cliente como usuário logado
 * e direciona para o menu do cliente.
 * </p>
 * <p>
 * Caso as credenciais sejam inválidas, uma mensagem de erro
 * é exibida ao usuário.
 * </p>
 */
private static void loginCliente() {

    sc.nextLine();

    System.out.print("Email: ");
    String email = sc.nextLine();

    System.out.print("Senha: ");
    String senha = sc.nextLine();

    for (Usuario usuario : usuarios) {

        if (usuario instanceof Cliente
                && usuario.getEmail().equals(email)
                && usuario.getSenha().equals(senha)) {

            clienteLogado = (Cliente) usuario;

            menuCliente();

            return;
        }
    }

    System.out.println("Login inválido.");
}

/**
 * Realiza a autenticação de um lojista no sistema.
 * <p>
 * Solicita o e-mail e a senha do usuário, verifica se as
 * credenciais correspondem a um lojista cadastrado e,
 * em caso de sucesso, define o lojista como usuário logado
 * e direciona para o menu do lojista.
 * </p>
 * <p>
 * Caso as credenciais sejam inválidas, uma mensagem de erro
 * é exibida ao usuário.
 * </p>
 */
private static void loginLojista() {

    sc.nextLine();

    System.out.print("Email: ");
    String email = sc.nextLine();

    System.out.print("Senha: ");
    String senha = sc.nextLine();

    for (Usuario usuario : usuarios) {

        if (usuario instanceof Lojista
                && usuario.getEmail().equals(email)
                && usuario.getSenha().equals(senha)) {

            lojistaLogado = (Lojista) usuario;

            menuLojista();

            return;
        }
    }

    System.out.println("Login inválido.");
}
/**
 * Realiza o cadastro de um novo cliente no sistema.
 * <p>
 * Solicita os dados pessoais do cliente, incluindo nome,
 * e-mail, senha, CPF, telefone e endereço.
 * </p>
 * <p>
 * Antes de concluir o cadastro, verifica se o e-mail informado
 * já está associado a outro usuário. Caso o e-mail já exista,
 * o cadastro é cancelado e uma mensagem de aviso é exibida.
 * </p>
 * <p>
 * Em caso de sucesso, o cliente é adicionado à lista de usuários
 * e os dados são persistidos no arquivo CSV.
 * </p>
 */
private static void registrarCliente() {

    sc.nextLine();

    System.out.print("Nome: ");
    String nome = sc.nextLine();

    System.out.print("Email: ");
    String email = sc.nextLine();

    System.out.print("Senha: ");
    String senha = sc.nextLine();

    System.out.print("CPF: ");
    String cpf = sc.nextLine();

    System.out.print("Telefone: ");
    String telefone = sc.nextLine();

    System.out.print("Endereco: ");
    String endereco = sc.nextLine();

    for (Usuario usuario : usuarios) {
        if (usuario.getEmail().equals(email)) {
            System.out.println("Já existe um usuário com esse email.");
            return;
        }
    }

    Cliente cliente = new Cliente(
            usuarios.size() + 1,
            nome,
            email,
            senha,
            cpf,
            telefone,
            endereco
    );

    usuarios.add(cliente);

    GerenciadorUsuariosCSV.salvarUsuarios(usuarios);

    System.out.println("Cliente cadastrado.");
}

/**
 * Realiza o cadastro de um novo lojista no sistema.
 * <p>
 * Solicita os dados necessários para o cadastro,
 * incluindo nome, e-mail, senha e CNPJ.
 * </p>
 * <p>
 * Antes de concluir o cadastro, verifica se o e-mail informado
 * já está associado a outro usuário. Caso o e-mail já exista,
 * o cadastro é cancelado e uma mensagem de aviso é exibida.
 * </p>
 * <p>
 * Em caso de sucesso, o lojista é adicionado à lista de usuários
 * e os dados são persistidos no arquivo CSV.
 * </p>
 */
private static void registrarLojista() {

    sc.nextLine();

    System.out.print("Nome: ");
    String nome = sc.nextLine();

    System.out.print("Email: ");
    String email = sc.nextLine();

    System.out.print("Senha: ");
    String senha = sc.nextLine();

    System.out.print("CNPJ: ");
    String cnpj = sc.nextLine();

    for (Usuario usuario : usuarios) {
        if (usuario.getEmail().equals(email)) {
            System.out.println("Já existe um usuário com esse email.");
            return;
        }
    }

    Lojista lojista = new Lojista(
            usuarios.size() + 1,
            nome,
            email,
            senha,
            cnpj
    );

    usuarios.add(lojista);

    GerenciadorUsuariosCSV.salvarUsuarios(usuarios);

    System.out.println("Lojista cadastrado.");
}

/**
 * Exibe o menu principal do cliente autenticado.
 * <p>
 * Permite ao cliente realizar operações relacionadas às compras,
 * como visualizar produtos disponíveis, adicionar itens ao carrinho,
 * consultar o carrinho de compras, remover itens e finalizar pedidos.
 * </p>
 * <p>
 * O menu permanece ativo até que o usuário escolha a opção de voltar.
 * Ao encerrar o menu, o cliente é desconectado do sistema, removendo
 * a referência ao usuário atualmente logado.
 * </p>
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

    clienteLogado = null;
}
/**
 * Exibe o menu principal do lojista autenticado.
 * <p>
 * Permite ao lojista visualizar os produtos cadastrados,
 * alterar a quantidade em estoque, salvar as alterações
 * realizadas nos produtos e aplicar promoções automáticas.
 * </p>
 * <p>
 * O menu permanece ativo até que o usuário escolha a opção
 * de voltar. Ao sair do menu, o lojista é desconectado do
 * sistema, encerrando sua sessão.
 * </p>
 */
private static void menuLojista() {

    int opcao;

    do {

        System.out.println("\n=== MENU LOJISTA ===");
        System.out.println("1 - Listar produtos");
        System.out.println("2 - Alterar estoque");
        System.out.println("3 - Salvar produtos");
        System.out.println("4 - Aplicar promoção");
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

            case 4:
                aplicarPromocao();
                break;
        }

    } while (opcao != 0);

    lojistaLogado = null;
}

/**
 * Exibe a lista de produtos cadastrados no sistema.
 * <p>
 * Para cada produto são apresentados seu identificador,
 * nome, preço e quantidade disponível em estoque.
 * </p>
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
 * Aplica uma promoção automática a um produto selecionado.
 * <p>
 * Inicialmente exibe a lista de produtos disponíveis e solicita
 * ao lojista o identificador do produto desejado.
 * </p>
 * <p>
 * Caso o produto seja encontrado, uma instância do serviço de
 * promoção é criada e a promoção automática é aplicada conforme
 * as regras definidas no sistema.
 * </p>
 * <p>
 * Caso o produto informado não exista, uma mensagem de erro é
 * exibida e a operação é encerrada.
 * </p>
 */
private static void aplicarPromocao() {

    listarProdutos();

    System.out.print("ID do produto: ");
    int id = sc.nextInt();

    Produto produto = buscarProduto(id);

    if (produto == null) {
        System.out.println("Produto não encontrado.");
        return;
    }

    PromocaoService promocao =
            new PromocaoService(100, 5, 10);

    promocao.aplicarPromocaoAutomatica(produto);
}

/**
 * Busca um produto na lista de produtos cadastrados a partir
 * do seu identificador.
 *
 * @param id identificador do produto a ser procurado
 * @return o produto encontrado ou {@code null} caso não exista
 *         um produto com o identificador informado
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
 * Adiciona um produto ao carrinho de compras do cliente logado.
 * <p>
 * Exibe a lista de produtos disponíveis, solicita o identificador
 * do produto e a quantidade desejada e adiciona o item ao carrinho.
 * </p>
 * <p>
 * Caso o produto informado não seja encontrado, a operação é
 * cancelada e uma mensagem de erro é exibida.
 * </p>
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

    clienteLogado.getCarrinho()
            .adicionarItem(produto, quantidade);

    System.out.println("Produto adicionado.");
}

/**
 * Exibe os itens presentes no carrinho de compras do cliente.
 * <p>
 * Para cada item são apresentadas suas informações e, ao final,
 * é exibido o valor total da compra.
 * </p>
 */
private static void mostrarCarrinho() {

    System.out.println("\n=== CARRINHO ===");

    for (ItemPedido item : clienteLogado.getCarrinho().getItens()) {

        System.out.println(item);
    }

    System.out.println(
            "Total: R$ " + clienteLogado.getCarrinho().calcularTotal());
}

/**
 * Remove um produto do carrinho de compras do cliente.
 * <p>
 * Solicita o identificador do produto que deve ser removido
 * e executa a remoção do item correspondente.
 * </p>
 */
private static void removerDoCarrinho() {

    System.out.print("ID do produto: ");
    int id = sc.nextInt();

    clienteLogado.getCarrinho()
            .removerItem(id);

    System.out.println("Item removido.");
}


/**
 * Finaliza o pedido atual do cliente.
 * <p>
 * Gera um pedido a partir dos itens presentes no carrinho,
 * atribui um identificador único ao pedido e exibe sua fatura.
 * </p>
 * <p>
 * Após a conclusão da compra, os dados dos produtos são
 * atualizados e salvos para refletir as alterações de estoque.
 * </p>
 */
private static void finalizarPedido() {

    Pedido pedido = clienteLogado.getCarrinho().finalizarPedido(idPedido);

    if (pedido == null) {
        return;
    }

    idPedido++;

    System.out.println("\n=== PEDIDO ===");
    System.out.println(pedido.gerarFatura());

    GerenciadorProdutosCSV.salvarProdutos(produtos);
}

/**
 * Altera a quantidade em estoque de um produto.
 * <p>
 * Exibe a lista de produtos disponíveis, solicita o identificador
 * do produto desejado e a nova quantidade em estoque.
 * </p>
 * <p>
 * Caso o produto informado não seja encontrado, a operação é
 * cancelada e uma mensagem de erro é exibida.
 * </p>
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

