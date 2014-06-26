package SegundaChance;

public class Memoria {

    static int i = -1;
    int tam = 64;

    public int AcessaMem(int _p) {
        //Substituir páginas
        //Atualizar TLB e tabela de páginas
        if (MMU.Mem.size() < tam) {
            ++i;
            EntradaMem entrada = new EntradaMem();
            entrada.setB(1);
            entrada.setM(_p);
            MMU.Mem.add(i, entrada);
            MMU.TabPag.get(_p).setValido(true);//setando o bit como válido
            MMU.TabPag.get(_p).setF(i);
            MMU.tlb.substitui(_p, i);
            return (i);
        } else {
            //System.out.println("Memória cheia");
            while (true) {
                if (MMU.SCMem >= tam) {
                    MMU.SCMem = 0;
                    System.out.println("Zera SCMem");
                }

                if (MMU.Mem.get(MMU.SCMem).getB() == 1) {
                    MMU.Mem.get(MMU.SCMem).setB(0);
                    //System.out.println("Troca bit pra 0");
                } else {
                    for (int k = 0; k < 1048576; k++) {
                        if (MMU.TabPag.get(k).isValido() && (MMU.TabPag.get(k).getF() == MMU.SCMem)) {
                            MMU.TabPag.get(k).setValido(false);
                            MMU.TabPag.get(k).setF(-1);
                            MMU.TabPag.get(_p).setValido(true);
                            MMU.TabPag.get(_p).setF(MMU.SCMem);
                            MMU.tlb.substitui(_p, MMU.SCMem);
                            //System.out.println("Substitui e retorna");
                            ++MMU.SCMem;
                            return (MMU.SCMem-1);
                        }
                    }
                }
                ++MMU.SCMem;

            }
        }
    }
}
