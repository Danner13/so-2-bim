package SegundaChance;

public class TabelaPag {

    public int BuscaTP(int p) {
        if (MMU.TabPag.get(p).isValido()) {
            //atualizar na TLB
            MMU.tlb.substitui(p, MMU.TabPag.get(p).getF());

            Integer f = MMU.TabPag.get(p).getF();
            return (f);
        } else {
            //Contabilizar falha de página
            ++MMU.falhaPag;
            return (MMU.mem.AcessaMem(p));
        }
    }
}
