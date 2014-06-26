package SegundaChance;

public class TLB {

    static int tamanho = 2;
    static int cont = 0;

    public int BuscaTLB(int _p) {
        for (int i = 0; i < tamanho; i++) {
            if ((i<cont) && (MMU.vetorTLB.get(i).getP() == _p)) {
                ++MMU.TLBHIT;
                MMU.vetorTLB.get(i).setSc(1);
                MMU.Mem.get(MMU.vetorTLB.get(i).getF()).setB(1);
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
            MMU.Mem.get(entrada.getF()).setB(1);
            ++cont;
        } else {//substituição SegundaChance
            while (true){
                if(MMU.SCTLB>=tamanho){
                    MMU.SCTLB=0;
                }
                
                if(MMU.vetorTLB.get(MMU.SCTLB).getSc() == 0){
                    //efetua troca
                    MMU.vetorTLB.set(MMU.SCTLB, entrada);
                    MMU.Mem.get(entrada.getF()).setB(1);
                    ++MMU.SCTLB;
                    break;
                }else{
                    MMU.vetorTLB.get(MMU.SCTLB).setSc(0);
                }
                ++MMU.SCTLB;
            }
        }
    }
}
