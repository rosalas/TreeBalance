package bl;

public class ABB {

    // Atributos.
    private NodoABB raiz;

    // Métodos.
    // Constructor.
    public ABB() {
        raiz = null;
    }

    // Getters.
    public NodoABB getRaiz() {
        return raiz;
    }

    // Setters.
    public void setRaiz(NodoABB raiz) {
        this.raiz = raiz;
    }

    public boolean estaVacio() {
        return raiz == null;
    }

    public NodoABB buscar(int llaveBuscar) {
        if (estaVacio()) {
            System.out.println("El árbol está vacío.\n");
            return null;
        }
        NodoABB nodoTemp = raiz;
        while (nodoTemp.getLlave() != llaveBuscar) {
            if (llaveBuscar < nodoTemp.getLlave()) {
                nodoTemp = nodoTemp.getHijoIzquierdo();
            } else {
                nodoTemp = nodoTemp.getHijoDerecho();
            }
            if (nodoTemp == null) {
                System.out.println("El nodo buscado no está en el árbol.\n");
                return null;
            }
        }
        return nodoTemp;
    }

    // Método privado para insertar un nodo recursivamente.
    private NodoABB insertarRec(NodoABB nodo, int llaveInsertar) {
        if (nodo == null) {
            return new NodoABB(llaveInsertar);
        }

        if (llaveInsertar < nodo.getLlave()) {
            nodo.setHijoIzquierdo(insertarRec(nodo.getHijoIzquierdo(), llaveInsertar));
        } else if (llaveInsertar > nodo.getLlave()) {
            nodo.setHijoDerecho(insertarRec(nodo.getHijoDerecho(), llaveInsertar));
        } else {
            System.out.println("La llave " + llaveInsertar + " ya existe en el árbol\n.");
        }

        return nodo;
    }

    // Método público para insertar un nodo.
    public void insertar(int llaveInsertar) {
        raiz = insertarRec(raiz, llaveInsertar);
    }

    public void enOrden(NodoABB raizTemp) {
        if (raizTemp != null) {
            enOrden(raizTemp.getHijoIzquierdo());
            System.out.print(raizTemp.getLlave() + " ");
            enOrden(raizTemp.getHijoDerecho());
        }
    }

    public void preOrden(NodoABB raizTemp) {
        if (raizTemp != null) {
            System.out.print(raizTemp.getLlave() + " ");
            preOrden(raizTemp.getHijoIzquierdo());
            preOrden(raizTemp.getHijoDerecho());
        }
    }

    public void postOrden(NodoABB raizTemp) {
        if (raizTemp != null) {
            postOrden(raizTemp.getHijoIzquierdo());
            postOrden(raizTemp.getHijoDerecho());
            System.out.print(raizTemp.getLlave() + " ");
        }
    }

    // Método auxiliar privado para obtener el sucesor de un nodo.
    private NodoABB getSucesor(NodoABB nodo) {
        NodoABB sucesor = nodo.getHijoDerecho();
        while (sucesor.getHijoIzquierdo() != null) {
            sucesor = sucesor.getHijoIzquierdo();
        }
        return sucesor;
    }

    // Método auxiliar privado para reemplazar un nodo a eliminar por su sucesor.
    private NodoABB reemplazarConSucesor(NodoABB nodoOriginal, NodoABB sucesor) {
        sucesor.setHijoIzquierdo(nodoOriginal.getHijoIzquierdo());

        if (sucesor != nodoOriginal.getHijoDerecho()) {
            NodoABB padreSucesor = nodoOriginal.getHijoDerecho();
            while (padreSucesor.getHijoIzquierdo() != sucesor) {
                padreSucesor = padreSucesor.getHijoIzquierdo();
            }
            padreSucesor.setHijoIzquierdo(sucesor.getHijoDerecho());
            sucesor.setHijoDerecho(nodoOriginal.getHijoDerecho());
        }

        return sucesor;
    }

    // Método privado para eliminar un nodo recursivamente.
    private NodoABB eliminarRec(NodoABB nodo, int llaveEliminar) {
        if (nodo == null) {
            System.out.println("La llave " + llaveEliminar + " no está en el árbol.\n");
            return null;
        }

        if (llaveEliminar < nodo.getLlave()) {
            nodo.setHijoIzquierdo(eliminarRec(nodo.getHijoIzquierdo(), llaveEliminar));
        } else if (llaveEliminar > nodo.getLlave()) {
            nodo.setHijoDerecho(eliminarRec(nodo.getHijoDerecho(), llaveEliminar));
        } else {
            if (nodo.getHijoIzquierdo() == null && nodo.getHijoDerecho() == null) {
                // Nodo sin hijos.
                return null;
            } else if (nodo.getHijoIzquierdo() == null) {
                // Nodo con sólo hijo derecho.
                return nodo.getHijoDerecho();
            } else if (nodo.getHijoDerecho() == null) {
                // Nodo con sólo hijo izquierdo.
                return nodo.getHijoIzquierdo();
            } else {
                // Nodo con dos hijos.
                NodoABB sucesor = getSucesor(nodo);
                nodo = reemplazarConSucesor(nodo, sucesor);
            }
        }

        return nodo;
    }

    // Método público para eliminar un nodo.
    public void eliminar(int llaveEliminar) {
        raiz = eliminarRec(raiz, llaveEliminar);
    }
}