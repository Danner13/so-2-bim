package SegundaChance;

import java.io.*;
import java.util.Scanner;

//TLB tamanho 2
public class SegundaChance {

    static String caminho = System.getProperty("user.dir") + "\\src\\traces";

    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        System.out.print("Informe o nome do Arquivo: ");
        String entrada = s.nextLine();//Entrar com o nome do arquivo
        System.out.println(entrada);

        File arquivo = new File(caminho + "\\" + entrada);
        FileReader filein;
        if (arquivo.isFile()) {//achou o arquivo
            filein = new FileReader(arquivo);
            BufferedReader in = new BufferedReader(filein);

            MMU mmu = new MMU();//Chamando o construtor da MMU enviando linha como parâmetro
            while(in.ready()){
            //for (int i = 0; i < 26; i++) {
                String linha = in.readLine();//Lê uma linha no arquivo
                System.out.println("F = " + mmu.traduzirlinha(linha));
            }
                //System.out.println(linha);
                System.out.println("TLB HIT: " + MMU.TLBHIT);
                System.out.println("TLB MISS: " + MMU.TLBMISS);
                System.out.println("Falha de página: " + MMU.falhaPag);
                System.out.println("Leitura: " + MMU.Leituras);
                System.out.println("Escrita: " + MMU.Escritas);
                //System.out.println("---------------");

        } else {//arquivo não encontrado
            System.out.println("Arquivo não encontrado");

        }
    }

}
