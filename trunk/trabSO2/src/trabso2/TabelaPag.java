package trabso2;

public class TabelaPag {

    EntradaTP TabPag[] = new EntradaTP[1048576];

    public void BuscaTP(int p) {
        if(TabPag[p].isValido() == true){
            //Hit na tabela de página
            //atualizar na TLB
            
        }else{
            //Tem que alocar na memória
        }
    }
}
