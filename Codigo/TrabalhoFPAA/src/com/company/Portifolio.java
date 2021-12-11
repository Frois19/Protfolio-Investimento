package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Portifolio {

    private ArrayList<Ativo> Ativos = new ArrayList();

    private ArrayList<RegistroAtivo> registros = new ArrayList();

    public void addRegistros(RegistroAtivo registro){
        registros.add(registro);
    }

    public void algoritmoGuloso() {
        double riscoRetornoTotal=0.0;
        for(Ativo s: Ativos){
            riscoRetornoTotal=riscoRetornoTotal+s.getRiscoRetorno();
        }
        for(Ativo s: Ativos){
            s.setPeso(1-(s.getRiscoRetorno()/riscoRetornoTotal));
        }
    }

    public void algoritmoAleatorio(){
        int quantidodeAtivos = Ativos.size();

        int numaleatorio=0;
        ArrayList<Integer> numerosAleatorio = new ArrayList();
        for (int i=0;i<=quantidodeAtivos;i++){
            numerosAleatorio.add(new Random().nextInt(100) + 1);
            numaleatorio+= numerosAleatorio.get(i);
        }
        for(int i=0;i<=quantidodeAtivos;i++){
            Ativos.get(i).setPeso(numerosAleatorio.get(i)/numaleatorio);
        }

    }

    public void algoritmoForcaBruta(){
        double limitePeso=0.0;
        double maiorRiscoRetorno = 0.0;
        double menorRiscoRetorno = Ativos.get(0).getRiscoRetorno();

        for(Ativo s: Ativos){
            if(s.getRiscoRetorno()>maiorRiscoRetorno){
                maiorRiscoRetorno = s.getRiscoRetorno();
            }
            if(s.getRiscoRetorno()<menorRiscoRetorno){
                menorRiscoRetorno = s.getRiscoRetorno();
            }
        }
        while (menorRiscoRetorno*limitePeso<maiorRiscoRetorno*0.01){
            limitePeso+=0.01;
        }





    }




}




//    public double totalDividendo(String nomeAtivo){
//    double Dt = 0.0;
//    for(RegistroAtivo s: Ativos){
//        if (nomeAtivo== s.getNome()){
//            Dt = Dt+s.getDividendo();
//        }
//    }
//    return Dt;
//}
//
//    public double encontrarVenda(String nomeAtivo){
//        double precoVenda = 0.0;
//        for(RegistroAtivo s: Ativos){
//            if (nomeAtivo== s.getNome()){
//                precoVenda = s.getValor(); "duvida se e preco"
//            }
//        }
//        return precoVenda;
//    }
//
//    public double encontrarCompra(String nomeAtivo){
//        double precoCompra = 0.0;
//        int contador = 0;
//        for(RegistroAtivo s: Ativos){
//            if (nomeAtivo== s.getNome()){
//                if (contador ==0){
//                    precoCompra=s.getPreco();
//                    contador++;
//                }
//            }
//        }
//        return precoCompra;
//    }
//
//    public double calcularRetornoEfetivo(String nomeAtivo){
//        double pv;
//        double pc;
//        double dt;
//        double re;
//
//        pv = encontrarVenda(nomeAtivo);
//        dt = totalDividendo(nomeAtivo);
//        pc = encontrarCompra(nomeAtivo);
//
//        re = (pv+dt-pc)/pc;
//        return re;
//    }
//
//
//    public double retornoEsperado(String nomeAtivo){ "média preco"
//    double precototal=0.0;
//    int cont=0;
//    double retornoesperado;
//    for(RegistroAtivo s: Ativos) {
//        if (nomeAtivo == s.getNome()) {
//            precototal = precototal + s.getPreco();
//            cont=cont+1;
//        }
//    }
//    retornoesperado = precototal/cont;
//    return retornoesperado;
//    }
//
//    public void varianciaAbsolutaPreco(String nomeAtivo){
//        double precoAntigo = 0;
//        double precoAtual = 0;
//        for(RegistroAtivo s: Ativos) {
//            if (nomeAtivo == s.getNome()) {
//               precoAtual=s.getPreco();
//                s.setVariancia(Math.abs(precoAtual-precoAntigo));
//                precoAntigo=s.getPreco();
//
//            }
//        }
//    }
//
//    public double desvioPadraopreco(String nomeAtivo){
//        double dp = 0;
//        double cont = 0;
//        double varianciatotal = 0;
//        for(RegistroAtivo s: Ativos) {
//            if (nomeAtivo == s.getNome()) {
//                varianciatotal = varianciatotal + s.getVariancia();
//                cont=cont+1;
//            }
//        }
//        dp = varianciatotal/cont;
//        return dp;
//    }
//
//    public double riscoNormalizado(String nomeAtivo){
//        double retornoEsperado = retornoEsperado(nomeAtivo);
//        double desvioPadrao = desvioPadraopreco(nomeAtivo);
//        double riscoNormalizado;
//        riscoNormalizado = desvioPadrao/mediaPreco;
//        return riscoNormalizado; "porcentagem"
//    }
//
//    public double riscoRetorno(String nomeAtivo ){
//
//        double risconormalizado = riscoNormalizado(nomeAtivo);
//        double retornoEsperado = retornoEsperado(nomeAtivo);
//
//        double riscoretorno = risconormalizado/retornoEsperado;
//
//        return riscoretorno;
  }