package trabso2;

public class TLB {

    private final int tamanho = 2;
    private int cont = 0;

    public void BuscaTLB(int _p) {
        for (int i = 0; i < tamanho; i++) {
            if (MMU.vetorTLB.get(i).getP() == _p) {
                ++MMU.TLBHIT;
                //colocando o elemento no topo da pilha (LRU)
                MMU.vetorTLB.push(MMU.vetorTLB.remove(i));
                break;
            }
            if (i == (tamanho - 1)) {
                ++MMU.TLBMISS;
                //Buscar na tabela de página
                MMU.TP.BuscaTP(_p);
            }
        }
    }

    public void substitui(int p, int f) {
        EntradaTLB entrada = new EntradaTLB();
        entrada.setF(f);
        entrada.setP(p);
        if (cont < tamanho) {
            MMU.vetorTLB.add(entrada);
            ++cont;
        } else {//substituição LRU
            MMU.vetorTLB.remove(tamanho);
            MMU.vetorTLB.push(entrada);
        }
    }
}
