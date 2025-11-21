public class AVL {

    //Atributos.
    private NodoAVL raiz;

    //Métodos.
    //Constructor.
    public AVL() {
        raiz = null;
    }

    public boolean estaVacio() {
        return raiz == null;
    }

    public NodoAVL buscar(int llaveBuscar) {
        if (estaVacio()) {
            System.out.println("El árbol está vacío.\n");
            return null;
        }
        NodoAVL nodoTemp = raiz;
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

    // Método auxiliar privado para balancear un nodo tras una inserción/eliminación.
    private NodoAVL balancearNodo(NodoAVL nodo) {
        int balance = nodo.balancear();

        // Desbalance izquierdo-izquierdo.
        if (balance > 1 && nodo.getHijoIzquierdo().balancear() >= 0) {
            return nodo.rotarDerecha(nodo);
        }

        // Desbalance izquierdo-derecho.
        if (balance > 1 && nodo.getHijoIzquierdo().balancear() < 0) {
            return nodo.rotarIzquierdaDerecha(nodo);
        }

        // Desbalance derecho-derecho.
        if (balance < -1 && nodo.getHijoDerecho().balancear() <= 0) {
            return nodo.rotarIzquierda(nodo);
        }

        // Desbalance derecho-izquierdo.
        if (balance < -1 && nodo.getHijoDerecho().balancear() > 0) {
            return nodo.rotarDerechaIzquierda(nodo);
        }

        return nodo;
    }

    // Método privado para insertar un nodo.
    private NodoAVL insertarNodo(NodoAVL nodo, int llaveInsertar) {
        if (nodo == null) {
            return new NodoAVL(llaveInsertar);
        }

        if (llaveInsertar < nodo.getLlave()) {
            nodo.setHijoIzquierdo(insertarNodo(nodo.getHijoIzquierdo(), llaveInsertar));
        } else if (llaveInsertar > nodo.getLlave()) {
            nodo.setHijoDerecho(insertarNodo(nodo.getHijoDerecho(), llaveInsertar));
        } else {
            System.out.println("La llave ya existe en el árbol.\n");
            return nodo;
        }

        // Actualizar la altura del nodo.
        nodo.actualizarAltura();

        // Balancear el nodo tras la inserción.
        return balancearNodo(nodo);
    }

    // Método público para insertar un nodo.
    public void insertar(int llaveInsertar) {
        raiz = insertarNodo(raiz, llaveInsertar);
    }

    public void enOrden(NodoAVL raizTemp) {
        if (raizTemp != null) {
            enOrden(raizTemp.getHijoIzquierdo());
            System.out.print(raizTemp.getLlave() + " ");
            enOrden(raizTemp.getHijoDerecho());
        }
    }

    public void preOrden(NodoAVL raizTemp) {
        if (raizTemp != null) {
            System.out.print(raizTemp.getLlave() + " ");
            preOrden(raizTemp.getHijoIzquierdo());
            preOrden(raizTemp.getHijoDerecho());
        }
    }

    public void postOrden(NodoAVL raizTemp) {
        if (raizTemp != null) {
            postOrden(raizTemp.getHijoIzquierdo());
            postOrden(raizTemp.getHijoDerecho());
            System.out.print(raizTemp.getLlave() + " ");
        }
    }

    private NodoAVL getSucesor(NodoAVL nodoBorrar) {
        NodoAVL padreSucesor = nodoBorrar;
        NodoAVL sucesor = nodoBorrar;
        NodoAVL nodoActual = nodoBorrar.getHijoDerecho();
        while (nodoActual != null) {
            padreSucesor = sucesor;
            sucesor = nodoActual;
            nodoActual = nodoActual.getHijoIzquierdo();
        }
        if (sucesor != nodoBorrar.getHijoDerecho()) {
            padreSucesor.setHijoIzquierdo(sucesor.getHijoDerecho());
            sucesor.setHijoDerecho(nodoBorrar.getHijoDerecho());
        }
        return sucesor;
    }

    // Método auxiliar privado para establecer las relaciones correctas con el sucesor.
    private NodoAVL reemplazarSucesor(NodoAVL nodo, NodoAVL sucesor) {
        sucesor.setHijoIzquierdo(nodo.getHijoIzquierdo());
        sucesor.setHijoDerecho(nodo.getHijoDerecho());
        return sucesor;
    }

    // Método privado para eliminar un nodo.
    private NodoAVL eliminarNodo(NodoAVL nodo, int llaveEliminar) {
        if (nodo == null) {
            System.out.println("La llave no está en el árbol.\n");
            return null;
        }

        if (llaveEliminar < nodo.getLlave()) {
            nodo.setHijoIzquierdo(eliminarNodo(nodo.getHijoIzquierdo(), llaveEliminar));
        } else if (llaveEliminar > nodo.getLlave()) {
            nodo.setHijoDerecho(eliminarNodo(nodo.getHijoDerecho(), llaveEliminar));
        } else {
            // Nodo sin hijos.
            if (nodo.getHijoIzquierdo() == null && nodo.getHijoDerecho() == null) {
                return null;
            }

            // Nodo con un solo hijo.
            if (nodo.getHijoIzquierdo() == null) {
                return nodo.getHijoDerecho();
            } else if (nodo.getHijoDerecho() == null) {
                return nodo.getHijoIzquierdo();
            }

            // Nodo con dos hijos.
            NodoAVL sucesor = getSucesor(nodo);
            nodo = reemplazarSucesor(nodo, sucesor);
        }

        // Actualizar altura del nodo después de eliminar.
        nodo.actualizarAltura();

        // Balancear nodo después de una eliminación.
        return balancearNodo(nodo);
    }

    // Método público para eliminar un nodo.
    public void eliminar(int llaveEliminar) {
        raiz = eliminarNodo(raiz, llaveEliminar);
    }
}