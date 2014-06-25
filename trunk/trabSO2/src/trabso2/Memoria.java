package trabso2;

public class Memoria {

    public int AcessaMem(int _p) {
        //Substituir páginas
        //Atualizar TLB e tabela de páginas

        int i = 0;
        if (MMU.Mem.size() < 64) {
            MMU.Mem.add(i, _p);
            MMU.LRUMem.add(i);
            ++i;
        }
        else{
             //MMU.LRUMem.remove(0);
             //MMU.LRUMem.push();
        }

        return (i - 1);
    }
}
