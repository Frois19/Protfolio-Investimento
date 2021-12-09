package com.company;

import java.util.Scanner;

public class InterfaceUsuario {

    Scanner ler = new Scanner(System.in);

    public void homePage(){
        int opc = 0;
        System.out.println("=======================================================");
        System.out.println("       CONSTRUICAO DE PORTFOLIO DE INVESTIMENTO");
        System.out.println("\n DESENVOLVIDO POR: Felipe Nogueira e Joao Victor Frois");
        System.out.println("=======================================================");
        do{
            System.out.println("=======================================================");
            System.out.println("Selecione atraves do numero a sua acao:");
            System.out.println("\t[1] - Iniciar programa;");
            System.out.println("\t[2] - Encerrar programa;");
            System.out.println("Digite a opcao escolhida:");
            opc = ler.nextInt();
            System.out.println("=======================================================");
        }while(opc != 1 && opc != 2);
        switch (opc){
            case 1:
                selecaoArquivoPage();
                break;
            case 2:
                System.out.println("=======================================================");
                System.out.println("                  Encerrando execucao!");
                System.out.println("=======================================================");
                System.exit(0);
                break;
        }
        homePage();
    }

    public void selecaoArquivoPage(){
        int opc = 0;
        String nomeArquivo;
        System.out.println("=======================================================");
        System.out.println("Voce ira informar qual arquivo contem a listagem dos" +
                           "\nativos a serem analisados para montagem do portfolio.");
        System.out.println("\tObs1: O arquivo deve ser no formato .csv;");
        System.out.println("\tObs2: Nao digitar a extensao do arquivo;");
        System.out.println("\tObs3: Arquivo deve estar na pasta raiz do projeto;");
        System.out.println("Digite o nome do arquivo selecionado:");
        nomeArquivo = ler.next();
        System.out.println("=======================================================");

        nomeArquivo = nomeArquivo.concat(".csv");

        do{
            System.out.println("=======================================================");
            System.out.println("O arquivo selecionado é: " + nomeArquivo);
            System.out.println("Selecione sua proxima acao:");
            System.out.println("\t[1] - Realizar montagem do portfolio;");
            System.out.println("\t[2] - Trocar arquivo selecionado;");
            System.out.println("Digite a opcao escolhida:");
            opc = ler.nextInt();
            System.out.println("=======================================================");
        }while(opc != 1 && opc != 2);
        switch (opc){
            case 1:
                analisePage(nomeArquivo);
                break;
            case 2:
                System.out.println("=======================================================");
                System.out.println("       Voce esta retorando a selecao de arquivos.");
                System.out.println("=======================================================");
                selecaoArquivoPage();
                break;
        }
    }

    public void analisePage(String nomeArquivo){
        //função de ler arquivo

    }
}
