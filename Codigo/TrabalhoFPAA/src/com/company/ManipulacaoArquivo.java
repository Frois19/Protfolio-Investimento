package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ManipulacaoArquivo {

    public static void lerArquivo(String nomeArquivo) throws IOException, ParseException {
        int contador = 0;

        String nomeArq = "";
        String dataArq = "";
        String precoArq = "";
        String valorArq = "";
        String dividendoArq = "";

        String nome;
        Date data;
        double preco;
        double valor;
        double dividendo;

        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

        BufferedReader buffRead = new BufferedReader(new FileReader(nomeArquivo));
        String linha = "";

        while (true) {
            if (linha != null) {
                for (int i=0; i<linha.length(); i++){
                    char c = linha.charAt(i);
                    if (c == ','){
                        contador++;
                    }
                    else if (c == '\n'){
                        contador = 0;

                        nome = nomeArq;
                        data = formato.parse(dataArq);
                        preco = Double.parseDouble(precoArq);
                        valor = Double.parseDouble(valorArq);
                        dividendo = Double.parseDouble(dividendoArq);

                        nomeArq = "";
                        dataArq = "";
                        precoArq = "";
                        valorArq = "";
                        dividendoArq = "";
                    } else {
                        switch (contador){
                            case 0: //nome
                                nomeArq = nomeArq.concat(Character.toString(c));
                                break;
                            case 1: //data
                                dataArq = dataArq.concat(Character.toString(c));
                                break;
                            case 2: //preco
                                precoArq = precoArq.concat(Character.toString(c));
                                break;
                            case 3: //valor
                                valorArq = valorArq.concat(Character.toString(c));
                                break;
                            case 4: // dividendo
                                dividendoArq = dividendoArq.concat(Character.toString(c));
                                break;
                        }
                    }
                }
            } else
                break;
            linha = buffRead.readLine();
        }
        buffRead.close();
    }
}
