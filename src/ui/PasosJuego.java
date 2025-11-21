package ui;

import bl.ABB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PasosJuego {

    public static BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

    public static void esperar(int segundos) {
        for (int c = 0; c <= (segundos - 1); ++c) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Lo sentimos, sucedió algo inesperado.");
            }
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
                Thread.sleep(1000); // 2000 milliseconds = 2 seconds
            } catch (InterruptedException e) {
                System.out.println("Lo sentimos, sucedió algo inesperado.");
            }
            System.out.println((c + 1) + "...");
        }
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
                "2) Cada nodo del árbol puede tener máximo dos enlaces\n" +
                "a otros nodos: su hijo izquierdo y su hijo derecho.\n\n" +
                "3) La llave de cada nodo debe ser mayor que la de su\n" +
                "hijo izquierdo y menor que la de su hijo derecho,\n" +
                "si los tiene. Un nodo puede tener uno o ambos hijos\n" +
                "nulos o vacíos.\n\n" +
                "4) No puede haber redundancia de caminos (o sea, debe\n" +
                "haber un único camino desde cualquier nodo hasta cualquier otro.)\n\n" +
                "¿Lo entiendes? \uD83D\uDE04\n" +
                "(Presiona la tecla Enter para ver un ejemplo gráfico)");
        entrada.readLine();
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
        System.out.println();
        arbolEjemplo.imprimirArbolPiramide();
        System.out.print("\n¿Ves cómo el árbol generado respeta todas las reglas de un ABB? \uD83D\uDC9A\n" +
                "(Presiona la tecla Enter para continuar aprendiendo)");
        entrada.readLine();
        esperar(5);
    }

    public static void explicarDesbalance() {
        System.out.println("Sin embargo, aunque los ABBs son estructuras de datos\n" +
                "ordenadas y eficientes, no son perfectos \uD83D\uDE12\n" +
                "En efecto, los nodos de un ABB pueden presentar lo\n" +
                "que se conoce como desbalance: la acumulación de más\n" +
                "nodos de un lado del nodo que del otro, lo cual se\n" +
                "manifiesta mediante una diferencia en la altura de\n" +
                "su hijo izquierdo y su hijo derecho.\n");
    }
}