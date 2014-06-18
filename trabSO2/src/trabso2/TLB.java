package trabso2;

public class TLB {

    private final int tamanho = 2;
    private boolean alocado = false;
    EntradaTLB vetorTLB[] = new EntradaTLB[tamanho];

    public TLB(int _p) {
        for (int i = 0; i < tamanho; i++) {
            if (vetorTLB[i].getP() == _p) {
                //retorna o frame, TLB HIT++
                alocado = true;
            }
            if ((i == (tamanho - 1)) && (alocado == false)) {
                //TLB MISS ++
                //Buscar na tabela de página
            }
        }
    }
}
