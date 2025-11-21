package bl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    // Mètodo auxiliar privado para obtener la altura de un nodo recursivamente.
    private int alturaRec(NodoABB nodo) {
        if (nodo == null) {
            return 0;
        }

        int alturaIzq = alturaRec(nodo.getHijoIzquierdo());
        int alturaDer = alturaRec(nodo.getHijoDerecho());

        return Math.max(alturaIzq, alturaDer) + 1;
    }

    // Método auxiliar privado para obtener la altura de la raíz del árbol.
    private int alturaRaiz() {
        return alturaRec(raiz);
    }

    // Imprimir árbol en la consola en forma de pirámide.
    public void imprimirArbolPiramide() {
        if (raiz == null) {
            System.out.println("El árbol está vacío.\n");
            return;
        }

        int altura = alturaRaiz();

        Queue<NodoABB> colaNodos = new LinkedList<>();
        colaNodos.add(raiz);

        for (int nivel = 1; nivel <= altura; nivel++) {
            int nodosNivel = (int) Math.pow(2, nivel - 1);

            // Espacios antes de imprimir el primer nodo.
            int espacioInicial = (int) Math.pow(2, altura - nivel) - 1;

            // Espacios entre nodos.
            int espacio = (int) Math.pow(2, altura - nivel + 1) - 1;

            // Imprimir espacios iniciales.
            for (int i = 0; i < espacioInicial; i++) {
                System.out.print("   ");
            }

            // Imprimir todos los nodos del nivel actual.
            List<NodoABB> siguientes = new ArrayList<>();
            for (int i = 0; i < nodosNivel; i++) {
                NodoABB nodo = colaNodos.poll();
                if (nodo != null) {
                    System.out.printf("%3d", nodo.getLlave());
                    siguientes.add(nodo.getHijoIzquierdo());
                    siguientes.add(nodo.getHijoDerecho());
                } else {
                    System.out.print("   ");
                    siguientes.add(null);
                    siguientes.add(null);
                }

                // Imprimir espacios entre nodos.
                for (int j = 0; j < espacio; j++) {
                    System.out.print("   ");
                }
            }
            System.out.println();

            // Preparar la siguiente fila del árbol.
            colaNodos.addAll(siguientes);
        }
    }
}