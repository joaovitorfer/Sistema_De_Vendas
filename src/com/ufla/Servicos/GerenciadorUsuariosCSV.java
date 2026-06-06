package com.ufla.Servicos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ufla.usuarios.Cliente;
import com.ufla.usuarios.Lojista;
import com.ufla.usuarios.Usuario;

public class GerenciadorUsuariosCSV {
    private static final String ARQUIVO_USUARIOS = "dados/usuarios.csv";

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
                        usuario instanceof Cliente ? ((Cliente) usuario).getCpf() : ((Lojista) usuario).getCnpj(),
                        usuario instanceof Cliente ? ((Cliente) usuario).getTelefone() : "",
                        usuario instanceof Cliente ? ((Cliente) usuario).getEndereco() : ""

                );

                bw.write(linha);
                bw.newLine();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Usuario> carregarUsuarios() {

        List<Usuario> usuarios = new ArrayList<>();

        File arquivo = new File(ARQUIVO_USUARIOS);

        if (!arquivo.exists()) {
            return usuarios;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(ARQUIVO_USUARIOS))) {
            String linha;
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
                    Cliente cliente = new Cliente(id, nomeUsuario, email, senha, cpf, telefone, endereco);
                    usuarios.add(cliente);

                } else if (tipo.equals("Lojista")) {
                    String cnpj = dados[5];
                    Lojista lojista = new Lojista(id, nomeUsuario, email, senha, cnpj);
                    usuarios.add(lojista);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usuarios;
    }
}