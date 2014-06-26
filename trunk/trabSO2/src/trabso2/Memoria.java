package trabso2;

public class Memoria {

    int i = 0;

    public int AcessaMem(int _p) {
        //Substituir páginas
        //Atualizar TLB e tabela de páginas

        if (MMU.Mem.size() < 64) {
            MMU.Mem.add(i, _p);
            MMU.LRUMem.add(i);
            MMU.TabPag.get(i).setValido(true);//setando o bit como válido
            MMU.TabPag.get(i).setF(i);
            MMU.tlb.substitui(_p, i);
            ++i;
            return (i - 1);
        } else {
            MMU.LRUMem.push(MMU.LRUMem.remove(0));//Considerando que o 0 é a 
            MMU.Mem.set(MMU.LRUMem.get(63), _p);
            for (int k = 0; k < 1048576; k++) {
                if (MMU.TabPag.get(k).isValido() && (MMU.TabPag.get(k).getF() == MMU.LRUMem.get(63))) {
                    MMU.TabPag.get(k).setValido(false);
                    MMU.TabPag.get(k).setF(-1);
                    MMU.TabPag.get(_p).setValido(true);
                    MMU.TabPag.get(_p).setF(MMU.LRUMem.get(63));
                    MMU.tlb.substitui(_p, k);
                    return (MMU.LRUMem.get(63));
                }
            }
        }
        return -1;
    }
}
