package trabso2;

public class TabelaPag {

    public void BuscaTP(int p) {
        if(MMU.TabPag.get(p).isValido()){
            //atualizar na TLB
            MMU.tlb.substitui(p, MMU.TabPag.get(p).getF());
        }else{
            //Contabilizar falha de página
            ++MMU.falhaPag;
            MMU.mem.BuscaMem(p);
        }
    }
}
