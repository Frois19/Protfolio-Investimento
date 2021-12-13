package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Ativo {
    //Campos do ativo
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
    private double peso;
    //Registros referentes a um ativo especifico
    public ArrayList<RegistroAtivo> registros = new ArrayList();
    //Construtor utilizado na classe portifolio para popular o array
    public Ativo(String nome) {
        this.nome = nome;
    }
    //Função para adicionar um novo registro no Array
    public void addRegistros(RegistroAtivo registro){
        registros.add(registro);
    }
    //Função para ordenar o array com base na data dos ativos
    public void sortRegistrosData(){
        Collections.sort(registros, new Comparator<RegistroAtivo>(){
            public int compare(RegistroAtivo o1, RegistroAtivo o2)
            {
                return o1.getData().compareTo(o2.getData());
            }
        });
    }
    //Função para mostrar dados calculados referentes a um ativo
    public void printarAtivo(int i){
        System.out.println("Ativo" + i + ":"+
                "\n\tNome: " + getNome() +
                "\n\tRisco Normalizado :" + getRiscoNormalizado() +
                "\n\tRisco Retorno: " + getRiscoRetorno() +
                "\n\tPeso: " + getPeso()
        );

    }
    //Função para listar os registros dentro do array do ativo
    public void printarRegistros(){
        int i = 1;
        for(RegistroAtivo r: registros){
            System.out.println("\tRegistro " + i + ":" +
                    "\n\t\tNome:" + r.getNome() +
                    "\n\t\tData:" + r.getData() +
                    "\n\t\tPreco:" + r.getPreco() +
                    "\n\t\tValor:" + r.getValor() +
                    "\n\t\tDividendo:" + r.getDividendo()
            );
            i++;
        }
    }
    //Função para calcular os parametros do ativo
    public void calcularParametros(){
        encontrarPrecoCompra();
        encontrarPrecoVenda();
        totalDividendo();
        calcularRetornoEfetivo();
        calcularRetornoEsperado();
        calcularVarianciaAbsolutaPreco();
        calcularDesvioPadraopreco();
        calcularRiscoNormalizado();
        calcularRiscoRetorno();
        }
    //Funções para calcular os parametros do ativo
    public void totalDividendo(){
        double Dt = 0.0;
        for(RegistroAtivo s: registros){
            Dt = Dt+s.getDividendo();
        }
        setDividendoTotal(Dt);
    }
    public void encontrarPrecoVenda(){
        setPrecoVenda(registros.get(registros.size()-1).getPreco());
    }
    public void encontrarPrecoCompra(){
        setPrecoCompra(registros.get(0).getPreco());
    }
    public void calcularRetornoEfetivo(){
        double dt = getDividendoTotal();
        double pv = getPrecoVenda();
        double pc = getPrecoCompra();
        setRetornoEfetivo((pv+dt-pc)/pc);
    }
    public void calcularRetornoEsperado(){
        double precototal=0.0;
        int cont=0;

        for(RegistroAtivo s: registros) {
                precototal = precototal + s.getPreco();
                cont=cont+1;
        }
        setRetornoEsperado(precototal/cont);
    }
    public void calcularVarianciaAbsolutaPreco(){
        double precoAntigo = registros.get(0).getPreco();
        double precoAtual;

        for(RegistroAtivo s: registros) {
            precoAtual = s.getPreco();
            s.setVariancia(precoAtual-precoAntigo);
            precoAntigo = s.getPreco();
        }
    }
    public void calcularDesvioPadraopreco(){

        double varianciatotal = 0;
        double mediaVariancia;
        double aux = 0;
        int tamanho = registros.size()-1;

        for(RegistroAtivo s: registros) {
                varianciatotal = varianciatotal + Math.abs(s.getVariancia());

        }

        mediaVariancia = varianciatotal/tamanho;

        for(RegistroAtivo s: registros) {
            aux = aux + Math.pow(s.getVariancia() - mediaVariancia,2);
        }
        setDesvioPadraoPreco(Math.sqrt(aux/tamanho));
    }
    public void calcularRiscoNormalizado(){
        setRiscoNormalizado(getDesvioPadraoPreco()/getRetornoEsperado());
    }
    public void calcularRiscoRetorno(){
        setRiscoRetorno(getRiscoNormalizado()/getRetornoEfetivo());
    }
    //Setters e Getters
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
    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
}

