package LRU;

public class EntradaTP {
    private int f;
    private boolean valido;

    public EntradaTP() {
        this.f = -1;
        this.valido = false;
    }
    

    public int getF() {
        return f;
    }

    public void setF(int f) {
        this.f = f;
    }

    public boolean isValido() {
        return valido;
    }

    public void setValido(boolean valido) {
        this.valido = valido;
    }
    
    
}
