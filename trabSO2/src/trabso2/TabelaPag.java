package trabso2;
import java.util.ArrayList;
public class TabelaPag {

    ArrayList<EntradaTP> TabPag = new ArrayList<>();
    Memoria mem = new Memoria();

    public void BuscaTP(int p) {
        if(TabPag.get(p).isValido()){
            //atualizar na TLB
            
        }else{
            //Contabilizar falha de página
            mem.BuscaMem(p);
        }
    }
}
