package trabso2;

public class TabelaPag {

    EntradaTP TabPag[] = new EntradaTP[1048576];
    Memoria mem = new Memoria();
    public TabelaPag(){
        
    }

    public void BuscaTP(int p) {
        if(TabPag[p].isValido() == true){
            //atualizar na TLB
            
        }else{
            //Contabilizar falha de página
            mem.BuscaMem(p);
        }
    }
}
