package bl;

public class NodoABB {

    // Atributos.
    private int llave;
    private NodoABB hijoIzquierdo;
    private NodoABB hijoDerecho;

    // Métodos.
    // Constructor.
    public NodoABB(int llave) {
        this.llave = llave;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
    }

    // Getters.
    public int getLlave() {
        return llave;
    }

    public NodoABB getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public NodoABB getHijoDerecho() {
        return hijoDerecho;
    }

    // Setters.
    public void setHijoIzquierdo(NodoABB hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public void setHijoDerecho(NodoABB hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }
}