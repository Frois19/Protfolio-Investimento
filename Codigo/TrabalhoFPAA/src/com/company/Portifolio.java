package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Portifolio {

    private ArrayList<Ativo> Ativos = new ArrayList();



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




