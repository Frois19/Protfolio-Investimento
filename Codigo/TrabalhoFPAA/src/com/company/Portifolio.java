package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Portifolio {
    //Array de ativos
    public ArrayList<Ativo> ativos = new ArrayList();
    //Array com todos os registros registros
    public ArrayList<RegistroAtivo> registros = new ArrayList();
    //Função para adicionar um novo registro no Array
    public void addRegistros(RegistroAtivo registro){
        registros.add(registro);
    }
    //Função para ordenar o array com base no nome dos ativos
    public void sortRegistrosName(){
        Collections.sort(registros, new Comparator<RegistroAtivo>(){
            public int compare(RegistroAtivo o1, RegistroAtivo o2)
            {
                return o1.getNome().compareTo(o2.getNome());
            }
        });
    }
    //Função para adicionar ativos no Array
    public void addAtivos(Ativo ativo){
        ativos.add(ativo);
    }
    //Função para printar o Array de registros - utilizada para alguns testas na construção do algoritmo
    public void printarRegistros(){
        int i = 1;
        for(RegistroAtivo r: registros){
            System.out.println("Registro " + i + ":" +
                    "\n\tNome:" + r.getNome() +
                    "\n\tData:" + r.getData() +
                    "\n\tPreco:" + r.getPreco() +
                    "\n\tValor:" + r.getValor() +
                    "\n\tDividendo:" + r.getDividendo()
            );
            i++;
        }
    }
    //Função para printar o Array de ativos - utilizada para alguns testas na construção do algoritmo
    public void printarAtivos(){
        int i = 1;
        for(Ativo a: ativos){
            System.out.println("Ativo" + i + ":"+
                    "\n\tNome: " + a.getNome() +
                    "\n\tPreco Venda: " + a.getPrecoVenda() +
                    "\n\tPreco Compra: " + a.getPrecoCompra() +
                    "\n\tDividendo Total: " + a.getDividendoTotal() +
                    "\n\tRetorno Efetivo: " + a.getRetornoEfetivo() +
                    "\n\tRetorno Esperado: " + a.getRetornoEsperado() +
                    "\n\tDesvio Padrao Preco: " + a.getDesvioPadraoPreco() +
                    "\n\tRisco Normalizado :" + a.getRiscoNormalizado() +
                    "\n\tRisco Retorno: " + a.getRiscoRetorno() +
                    "\n\tPeso: " + a.getPeso() +
                    "\n\tQuantidade de registros: " + a.getQtdeRegistros()
            );
            i++;
        }
    }
    //Função para popular o array de registros de um determinado ativo
    public void popularRegistrosAtivos(){
        int i = 1;
        int contador = 0;
        String nomeAnterior = "";
        ArrayList<Integer> qtdeRegistrosPorAtivo = new ArrayList();
        ArrayList<String> nomeAtivos = new ArrayList();
        for(RegistroAtivo r: registros){
            if (i == 1){
                nomeAnterior = r.getNome();
            } else {
                if (nomeAnterior.equals(r.getNome())){
                    contador++;
                } else{
                    qtdeRegistrosPorAtivo.add(contador+1);
                    nomeAtivos.add(nomeAnterior);
                    contador = 0;
                }
            }
            nomeAnterior = r.getNome();
            i++;
        }

        for (i = 0; i < nomeAtivos.size(); i++){
            Ativo ativo = new Ativo(nomeAtivos.get(i));
            ativos.add(ativo);
        }

        i = 0;
        int j = 0;
        for(RegistroAtivo r: registros){
            ativos.get(j).addRegistros(r);
            if( i == qtdeRegistrosPorAtivo.get(j)-1){
                ativos.get(j).sortRegistrosData();
                j++;
                i = -1;
                if (j > qtdeRegistrosPorAtivo.size()-1){
                    break;
                }
            }
            i++;
        }
    }

    public void algoritmoGuloso() {
        double riscoRetornoTotal=0.0;
        for(Ativo s: ativos){
            riscoRetornoTotal=riscoRetornoTotal+s.getRiscoRetorno();
        }
        for(Ativo s: ativos){
            s.setPeso(1-(s.getRiscoRetorno()/riscoRetornoTotal));
        }
    }

    public void algoritmoAleatorio(){
        int quantidodeAtivos = ativos.size();

        int numaleatorio=0;
        ArrayList<Integer> numerosAleatorio = new ArrayList();
        for (int i=0;i<=quantidodeAtivos;i++){
            numerosAleatorio.add(new Random().nextInt(100) + 1);
            numaleatorio+= numerosAleatorio.get(i);
        }
        for(int i=0;i<=quantidodeAtivos;i++){
            ativos.get(i).setPeso(numerosAleatorio.get(i)/numaleatorio);
        }

    }

    public void algoritmoForcaBruta(){
        double limitePeso=0.0;
        double maiorRiscoRetorno = 0.0;
        double menorRiscoRetorno = ativos.get(0).getRiscoRetorno();

        for(Ativo s: ativos){
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

    public void calcularDadosdosAtivos(){
        for(Ativo s: ativos){
            s.calcularParametros();
        }
    }



}