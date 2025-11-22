package ui;

import bl.ABB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PasosJuego {

    public static BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

    public static void esperar(int segundos) {
        try {
            Thread.sleep(segundos * 1000L);
        } catch (InterruptedException e) {
            System.out.println("Lo sentimos, sucedió algo inesperado.");
            Thread.currentThread().interrupt();
        }
    }

    public static void intro() throws IOException {
        System.out.println("\uD83C\uDF32\uD83C\uDF32\uD83C\uDF32 Bienvenido a TreeBalance " +
                "\uD83C\uDF32\uD83C\uDF32\uD83C\uDF32\n");
        System.out.println("TreeBalance es una pequeña aplicación de gamificación\n" +
                "para el aprendizaje de las operaciones de autobalanceo\n" +
                "en árboles binarios de búsqueda (ABBs) del tipo AVL.\n");
        System.out.println("A través de los próximos pasos, aprenderemos juntos\n" +
                "sobre el desbalance en los ABBs ordinarios, su efecto\n" +
                "sobre la eficiencia de las operaciones realizadas en\n" +
                "dicha estructura de datos, y el funcionamiento de\n" +
                "las operaciones de un árbol autobalanceado de la variedad AVL.\n");
        System.out.print("¿Estás list@? \uD83D\uDC40\n" +
                "(Presiona la tecla Enter para comenzar)");
        entrada.readLine();
        for (int c = 2; c >= 0; --c) {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                System.out.println("Lo sentimos, sucedió algo inesperado.");
                Thread.currentThread().interrupt();
            }
            System.out.println((c + 1) + "...");
        }
        esperar(1);
        System.out.println("Muy bien, entonces, ¡empecemos! \uD83D\uDCAA\n");
        esperar(5);
    }

    public static void espacio() {
        for (int c = 0; c < 30; ++c) {
            System.out.println();
        }
    }

    public static void explicarABB() throws IOException {
        System.out.print("Antes que nada, es importante conocer los árboles\n" +
                "binarios de búsqueda o ABBs. Un ABB es una estructura\n" +
                "de datos que permite almacenar información de forma\n" +
                "ordenada, garantizando eficiencia en operaciones de\n" +
                "inserción, búsqueda y eliminación.\n\n" +
                "Todo ABB debe obedecer las siguientes reglas:\n\n" +
                "1) Cada uno de sus nodos (es decir, los elementos que\n" +
                "almacena) debe tener una llave \uD83D\uDD11 única e irrepetible.\n" +
                "Los nodos de un ABB pueden representar cualquier entidad\n" +
                "que se requiere almacenar y gestionar en un programa.\n" +
                "La llave suele ser un número o cadena alfanumérica.\n\n" +
                "2) Cada nodo del árbol puede tener máximo dos referencias\n" +
                "a otros nodos: su hijo izquierdo \uD83D\uDC66⬅\uFE0F y su hijo derecho ➡\uFE0F\uD83D\uDC66\n\n" +
                "3) Todo ABB tiene una única raíz \uD83C\uDF31 la cual es el único\n" +
                "nodo de toda la estructura que no es hijo de otro.\n\n" +
                "4) La llave de cada nodo debe ser mayor que la de su\n" +
                "hijo izquierdo y menor que la de su hijo derecho,\n" +
                "si los tiene. Un nodo puede tener uno o ambos hijos\n" +
                "nulos o vacíos \uD83D\uDEAB\n\n" +
                "5) No puede haber redundancia de caminos \uD83D\uDEE3\uFE0F (o sea, debe\n" +
                "haber un único camino desde cualquier nodo hasta cualquier otro.)\n\n" +
                "¿Lo entiendes? \uD83D\uDE04\n" +
                "(Presiona la tecla Enter para ver un ejemplo gráfico)");
        entrada.readLine();
        esperar(5);
    }

    public static void ejemploABB() throws IOException {
        System.out.print("\nVamos a construir un ABB sencillo con las siguientes\n" +
                "llaves: 20, 10, 30, 5, 15, 25 y 35.\n" +
                "(Presiona la tecla Enter para visualizar el árbol \uD83C\uDF32)");
        entrada.readLine();
        ABB arbolEjemplo = new ABB();
        arbolEjemplo.insertar(20);
        arbolEjemplo.insertar(10);
        arbolEjemplo.insertar(30);
        arbolEjemplo.insertar(5);
        arbolEjemplo.insertar(15);
        arbolEjemplo.insertar(25);
        arbolEjemplo.insertar(35);
        for (int c = 2; c >= 0; --c) {
            try {
                Thread.sleep(1000); // 2000 milliseconds = 2 seconds
            } catch (InterruptedException e) {
                System.out.println("Lo sentimos, sucedió algo inesperado.");
            }
            System.out.println((c + 1) + "...");
        }
        esperar(1);
        System.out.println("\n");
        arbolEjemplo.imprimirArbolPiramide();
        System.out.print("\n\n¿Ves cómo el árbol generado respeta todas las reglas de un ABB? \uD83D\uDC9A\n" +
                "(Presiona la tecla Enter para continuar aprendiendo)");
        entrada.readLine();
        esperar(5);
    }

    public static void explicarDesbalance() throws IOException {
        System.out.print("Sin embargo, aunque los ABBs son estructuras de datos\n" +
                "ordenadas y eficientes, no son perfectos \uD83D\uDE12\n" +
                "En efecto, los nodos de un ABB pueden presentar lo\n" +
                "que se conoce como desbalance: la acumulación de más\n" +
                "nodos de un lado del nodo que del otro, lo cual se\n" +
                "manifiesta a través de una diferencia en la altura de\n" +
                "su hijo izquierdo y su hijo derecho.\n" +
                "(Presiona la tecla Enter para ver un ejemplo gráfico)");
        entrada.readLine();
        esperar(5);
    }

    public static void ejemploDesbalance() throws IOException {
        System.out.print("\nVamos a construir un ABB desbalanceado \uD83D\uDE1F con las siguientes\n" +
                "llaves: 10, 20, 30, 5, 25, 35 y 15.\n" +
                "(Presiona la tecla Enter para visualizar el árbol \uD83C\uDF32)");
        entrada.readLine();
        ABB arbolDesbalance = new ABB();
        arbolDesbalance.insertar(10);
        arbolDesbalance.insertar(20);
        arbolDesbalance.insertar(30);
        arbolDesbalance.insertar(5);
        arbolDesbalance.insertar(25);
        arbolDesbalance.insertar(35);
        arbolDesbalance.insertar(15);
        for (int c = 2; c >= 0; --c) {
            try {
                Thread.sleep(1000); // 2000 milliseconds = 2 seconds
            } catch (InterruptedException e) {
                System.out.println("Lo sentimos, sucedió algo inesperado.");
            }
            System.out.println((c + 1) + "...");
        }
        esperar(1);
        System.out.println("\n");
        arbolDesbalance.imprimirArbolPiramide();
        System.out.print("\n\n¿Notaste que las llaves utilizadas en este segundo\n" +
                "árbol fueron las mismas que en el primero? \uD83D\uDD75\uFE0F\u200D♂\uFE0F\uD83D\uDD75\uFE0F\u200D♀\uFE0F\n" +
                "Sin embargo, el árbol resultante es muy distinto en ambos casos.\n" +
                "En efecto, los ABBs son sensibles al orden de inserción:\n" +
                "las mismas llaves insertadas en órdenes distintos generan\n" +
                "árboles distintos. \uD83C\uDF33\uD83C\uDF32\uD83C\uDF34\n" +
                "(Presiona la tecla Enter para continuar aprendiendo)");
        entrada.readLine();
        esperar(5);
    }

    public static void explicarAutobalance() throws IOException {
        System.out.print("Debido a que el desbalance de un ABB lo hace ser menos\n" +
                "eficiente, ya que pierde, aunque sea de forma parcial, su carácter\n" +
                "binario y se asemeja a una estructura lineal, se han propuesto\n" +
                "diversas estructuras que comparten el aspecto general del ABB pero\n" +
                "presentan la capacidad de autobalancearse ⚖\uFE0F\n" +
                "De esas estructuras, el árbol AVL implementa operaciones que le permiten\n" +
                "corregir los desbalances que pueden surgir en él tras la inserción\n" +
                "o eliminación de un nodo.\n" +
                "La regla principal de un AVL, en cuya evaluación se basa su capacidad\n" +
                "de autobalancearse, es que ningún nodo puede tener un factor de\n" +
                "balance (FB) menor que -1 o mayor que +1.\n" +
                "A continuación, vamos a aprender sobre el FB y la altura de los nodos.\n" +
                "(Presiona la tecla Enter para seguir aprendiendo)");
        entrada.readLine();
        esperar(5);
    }

    public static void explicarAltura() throws IOException {
        System.out.print("Para entender el concepto de factor de balance,\n" +
                "primero es necesario saber qué se entiende por altura\n" +
                "de un nodo \uD83C\uDFD4\uFE0F\n\n" +
                "➡\uFE0F La altura de un nodo se define como la longitud\n" +
                "del camino más largo que se puede seguir desde un nodo\n" +
                "cualquiera hasta llegar a una hoja \uD83C\uDF3F\n" +
                "(Nota: Se llama hoja a los nodos que no tienen hijos)\n" +
                "➡\uFE0F Por definición, se dice que la altura de una hoja es\n" +
                "siempre 1, ya que para llegar a ella sólo hace falta\n" +
                "referenciar a un nodo (ella misma).\n" +
                "➡\uFE0F Los nodos nulos, por la misma razón, tienen una altura\n" +
                "de 0.\n" +
                "➡\uFE0F En todo árbol binario de búsqueda, la raíz es siempre\n" +
                "el nodo con mayor altura.\n" +
                "(Presiona la tecla Enter para ver un ejemplo)");
        entrada.readLine();
        esperar(5);
    }

    public static void ejemploAutobalance() throws IOException {
        System.out.print("\nVamos a construir un ABB desbalanceado \uD83D\uDE1F con las siguientes\n" +
                "llaves: 10, 20, 30, 5, 25, 35 y 15.\n" +
                "(Presiona la tecla Enter para visualizar el árbol \uD83C\uDF32)");
        entrada.readLine();
        ABB arbolDesbalance = new ABB();
        arbolDesbalance.insertar(10);
        arbolDesbalance.insertar(20);
        arbolDesbalance.insertar(30);
        arbolDesbalance.insertar(5);
        arbolDesbalance.insertar(25);
        arbolDesbalance.insertar(35);
        arbolDesbalance.insertar(15);
        for (int c = 2; c >= 0; --c) {
            try {
                Thread.sleep(1000); // 2000 milliseconds = 2 seconds
            } catch (InterruptedException e) {
                System.out.println("Lo sentimos, sucedió algo inesperado.");
            }
            System.out.println((c + 1) + "...");
        }
        esperar(1);
        System.out.println("\n");
        arbolDesbalance.imprimirArbolPiramide();
        System.out.print("\n\n¿Notaste que las llaves utilizadas en este segundo\n" +
                "árbol fueron las mismas que en el primero? \uD83D\uDD75\uFE0F\u200D♂\uFE0F\uD83D\uDD75\uFE0F\u200D♀\uFE0F\n" +
                "Sin embargo, el árbol resultante es muy distinto en ambos casos.\n" +
                "En efecto, los ABBs son sensibles al orden de inserción:\n" +
                "las mismas llaves insertadas en órdenes distintos generan\n" +
                "árboles distintos. \uD83C\uDF33\uD83C\uDF32\uD83C\uDF34\n" +
                "(Presiona la tecla Enter para continuar aprendiendo)");
        entrada.readLine();
        esperar(5);
    }
}