package SegundaChance;

public class TLB {

    private final int tamanho = 2;
    private int cont = 0;

    public int BuscaTLB(int _p) {
        for (int i = 0; i < tamanho; i++) {
            if ((i<cont) && (MMU.vetorTLB.get(i).getP() == _p)) {
                ++MMU.TLBHIT;
                //colocando o elemento no topo da pilha (LRU)
                MMU.LRUTLB.push(MMU.LRUTLB.remove(i));
                return (MMU.vetorTLB.get(i).getF());
            }
            if (i == (tamanho - 1) || tamanho > cont) {
                ++MMU.TLBMISS;
                //Buscar na tabela de página
                return(MMU.TP.BuscaTP(_p));
            }
        }
        return 0;//alterar o retorno
    }

    public void substitui(int p, int f) {
        EntradaTLB entrada = new EntradaTLB();
        entrada.setF(f);
        entrada.setP(p);
        if (cont < tamanho) {
            MMU.vetorTLB.add(entrada);
            MMU.LRUTLB.push(f);
            ++cont;
        } else {//substituição LRU
            for (int i = 0; i < tamanho; i++) {
                if (MMU.LRUTLB.get(0) == MMU.vetorTLB.get(i).getF()) {
                    MMU.vetorTLB.setElementAt(entrada, i);
                    MMU.LRUTLB.remove(0);//Assumindo que o stack implementa a base como 0
                    MMU.LRUTLB.push(entrada.getF());
                }
            }
        }
    }
}
