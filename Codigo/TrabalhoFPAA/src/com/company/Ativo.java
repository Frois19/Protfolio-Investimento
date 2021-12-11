package com.company;

import java.util.ArrayList;

public class Ativo {

    private String nome;
    private double precoVenda;
    private double precoCompra;
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


    public void totalDividendo(){
        double Dt = 0.0;
        for(RegistroAtivo s: registros){
            Dt = Dt+s.getDividendo();
        }
        setDividendoTotal(Dt);
    }

    public void encontrarPrecoVenda(){
        setPrecoCompra(registros.get(registros.size()-1).getPreco());
    }

    public void encontrarPrecoCompra(){
        setPrecoCompra(registros.get(0).getPreco());
    }

    public void calcularRetornoEfetivo(String nomeAtivo){
        double dt = getDividendoTotal();
        double pv = getPrecoVenda();
        double pc = getPrecoCompra();

        setRetornoEfetivo((pv+dt-pc)/pc);
    }


    public void retornoEsperado(){
        double precototal=0.0;
        int cont=0;

        for(RegistroAtivo s: registros) {
                precototal = precototal + s.getPreco();
                cont=cont+1;
        }
        setRetornoEfetivo(precototal/cont);
    }

    public void varianciaAbsolutaPreco(){
        double precoAntigo=registros.get(0).getPreco();
        double precoAtual;

        for(RegistroAtivo s: registros) {
            precoAtual=s.getPreco();
            s.setVariancia(Math.abs(precoAtual-precoAntigo));
            precoAntigo=s.getPreco();
        }
    }

    public void desvioPadraopreco(){
        double cont = 0;
        double varianciatotal = 0;

        for(RegistroAtivo s: registros) {
                varianciatotal = varianciatotal + s.getVariancia();
                cont=cont+1;
        }
        setDesvioPadraoPreco(varianciatotal/cont);
    }

    public void riscoNormalizado(){
        setRiscoNormalizado(getDesvioPadraoPreco()/getRetornoEsperado());
    }

    public void riscoRetorno(){
        setRiscoRetorno(getRiscoNormalizado()/getRetornoEsperado());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(double precoCompra) {
        this.precoCompra = precoCompra;
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
