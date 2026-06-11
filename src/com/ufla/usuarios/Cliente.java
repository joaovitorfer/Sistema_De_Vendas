package com.ufla.usuarios;

import com.ufla.compras.Carrinho;
import java.time.LocalDate;

/**
 * Representa um cliente cadastrado no sistema.
 * <p>
 * A classe {@code Cliente} herda os atributos e comportamentos
 * básicos da classe {@code Usuario} e adiciona informações
 * específicas de clientes, como CPF, telefone, endereço e
 * um carrinho de compras para armazenar produtos selecionados.
 * </p>
 * <p>
 * Cada cliente possui um carrinho criado automaticamente
 * no momento de sua instanciação.
 * </p>
 *
 * @author Grupo 2 - UFLA
 * @version 1.0
 * @since 1.0
 */
public class Cliente extends Usuario {

    /**
     * Cadastro de Pessoa Física (CPF) do cliente.
     */
    private String cpf;

    /**
     * Número de telefone para contato.
     */
    private String telefone;

    /**
     * Endereço residencial do cliente.
     */
    private String endereco;

    /**
     * Carrinho de compras associado ao cliente.
     */
    private Carrinho carrinho;

    /**
     * Cria um novo cliente.
     * <p>
     * Ao criar o cliente, um carrinho de compras é automaticamente
     * instanciado utilizando o identificador do cliente e a data atual.
     * </p>
     *
     * @param id identificador único do cliente
     * @param nomeUsuario nome de usuário utilizado para acesso ao sistema
     * @param email endereço de e-mail do cliente
     * @param senha senha de autenticação
     * @param cpf CPF do cliente
     * @param telefone telefone para contato
     * @param endereco endereço residencial
     */
    public Cliente(int id, String nomeUsuario, String email, String senha,
                   String cpf, String telefone, String endereco) {
        super(id, nomeUsuario, email, senha);
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
        this.carrinho = new Carrinho(id, LocalDate.now().toString());
    }

    /**
     * Retorna o CPF do cliente.
     *
     * @return CPF cadastrado
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Define um novo CPF para o cliente.
     *
     * @param cpf novo CPF
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * Retorna o telefone do cliente.
     *
     * @return telefone cadastrado
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Define um novo telefone para o cliente.
     *
     * @param telefone novo telefone
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Retorna o endereço do cliente.
     *
     * @return endereço cadastrado
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * Define um novo endereço para o cliente.
     *
     * @param endereco novo endereço
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * Retorna o carrinho de compras associado ao cliente.
     *
     * @return carrinho de compras do cliente
     */
    public Carrinho getCarrinho() {
        return carrinho;
    }

    /**
     * Define um novo carrinho de compras para o cliente.
     *
     * @param carrinho novo carrinho de compras
     */
    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    /**
     * Realiza o cadastro do cliente no sistema.
     * <p>
     * Implementação concreta do método abstrato definido
     * na classe {@code Usuario}.
     * </p>
     */
    public void cadastrar() {
        System.out.println("Cliente cadastrado.");
    }

    /**
     * Atualiza os dados do cliente no sistema.
     * <p>
     * Implementação concreta do método abstrato definido
     * na classe {@code Usuario}.
     * </p>
     */
    public void atualizar() {
        System.out.println("Cliente atualizado.");
    }
}