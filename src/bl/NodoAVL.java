package bl;

public class NodoAVL {

    // Atributos.
    private int llave;
    private NodoAVL hijoIzquierdo;
    private NodoAVL hijoDerecho;
    private int altura;

    // Métodos.
    // Constructor.
    public NodoAVL(int llave) {
        this.llave = llave;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
        altura = 1; // Cualquier nodo es una hoja al momento de su inserción.
        // La altura de toda hoja es 1 por defecto. Los nodos nulos tienen altura 0 por defecto.
    }

    // Getters.
    public int getLlave() {
        return llave;
    }

    public NodoAVL getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public NodoAVL getHijoDerecho() {
        return hijoDerecho;
    }

    public int getAltura() {
        return altura;
    }

    // Setters.
    public void setLlave(int llave) {
        this.llave = llave;
    }

    public void setHijoIzquierdo(NodoAVL hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public void setHijoDerecho(NodoAVL hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int evaluarAltura(NodoAVL nodoEvaluar) {
        if (nodoEvaluar == null) {
            return 0;
        }
        return nodoEvaluar.getAltura();
    }

    public int evaluarBalance(NodoAVL nodoEvaluar) {
        if (nodoEvaluar == null) {
            return 0;
        }
        return evaluarAltura(nodoEvaluar.getHijoIzquierdo()) -
                evaluarAltura(nodoEvaluar.getHijoDerecho());
    }

    public int balancear() {
        return evaluarBalance(this);
    }

    // Realizar rotación simple a la izquierda.
    public NodoAVL rotarIzquierda(NodoAVL nodoRotar) {
        NodoAVL nuevoPadre = nodoRotar.getHijoDerecho();
        NodoAVL nodoTemp = nuevoPadre.getHijoIzquierdo();

        //Realizar la rotación izquierda.
        nuevoPadre.setHijoIzquierdo(nodoRotar);
        nodoRotar.setHijoDerecho(nodoTemp);

        // Actualizar las alturas de los nodos.
        nodoRotar.actualizarAltura();
        nuevoPadre.actualizarAltura();

        return nuevoPadre;
    }

    // Realizar rotación simple a la derecha.
    public NodoAVL rotarDerecha(NodoAVL nodoRotar) {
        NodoAVL nuevoPadre = nodoRotar.getHijoIzquierdo();
        NodoAVL temp = nuevoPadre.getHijoDerecho();

        // Realizar la rotación derecha.
        nuevoPadre.setHijoDerecho(nodoRotar);
        nodoRotar.setHijoIzquierdo(temp);

        // Actualizar las alturas de los nodos.
        nodoRotar.actualizarAltura();
        nuevoPadre.actualizarAltura();

        return nuevoPadre;
    }

    //Realizar rotación doble, primero a la izquierda y luego a la derecha.
    public NodoAVL rotarIzquierdaDerecha(NodoAVL nodoRotar) {
        nodoRotar.setHijoIzquierdo(rotarIzquierda(nodoRotar.getHijoIzquierdo()));
        return rotarDerecha(nodoRotar);
    }

    //Realizar rotación doble, primero a la derecha y luego a la izquierda.
    public NodoAVL rotarDerechaIzquierda(NodoAVL nodoRotar) {
        nodoRotar.setHijoDerecho(rotarDerecha(nodoRotar.getHijoDerecho()));
        return rotarIzquierda(nodoRotar);
    }

    public void actualizarAltura() {
        this.altura = Math.max(evaluarAltura(hijoIzquierdo), evaluarAltura(hijoDerecho)) + 1;
    }
}