
package trabso2;

public class Memoria {
    int Memoria[] = new int[64];
    boolean alocado=false;
    public void BuscaMem(int _p){
        for(int i=0;i<64;i++){
            if(_p == Memoria[i]){
                //Hit na memória*****
                //substituir na TLB e na Tabela de páginas
                alocado = true;
            }else{
                if((alocado == false) && (i==63)){
                    //Miss na memória
                    //Substitui na memória
                    //setar como válido na tabela
                    //alocar posição na tabela
                }
            }
        }
    }
}
