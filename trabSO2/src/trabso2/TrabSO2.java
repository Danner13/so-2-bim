package trabso2;

import java.io.*;
import java.util.Scanner;

//TLB tamanho 2

public class TrabSO2 {

    static String caminho = System.getProperty("user.dir") + "\\src\\traces";

    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        String entrada = s.nextLine();//Entrar com o nome do arquivo
        System.out.println(entrada);

        File arquivo = new File(caminho + "\\" + entrada);
        FileReader filein;
        if (arquivo.isFile()) {//achou o arquivo
            filein = new FileReader(arquivo);
            BufferedReader in = new BufferedReader(filein);
            
            int cont=0;
            
            //while(in.ready()){
            for (int i=0; i<26; i++){
                String linha = in.readLine();//Lê uma linha no arquivo
                //System.out.println(linha);
                String P = linha.substring(0,5); //Número da página
                String D = linha.substring(5,8); //Deslocamento
                String RW = linha.substring(9,10); //Leitura ou escrita
                if(RW.equals("R")){//leitura
                    System.out.println("Leitura");
                }else{  
                    if(RW.equals("W")){
                        System.out.println("Escrita");
                    }
                }
            }

        } else {//arquivo não encontrado
            System.out.println("Arquivo não encontrado");

        }
    }

}
