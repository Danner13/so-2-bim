package LRU;

public class Memoria {

    static int i = -1;
    int tam = 5;

    public int AcessaMem(int _p) {
        //Substituir páginas
        //Atualizar TLB e tabela de páginas
        if (MMU.Mem.size() < tam) {
            ++i;
            MMU.Mem.add(i, _p);
            MMU.LRUMem.add(i);
            MMU.TabPag.get(_p).setValido(true);//setando o bit como válido
            MMU.TabPag.get(_p).setF(i);
            MMU.tlb.substitui(_p, i);
            return (i);
        } else {
            MMU.LRUMem.push(MMU.LRUMem.remove(0));//Considerando que o 0 é a 
            MMU.Mem.set(MMU.LRUMem.get(tam-1), _p);
            for (int k = 0; k < 1048576; k++) {
                if (MMU.TabPag.get(k).isValido() && (MMU.TabPag.get(k).getF() == MMU.LRUMem.get(tam-1))) {
                    MMU.TabPag.get(k).setValido(false);
                    MMU.TabPag.get(k).setF(-1);
                    MMU.TabPag.get(_p).setValido(true);
                    MMU.TabPag.get(_p).setF(MMU.LRUMem.get(tam-1));
                    MMU.tlb.substitui(_p, MMU.LRUMem.get(tam-1));
                    return (MMU.LRUMem.get(tam-1));
                }
            }
        }
        return -1;
    }
}
