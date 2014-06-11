package trabso2;

import java.io.*;
import java.util.Scanner;

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
            
            while(in.ready()){
                String linha = in.readLine();//Lê uma linha no arquivo
                System.out.println(linha);
                
                
            }

        } else {//arquivo não encontrado
            System.out.println("Arquivo não encontrado");

        }
    }

}
