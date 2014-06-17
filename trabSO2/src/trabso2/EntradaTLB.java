package trabso2;

class EntradaTLB {

    private int p;//Número da página
    private int f;//frame
    private boolean alocado = false; //se já tem endereço alocado

    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }

    public int getF() {
        return f;
    }

    public void setF(int f) {
        this.f = f;
    }

    public boolean isAlocado() {
        return alocado;
    }

    public void setAlocado(boolean alocado) {
        this.alocado = alocado;
    }

}
