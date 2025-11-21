package ui;

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
        System.out.println(" \uD83C\uDF32\uD83C\uDF32\uD83C\uDF32 Bienvenido a TreeBalance " +
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
        esperar(3);
    }

    public static void espacio() {
        for (int c = 0; c < 30; ++c) {
            System.out.println();
        }
    }

    public static void explicarABB() {
        System.out.println("Antes que nada, es importante conocer los árboles\n" +
                "binarios de búsqueda o ABBs. Un ABB es una estructura\n" +
                "de datos que permite almacenar información de forma\n" +
                "ordenada, garantizando eficiencia en operaciones de\n" +
                "inserción, búsqueda y eliminación.\n\n" +
                "Todo ABB debe obedecer las siguientes reglas:\n\n" +
                "1) Cada uno de sus nodos (es decir, los elementos que\n" +
                "almacena) debe tener una llave única e irrepetible.\n" +
                "Los nodos de un ABB pueden representar cualquier entidad\n" +
                "que se requiere almacenar y gestionar en un programa.\n" +
                "La llave suele ser un número o cadena alfanumérica.\n" +
                "2) Cada nodo del árbol puede tener máximo dos enlaces\n" +
                "a otros nodos: su hijo izquierdo y su hijo derecho.\n" +
                "3) La llave de cada nodo debe ser mayor que la de su\n" +
                "hijo izquierdo y menor que la de su hijo derecho\n" +
                "(si los tiene). Un nodo puede tener uno o dos hijos\n" +
                "nulos o vacíos.\n" +
                "4) No puede haber redundancia de caminos (o sea, debe\n" +
                "haber un único camino desde cualquier nodo hasta cualquier otro.)\n\n" +
                "¿Lo entiendes? \uD83D\uDE04\n" +
                "(Presiona la tecla Enter para ver un ejemplo gráfico)");
    }
}