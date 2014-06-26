package SegundaChance;

public class TLB {

    static int tamanho = 2;
    static int cont = 0;

    public int BuscaTLB(int _p) {
        for (int i = 0; i < tamanho; i++) {
            if ((i<cont) && (MMU.vetorTLB.get(i).getP() == _p)) {
                ++MMU.TLBHIT;
                //colocando o elemento no topo da pilha (LRU)
                //MMU.LRUTLB.push(MMU.LRUTLB.remove(i));
                MMU.vetorTLB.get(i).setSc(1);
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
        entrada.setSc(1);
        if (cont < tamanho) {
            MMU.vetorTLB.add(entrada);
            //setar bit como 1 na memória
        } else {//substituição SegundaChance
            while (true){
                if(MMU.vetorTLB.get(MMU.SCTLB).getSc() == 0){
                    //efetua troca
                    MMU.vetorTLB.set(MMU.SCTLB, entrada);
                    //setar bit como um na memória
                    break;
                }else{
                    MMU.vetorTLB.get(MMU.SCTLB).setSc(0);
                }
                ++MMU.SCTLB;
                if(MMU.SCTLB>=tamanho){
                    MMU.SCTLB=0;
                }
            }
        }
    }
}
