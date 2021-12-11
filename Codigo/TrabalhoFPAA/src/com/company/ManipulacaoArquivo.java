package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ManipulacaoArquivo {

    public void lerArquivo(String nomeArquivo) throws IOException, ParseException {
        //Criando portifolio
        Portifolio portifolio = new Portifolio();
        //Variavel para controlar o campo que esta sendo lido na linha do arquivo
        int contador = 0;
        //Strings para armazenas os campos lidos no arquivo
        String nomeArq = "";
        String dataArq = "";
        String precoArq = "";
        String valorArq = "";
        String dividendoArq = "";
        //Variaveis para converção das strings lidas nos arquivos
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
                //Leitura caracter por caracter da linha atual
                for (int i=0; i<linha.length(); i++){
                    char c = linha.charAt(i); //recebendo caracter atual
                    if (c == ','){ //caractere que separa os campos em uma linha
                        //Incrementando contador para a leitura do proximo campo
                        contador++;
                    }
                    else if (c == '\n'){ //caractere que sinaliza o final de uma linha
                        //Resetando contador para ler a proxima linha
                        contador = 0;
                        //Convertendo string recebidas para os formatos corretos
                        nome = nomeArq;
                        data = formato.parse(dataArq);
                        preco = Double.parseDouble(precoArq);
                        valor = Double.parseDouble(valorArq);
                        dividendo = Double.parseDouble(dividendoArq);
                        //Criando registro com as variaveis coletadas
                        RegistroAtivo registro = new RegistroAtivo(nome, data, preco, valor, dividendo);
                        //Adicionando regitro ao portifolio
                        portifolio.addRegistros(registro);
                        //Zerando variaveis para ler a proxima linha
                        nomeArq = "";
                        dataArq = "";
                        precoArq = "";
                        valorArq = "";
                        dividendoArq = "";
                    } else {
                        switch (contador){
                            case 0: //Concatenando caracteres referentes ao nome
                                nomeArq = nomeArq.concat(Character.toString(c));
                                break;
                            case 1: //Concatenando caracteres referentes a data
                                dataArq = dataArq.concat(Character.toString(c));
                                break;
                            case 2: //Concatenando caracteres referentes ao preco
                                precoArq = precoArq.concat(Character.toString(c));
                                break;
                            case 3: //Concatenando caracteres referentes ao valor
                                valorArq = valorArq.concat(Character.toString(c));
                                break;
                            case 4: //Concatenando caracteres referentes ao dividendo
                                dividendoArq = dividendoArq.concat(Character.toString(c));
                                break;
                        }
                    }
                }
            } else
                break;
            linha = buffRead.readLine(); //ler a proxima linha
        }
        buffRead.close(); //fechando arquivo
    }
}
