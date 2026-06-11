package com.ufla.Servicos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ufla.usuarios.*;

/**
 * Classe responsável pelo gerenciamento da persistência de usuários
 * em arquivos CSV.
 * <p>
 * Esta classe permite salvar e carregar objetos do tipo {@code Usuario},
 * incluindo suas subclasses {@code Cliente} e {@code Lojista},
 * utilizando o arquivo {@code dados/usuarios.csv}.
 * </p>
 *
 * @author Grupo 2 - UFLA
 * @version 1.0
 */
public class GerenciadorUsuariosCSV {

    /**
     * Caminho do arquivo utilizado para armazenar os usuários.
     */
    private static final String ARQUIVO_USUARIOS = "dados/usuarios.csv";

    /**
     * Salva uma lista de usuários em um arquivo CSV.
     * <p>
     * O método sobrescreve o conteúdo existente no arquivo e grava
     * os dados de cada usuário, identificando se ele é um cliente
     * ou um lojista.
     * </p>
     *
     * @param usuarios lista de usuários a serem armazenados
     */
    public static void salvarUsuarios(List<Usuario> usuarios) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO_USUARIOS))) {

            bw.write("id;nomeUsuario;email;senha;tipo;cpf_cnpj;telefone;endereco");
            bw.newLine();

            for (Usuario usuario : usuarios) {

                String linha = String.format("%d;%s;%s;%s;%s;%s;%s;%s",

                        usuario.getId(),
                        usuario.getNomeUsuario(),
                        usuario.getEmail(),
                        usuario.getSenha(),
                        usuario instanceof Cliente ? "Cliente" : "Lojista",
                        usuario instanceof Cliente ? ((Cliente) usuario).getCpf()
                                : ((Lojista) usuario).getCnpj(),
                        usuario instanceof Cliente ? ((Cliente) usuario).getTelefone() : "",
                        usuario instanceof Cliente ? ((Cliente) usuario).getEndereco() : "");

                bw.write(linha);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Carrega os usuários armazenados no arquivo CSV.
     * <p>
     * O método lê o arquivo linha por linha, identifica o tipo
     * de usuário armazenado e cria a instância correspondente
     * ({@code Cliente} ou {@code Lojista}).
     * </p>
     *
     * @return uma lista contendo todos os usuários carregados do arquivo.
     *         Retorna uma lista vazia caso o arquivo não exista.
     */
    public List<Usuario> carregarUsuarios() {

        List<Usuario> usuarios = new ArrayList<>();

        File arquivo = new File(ARQUIVO_USUARIOS);

        if (!arquivo.exists()) {
            return usuarios;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(ARQUIVO_USUARIOS))) {
            String linha;

            // Ignora o cabeçalho do arquivo
            br.readLine();

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");

                int id = Integer.parseInt(dados[0]);
                String nomeUsuario = dados[1];
                String email = dados[2];
                String senha = dados[3];
                String tipo = dados[4];

                if (tipo.equals("Cliente")) {
                    String cpf = dados[5];
                    String telefone = dados[6];
                    String endereco = dados[7];

                    Cliente cliente = new Cliente(
                            id,
                            nomeUsuario,
                            email,
                            senha,
                            cpf,
                            telefone,
                            endereco);

                    usuarios.add(cliente);

                } else if (tipo.equals("Lojista")) {
                    String cnpj = dados[5];

                    Lojista lojista = new Lojista(
                            id,
                            nomeUsuario,
                            email,
                            senha,
                            cnpj);

                    usuarios.add(lojista);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return usuarios;
    }
}