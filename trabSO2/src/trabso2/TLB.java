package trabso2;

import java.util.ArrayList;


public class TLB {

    private final int tamanho = 2;
    public int TLBHIT=0;
    public int TLBMISS =0;
    //EntradaTLB vetorTLB[] = new EntradaTLB[tamanho];
    ArrayList<EntradaTLB> vetorTLB = new ArrayList<>();
    
    public boolean BuscaTLB(int _p){
        TabelaPag TP = new TabelaPag();
        for (int i = 0; i < tamanho; i++) {
            if (vetorTLB.get(i).getP() == _p) {
                ++TLBHIT;
                return true;
            }
            if (i == (tamanho - 1)) {
                ++TLBMISS;
                //Buscar na tabela de página
                TP.BuscaTP(_p);
            }
        }
        return false;
    }
}
