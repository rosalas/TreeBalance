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
}