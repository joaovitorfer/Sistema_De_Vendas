package com.ufla.usuarios;

import java.util.ArrayList;
import java.util.List;
import com.ufla.Servicos.GerenciadorUsuariosCSV;

public class Teste {
    public static void main(String[] args) {
        System.out.println(" --- INICIANDO TESTE DO SISTEMA DE ARQUIVOS --- \n");

        GerenciadorUsuariosCSV gerenciador = new GerenciadorUsuariosCSV();

        List<Usuario> usuariosTeste = new ArrayList<>();

        Cliente cliente = new Cliente(
            1, 
            "Bernardo", 
            "bernardo@email.com", 
            "senha123", 
            "123.456.789-00", 
            "(35) 99999-9999", 
            "Câmpus Universitário da UFLA"
        );

        Lojista lojista = new Lojista(
            2, 
            "TechStore", 
            "contato@techstore.com", 
            "admin456", 
            "12.345.678/0001-99"
        );

        usuariosTeste.add(cliente);
        usuariosTeste.add(lojista);

        System.out.println(" Gravando usuários no arquivo CSV...");
        GerenciadorUsuariosCSV.salvarUsuarios(usuariosTeste); 
        System.out.println(" Dados gravados com sucesso!\n");

        System.out.println("--------------------------------------------------\n");

        System.out.println(" Lendo e carregando os dados do arquivo CSV...");
        List<Usuario> usuariosCarregados = gerenciador.carregarUsuarios();

        System.out.println(" Usuários recuperados do arquivo:");
        for (Usuario u : usuariosCarregados) {
            System.out.println("- [ID: " + u.getId() + "] " + u.getNomeUsuario() + " (" + u.getEmail() + ")");
        }
        
        System.out.println("\n Fim do teste! Verifique se a pasta 'dados' foi atualizada.");
    }
}