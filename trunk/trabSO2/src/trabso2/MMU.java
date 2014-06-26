package trabso2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class MMU {

    private int p;
    private int d;

    static ArrayList<EntradaTP> TabPag = new ArrayList<>();
    static Stack<EntradaTLB> vetorTLB = new Stack<>();
    static ArrayList<Integer> Mem = new ArrayList<>();
    static Stack<Integer> LRUMem = new Stack<>();
    static Stack<Integer> LRUTLB = new Stack<>();

    static int falhaPag = 0;
    static int TLBHIT = 0;
    static int TLBMISS = 0;
    static int Leituras = 0;
    static int Escritas = 0;

    static Memoria mem = new Memoria();
    static TLB tlb = new TLB();
    static TabelaPag TP = new TabelaPag();
    
    public MMU(){
        for (int i=0; i<1048576; i++){
            TabPag.add(new EntradaTP());
        }
    }

    public int traduzirlinha(String linha) {
        String P = linha.substring(0, 5); //Número da página
        String D = linha.substring(5, 8); //Deslocamento
        String RW = linha.substring(9, 10); //Leitura ou escrita

        if (RW.equals("W")) {
            ++Escritas;
        } else {
            if (RW.equals("R")) {
                ++Leituras;
            }
        }

///////////////////convertendo hexadecimal para decimal/////////////////////////
        int valor = 0;
        int posicaoCaractere;
        char[] hexa = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

        // soma ao valor final o dígito binário da posição * 16 elevado ao contador da posição (começa em 0)
        for (int i = P.length(); i > 0; i--) {
            posicaoCaractere = Arrays.binarySearch(hexa, P.charAt(i - 1));
            valor += posicaoCaractere * Math.pow(16, (P.length() - i));
        }
        p = valor;
        //System.out.println("P = " + p);
        valor = 0;

        for (int i = D.length(); i > 0; i--) {
            posicaoCaractere = Arrays.binarySearch(hexa, D.charAt(i - 1));
            valor += posicaoCaractere * Math.pow(16, (D.length() - i));
        }
        d = valor;
        ////////////////////////////////////////////////////////////////////////

        return (tlb.BuscaTLB(p));//Busca na TLB
    }

}
