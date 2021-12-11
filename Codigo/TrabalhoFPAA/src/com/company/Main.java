package com.company;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws ParseException, IOException {
	// write your code here
//        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();
//        interfaceUsuario.homePage();
        ManipulacaoArquivo arq = new ManipulacaoArquivo();
        String arqName = "C:\\Users\\JoaoFrois\\Desktop\\SEMESTRE 04\\Protfolio-Investimento\\Codigo\\TrabalhoFPAA\\src\\com\\company\\data.csv";
        arq.lerArquivo(arqName);

    }
}
