package com.ufla.usuarios;

import com.ufla.compras.Carrinho;
import java.time.LocalDate;

/**
 * Representa um cliente do sistema.
 * 
 * <p>Esta classe herda de {@code Usuario} e adiciona informações
 * específicas de um cliente, como CPF, telefone, endereço e um
 * carrinho de compras.</p>
 * 
 * @author Grupo 2 - UFLA
 * @version 1.0
 */
public class Cliente extends Usuario {

    /** CPF do cliente. */
    private String cpf;

    /** Telefone para contato do cliente. */
    private String telefone;

    /** Endereço do cliente. */
    private String endereco;

    /** Carrinho de compras associado ao cliente. */
    private Carrinho carrinho;

    /**
     * Constrói um novo cliente.
     *
     * @param id Identificador do usuário.
     * @param nomeUsuario Nome de usuário.
     * @param email E-mail do cliente.
     * @param senha Senha de acesso.
     * @param cpf CPF do cliente.
     * @param telefone Telefone para contato.
     * @param endereco Endereço do cliente.
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
     * @return CPF do cliente.
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Define o CPF do cliente.
     *
     * @param cpf Novo CPF do cliente.
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * Retorna o telefone do cliente.
     *
     * @return Telefone do cliente.
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Define o telefone do cliente.
     *
     * @param telefone Novo telefone do cliente.
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Retorna o endereço do cliente.
     *
     * @return Endereço do cliente.
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * Define o endereço do cliente.
     *
     * @param endereco Novo endereço do cliente.
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * Retorna o carrinho de compras do cliente.
     *
     * @return Carrinho associado ao cliente.
     */
    public Carrinho getCarrinho() {
        return carrinho;
    }

    /**
     * Define o carrinho de compras do cliente.
     *
     * @param carrinho Novo carrinho de compras.
     */
    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    /**
     * Realiza o cadastro do cliente no sistema.
     */
    public void cadastrar() {
        System.out.println("Cliente cadastrado.");
    }

    /**
     * Atualiza os dados do cliente no sistema.
     */
    public void atualizar() {
        System.out.println("Cliente atualizado.");
    }
}
