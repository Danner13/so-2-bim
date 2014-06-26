package LRU;

public class TabelaPag {

    public int BuscaTP(int p) {
        if(MMU.TabPag.get(p).isValido()){
            //atualizar na TLB
            MMU.tlb.substitui(p, MMU.TabPag.get(p).getF());
            
            for(int i=0; i<64; i++){
                if (MMU.LRUMem.get(i) == MMU.TabPag.get(p).getF()){
                    MMU.LRUMem.push(MMU.LRUMem.remove(i));
                }
            }
                    
            return (MMU.TabPag.get(p).getF());
        }else{
            //Contabilizar falha de página
            ++MMU.falhaPag;
            return(MMU.mem.AcessaMem(p));
        }
    }
}
