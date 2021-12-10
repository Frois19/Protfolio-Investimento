package com.company;

import java.util.ArrayList;

public class Ativo {

    private String nome;
    private double precoFinal;
    private double precoInicial;
    private double dividendoTotal;
    private int qtdeRegistros;
    private double retornoEfetivo;
    private double retornoEsperado;
    private double desvioPadraoPreco;
    private double riscoNormalizado;
    private double riscoRetorno;
    private ArrayList<RegistroAtivo> registros = new ArrayList();

    public void addRegistros(RegistroAtivo registro){
        registros.add(registro);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrecoFinal() {
        return precoFinal;
    }

    public void setPrecoFinal(double precoFinal) {
        this.precoFinal = precoFinal;
    }

    public double getPrecoInicial() {
        return precoInicial;
    }

    public void setPrecoInicial(double precoInicial) {
        this.precoInicial = precoInicial;
    }

    public double getDividendoTotal() {
        return dividendoTotal;
    }

    public void setDividendoTotal(double dividendoTotal) {
        this.dividendoTotal = dividendoTotal;
    }

    public int getQtdeRegistros() {
        return qtdeRegistros;
    }

    public void setQtdeRegistros(int qtdeRegistros) {
        this.qtdeRegistros = qtdeRegistros;
    }

    public double getRetornoEfetivo() {
        return retornoEfetivo;
    }

    public void setRetornoEfetivo(double retornoEfetivo) {
        this.retornoEfetivo = retornoEfetivo;
    }

    public double getRetornoEsperado() {
        return retornoEsperado;
    }

    public void setRetornoEsperado(double retornoEsperado) {
        this.retornoEsperado = retornoEsperado;
    }

    public double getDesvioPadraoPreco() {
        return desvioPadraoPreco;
    }

    public void setDesvioPadraoPreco(double desvioPadraoPreco) {
        this.desvioPadraoPreco = desvioPadraoPreco;
    }

    public double getRiscoNormalizado() {
        return riscoNormalizado;
    }

    public void setRiscoNormalizado(double riscoNormalizado) {
        this.riscoNormalizado = riscoNormalizado;
    }

    public double getRiscoRetorno() {
        return riscoRetorno;
    }

    public void setRiscoRetorno(double riscoRetorno) {
        this.riscoRetorno = riscoRetorno;
    }
}
