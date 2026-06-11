package com.ufla.Servicos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ufla.produtos.*;

/**
 * Classe responsável por gerenciar a persistência dos produtos em um arquivo CSV.
 * <p>
 * Permite salvar uma lista de produtos no arquivo
 * {@code dados/produtos.csv} e carregar os produtos armazenados,
 * recriando os objetos correspondentes às suas subclasses.
 * </p>
 *
 * @author Grupo 2 - UFLA
 * @version 1.0
 */
public class GerenciadorProdutosCSV {

    /**
     * Caminho do arquivo utilizado para armazenar os produtos.
     */
    private static final String ARQUIVO_PRODUTOS = "dados/produtos.csv";

    /**
     * Salva uma lista de produtos em um arquivo CSV.
     * <p>
     * O método sobrescreve o conteúdo existente do arquivo e grava
     * os dados específicos de cada tipo de produto eletrônico.
     * </p>
     *
     * @param produtos lista de produtos a serem armazenados
     */
    public static void salvarProdutos(List<Produto> produtos) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO_PRODUTOS))) {
            bw.write("tipo;idProduto;nome;preco;descricao;estoque;fabricante;datasheet;atributo1;atributo2");
            bw.newLine();

            for (Produto p : produtos) {
                String linha = "";

                if (p instanceof ComponenteEletronico) {
                    ComponenteEletronico ce = (ComponenteEletronico) p;
                    String base = ce.getClass().getSimpleName() + ";" + ce.getIdProduto() + ";" + ce.getNome()
                            + ";" + ce.getPreco() + ";" + ce.getDescricao() + ";" + ce.getEstoque() + ";"
                            + ce.getFabricante() + ";" + ce.getDatasheet();

                    if (p instanceof Resistor) {
                        Resistor r = (Resistor) p;
                        linha = base + ";" + r.getResistencia() + ";" + r.getPotencia();
                    } else if (p instanceof LED) {
                        LED l = (LED) p;
                        linha = base + ";" + l.getCor() + ";" + l.getTensao();
                    } else if (p instanceof Capacitor) {
                        Capacitor c = (Capacitor) p;
                        linha = base + ";" + c.getCapacitancia() + ";" + c.getVoltagem();
                    } else if (p instanceof Cabo) {
                        Cabo cb = (Cabo) p;
                        linha = base + ";" + cb.getTipoCabo() + ";" + cb.getComprimento();
                    } else if (p instanceof PlacaMicrocontroladora) {
                        PlacaMicrocontroladora pm = (PlacaMicrocontroladora) p;
                        linha = base + ";" + pm.getProcessador() + ";" + pm.getMemoria();
                    } else if (p instanceof Sensor) {
                        Sensor s = (Sensor) p;
                        linha = base + ";" + s.getTipoSensor() + ";" + s.getPrecisao();
                    }
                }

                if (!linha.isEmpty()) {
                    bw.write(linha);
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar produtos: " + e.getMessage());
        }
    }

    /**
     * Carrega os produtos armazenados no arquivo CSV.
     * <p>
     * Para cada linha do arquivo, o método identifica o tipo do produto
     * e instancia o objeto correspondente, adicionando-o à lista de retorno.
     * </p>
     *
     * @return lista contendo todos os produtos carregados do arquivo.
     *         Retorna uma lista vazia caso o arquivo não exista.
     */
    public static List<Produto> carregarProdutos() {
        List<Produto> produtos = new ArrayList<>();
        File arquivo = new File(ARQUIVO_PRODUTOS);

        if (!arquivo.exists()) {
            return produtos;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(ARQUIVO_PRODUTOS))) {
            String linha;

            // Ignora o cabeçalho do arquivo
            br.readLine();

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                String tipo = dados[0];

                int id = Integer.parseInt(dados[1]);
                String nome = dados[2];
                double preco = Double.parseDouble(dados[3]);
                String descricao = dados[4];
                int estoque = Integer.parseInt(dados[5]);
                String fabricante = dados[6];
                String datasheet = dados[7];

                if (tipo.equals("Resistor")) {
                    produtos.add(new Resistor(id, nome, preco, descricao, estoque, fabricante, datasheet,
                            Float.parseFloat(dados[8]), Float.parseFloat(dados[9])));
                } else if (tipo.equals("LED")) {
                    produtos.add(new LED(id, nome, preco, descricao, estoque, fabricante, datasheet,
                            dados[8], Float.parseFloat(dados[9])));
                } else if (tipo.equals("Capacitor")) {
                    produtos.add(new Capacitor(id, nome, preco, descricao, estoque, fabricante, datasheet,
                            Float.parseFloat(dados[8]), Float.parseFloat(dados[9])));
                } else if (tipo.equals("Cabo")) {
                    produtos.add(new Cabo(id, nome, preco, descricao, estoque, fabricante, datasheet,
                            dados[8], Float.parseFloat(dados[9])));
                } else if (tipo.equals("PlacaMicrocontroladora")) {
                    produtos.add(new PlacaMicrocontroladora(id, nome, preco, descricao, estoque, fabricante,
                            datasheet, dados[8], Integer.parseInt(dados[9])));
                } else if (tipo.equals("Sensor")) {
                    produtos.add(new Sensor(id, nome, preco, descricao, estoque, fabricante, datasheet,
                            dados[8], Float.parseFloat(dados[9])));
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar produtos: " + e.getMessage());
        }

        return produtos;
    }
}