package LRU;

import java.io.*;
import java.util.Scanner;

//TLB tamanho 2
public class LRU {

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
            int cont = 0;
            //while (in.ready()) {
            for (int k = 0; k < 1000; k++) {
                ++cont;
                String linha = in.readLine();//Lê uma linha no arquivo
                System.out.println("\n\n" + cont);
                System.out.println("F = " + mmu.traduzirlinha(linha));
                //System.out.println(linha);
                /*System.out.println("TLB HIT: " + MMU.TLBHIT);
                 System.out.println("TLB MISS: " + MMU.TLBMISS);
                 System.out.println("Falha de página: " + MMU.falhaPag);
                 System.out.println("Leitura: " + MMU.Leituras);
                 System.out.println("Escrita: " + MMU.Escritas);*/

                System.out.println("--------TLB-------");
                for (int i = 0; i < TLB.cont; i++) {
                    System.out.println("P = " + MMU.vetorTLB.get(i).getP() + " F = " + MMU.vetorTLB.get(i).getF());
                }

                System.out.println("------LRU TLB-------");
                for (int i = 0; i < TLB.cont; i++) {
                    System.out.println(MMU.LRUTLB.get(i));
                }

                System.out.println("\n-----------Memória--------------");
                for (int i = 0; i <= Memoria.i; i++) {
                    System.out.println(i + " - " + MMU.Mem.get(i));
                }

                System.out.println("\n---------LRU Memória----------");
                for (int i = 0; i <= Memoria.i; i++) {
                    System.out.println(MMU.LRUMem.get(i));
                }

                //System.out.println("---------------");
                //System.in.read();
            }

        } else {//arquivo não encontrado
            System.out.println("Arquivo não encontrado");

        }
    }

}
