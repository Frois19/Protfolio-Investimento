package com.company;

import java.util.Date;

public class RegistroAtivo {
    //Informações do registro do ativo
    private String nome; //origem - leitura do arquivo
    private Date data; //origem - leitura do arquivo
    private double preco; //origem - leitura do arquivo
    private double valor; //origem - leitura do arquivo
    private double dividendo; //origem - leitura do arquivo
    private double variancia; //origem - calculada posteriormente
    //Construtor para inicializar registro apos leitura do arquivo
    public RegistroAtivo(String nome, Date data, double preco, double valor, double dividendo) {
        this.nome = nome;
        this.data = data;
        this.preco = preco;
        this.valor = valor;
        this.dividendo = dividendo;
    }
    //Função para retornar o nome do ativo registrado
    public String getNome() {
        return nome;
    }
    //Função para cadastrar o nome do ativo registrado
    public void setNome(String nome) {
        this.nome = nome;
    }
    //Função para retornar a data do ativo registrado
    public Date getData() {
        return data;
    }
    //Função para cadastrar a data do ativo registrado
    public void setData(Date data) {
        this.data = data;
    }
    //Função para retornar o preco do ativo registrado
    public double getPreco() {
        return preco;
    }
    //Função para Cadastrar o preco do ativo registrado
    public void setPreco(double preco) {
        this.preco = preco;
    }
    //Função para retornar o valor do ativo registrado
    public double getValor() {
        return valor;
    }
    //Função para cadastrar o valor do ativo registrado
    public void setValor(double valor) {
        this.valor = valor;
    }
    //Função para retornar o dividendo do ativo registrado
    public double getDividendo() {
        return dividendo;
    }
    //Função para cadastrar o dividendo do ativo registrado
    public void setDividendo(double dividendo) {
        this.dividendo = dividendo;
    }
    //Função para retornar a variancia do ativo registrado
    public double getVariancia() {
        return variancia;
    }
    //Função para cadastrar a variancia do ativo registrado
    public void setVariancia(double variancia) {
        this.variancia = variancia;
    }
}
