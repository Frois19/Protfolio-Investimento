package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ManipulacaoArquivo {

    //Função para leitura do arquivo indicado pelo parametro
    public void lerArquivo(String nomeArquivo) throws IOException, ParseException {
        //Criando portfolio para armazenar os registros do arquivo
        Portifolio portfolio = new Portifolio();
        //Variaveis para receber valores campos do arquivo
        String nome;
        Date data;
        double preco;
        double valor;
        double dividendo;
        //Definindo formato de data utilizado
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        //Sinalizando arquivo que sera lido
        BufferedReader buffRead = new BufferedReader(new FileReader(nomeArquivo));
        //Iniciando leitura do arquivo e abrindo o arquivo para esta operação
        String linha = buffRead.readLine();
        linha = buffRead.readLine(); //pulando primeira linha (cabeçalho do arquivo)
        while (true) {
            if (linha != null) {
                //Lendo campos da linha deparados por ','
                String[] parts = linha.split(",");
                //Convertendo string recebidas para os formatos corretos
                nome = parts[0];
                data = formato.parse(parts[1]);
                preco = Double.parseDouble(parts[2]);
                valor = Double.parseDouble(parts[3]);
                dividendo = Double.parseDouble(parts[4]);
                //Criando registro de ativo e adicionando no portifolio
                RegistroAtivo registro = new RegistroAtivo(nome, data, preco, valor, dividendo);
                portfolio.addRegistros(registro);
            } else
                break;
            linha = buffRead.readLine(); //ler a proxima linha
        }
        buffRead.close(); //fechando arquivo
        portfolio.sortRegistrosName();
        portfolio.popularRegistrosAtivos();
    }
}
