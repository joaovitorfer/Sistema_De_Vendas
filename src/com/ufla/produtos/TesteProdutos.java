package com.ufla.produtos;

import java.util.ArrayList;
import java.util.List;

import com.ufla.Servicos.GerenciadorProdutosCSV;

public class TesteProdutos {
    public static void main(String[] args) {

        List<Produto> listaProdutos = new ArrayList<>();

        listaProdutos.add(new Resistor(1001, "Resistor 1k", 0.50, "Resistor de precisão", 100, "Fabricante X", "datasheet_res.pdf", 1000.0f, 0.25f));
        
        listaProdutos.add(new LED(2001, "LED Vermelho", 1.20, "LED 5mm alto brilho", 50, "Fabricante Y", "datasheet_led.pdf", "Vermelho", 2.0f));
        
        listaProdutos.add(new Capacitor(3001, "Capacitor 100uF", 2.50, "Eletrolítico", 30, "Fabricante Z", "datasheet_cap.pdf", 100.0f, 16.0f));

        System.out.println("Salvando produtos no arquivo...");
        GerenciadorProdutosCSV.salvarProdutos(listaProdutos);
        
        System.out.println("Processo finalizado com sucesso!");

        System.out.println("\n--- Iniciando teste de leitura do arquivo ---");
        List<Produto> listaLida = GerenciadorProdutosCSV.carregarProdutos();

        if (listaLida.isEmpty()) {
            System.out.println("Nenhum produto encontrado no arquivo.");
        } else {
            System.out.println("Produtos recuperados com sucesso:");
            for (Produto p : listaLida) {
                System.out.println("Produto: " + p.getNome());
                p.exibirDetalhesTecnicos();
                System.out.println("-------------------------");
            }
        }
    }
    
}