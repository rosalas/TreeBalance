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
        System.out.print("\n\n\uD83D\uDCBB Árboles binarios de búsqueda \uD83D\uDCBB\n\n" +
                "Antes que nada, es importante conocer los árboles\n" +
                "binarios de búsqueda o ABBs. Un ABB es una estructura\n" +
                "de datos que permite almacenar información de forma\n" +
                "ordenada, garantizando eficiencia en operaciones de\n" +
                "inserción, búsqueda y eliminación.\n\n" +
                "(Presiona la tecla Enter para continuar leyendo)");
        entrada.readLine();
        esperar(1);
        System.out.print("\nTodo ABB debe obedecer las siguientes reglas:\n\n" +
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
                "(Presiona la tecla Enter para ver un ejemplo)");
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
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Lo sentimos, sucedió algo inesperado.");
            }
            System.out.println((c + 1) + "...");
        }
        esperar(1);
        System.out.println("\n");
        arbolEjemplo.imprimirArbolPiramide();
        System.out.print("\n\n¿Ves cómo el árbol generado respeta todas las reglas de un ABB? \uD83D\uDC9A\n" +
                "(Presiona la tecla Enter para practicar lo aprendido)");
        entrada.readLine();
        esperar(5);
    }

    public static void ejerciciosABB() throws IOException {
        System.out.print("\n\n\uD83C\uDFCB\uFE0F Ejercicios de ABBs \uD83C\uDFCB\uFE0F\n\n" +
                "¿Estás list@ para unos ejercicios? \uD83D\uDC40\n" +
                "(Presiona la tecla Enter para comenzar)");
        entrada.readLine();
        ABB arbolEjercicios = new ABB();
        arbolEjercicios.insertar(42);
        arbolEjercicios.insertar(15);
        arbolEjercicios.insertar(51);
        arbolEjercicios.insertar(28);
        arbolEjercicios.insertar(60);
        arbolEjercicios.insertar(17);
        arbolEjercicios.insertar(55);
        arbolEjercicios.insertar(69);
        for (int c = 2; c >= 0; --c) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Lo sentimos, sucedió algo inesperado.");
            }
            System.out.println((c + 1) + "...");
        }
        esperar(1);
        System.out.println("\n");
        arbolEjercicios.imprimirArbolPiramide();
        int respuesta;
        while (true) {
            System.out.print("\nPregunta 1: Si el nodo de llave 45 se insertara en el\n" +
                    "árbol mostrado, ¿cómo debería insertarse en la estructura?\n\n" +
                    "1) Hijo derecho del 28\n" +
                    "2) Hijo izquierdo del 51\n" +
                    "3) Hijo izquierdo del 55\n\n" +
                    "Respuesta: ");
            respuesta = Integer.parseInt(entrada.readLine());
            if (respuesta == 2) {
                System.out.println("\n\n✔\uFE0F ¡Correcto!");
                break;
            } else {
                System.out.println("\n\n❌ Incorrecto. Piénsalo mejor...");
                esperar(3);
            }
        }
        System.out.println("\n");
        arbolEjercicios.imprimirArbolPiramide();
        while (true) {
            System.out.print("\nPregunta 2: ¿Cuál de las siguientes llaves podría\n" +
                    "insertarse a la derecha del nodo de llave 28 sin afectar\n" +
                    "el orden de la estructura?\n\n" +
                    "1) 30\n" +
                    "2) 50\n" +
                    "3) 23\n\n" +
                    "Respuesta: ");
            respuesta = Integer.parseInt(entrada.readLine());
            if (respuesta == 1) {
                System.out.println("\n\n✔\uFE0F ¡Correcto!");
                break;
            } else {
                System.out.println("\n\n❌ Incorrecto. Piénsalo mejor...");
                esperar(3);
            }
        }
        System.out.print("¡Excelente trabajo! \uD83D\uDCAF\n" +
                "(Presiona la tecla Enter para continuar aprendiendo)");
        entrada.readLine();
        esperar(5);
    }

    public static void explicarDesbalance() throws IOException {
        System.out.print("\n\n\uD83D\uDCBB Desbalance \uD83D\uDCBB\n\n" +
                "Sin embargo, aunque los ABBs son estructuras de datos\n" +
                "ordenadas y eficientes, no son perfectos \uD83D\uDE12\n" +
                "En efecto, los nodos de un ABB pueden presentar lo\n" +
                "que se conoce como desbalance: la acumulación de más\n" +
                "nodos de un lado del nodo que del otro, lo cual se\n" +
                "manifiesta a través de una diferencia en la altura de\n" +
                "su hijo izquierdo y su hijo derecho.\n" +
                "(Presiona la tecla Enter para ver un ejemplo)");
        entrada.readLine();
        esperar(5);
    }

    public static void ejemploDesbalance() throws IOException {
        System.out.print("\nVamos a construir un ABB desbalanceado \uD83D\uDE1F con las siguientes\n" +
                "llaves: 10, 20, 30, 5, 25, 35 y 15.\n" +
                "(Presiona la tecla Enter para visualizar el árbol \uD83C\uDF32)");
        entrada.readLine();
        ABB arbolEjemplo = new ABB();
        arbolEjemplo.insertar(10);
        arbolEjemplo.insertar(20);
        arbolEjemplo.insertar(30);
        arbolEjemplo.insertar(5);
        arbolEjemplo.insertar(25);
        arbolEjemplo.insertar(35);
        arbolEjemplo.insertar(15);
        for (int c = 2; c >= 0; --c) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Lo sentimos, sucedió algo inesperado.");
            }
            System.out.println((c + 1) + "...");
        }
        esperar(1);
        System.out.println("\n");
        arbolEjemplo.imprimirArbolPiramide();
        System.out.print("\n\n¿Notaste que las llaves utilizadas en este segundo\n" +
                "árbol fueron las mismas que en el primero? \uD83D\uDD75\uFE0F\u200D♂\uFE0F\uD83D\uDD75\uFE0F\u200D♀\uFE0F\n" +
                "Sin embargo, el árbol resultante es muy distinto en ambos casos.\n" +
                "En efecto, los ABBs son sensibles al orden de inserción:\n" +
                "las mismas llaves insertadas en órdenes distintos generan\n" +
                "árboles distintos \uD83C\uDF33\uD83C\uDF32\uD83C\uDF34\n" +
                "(Presiona la tecla Enter para continuar aprendiendo)");
        entrada.readLine();
        esperar(5);
    }

    public static void explicarAutobalance() throws IOException {
        System.out.print("\n\n\uD83D\uDCBB Autobalance \uD83D\uDCBB\n\n" +
                "Debido a que el desbalance de un ABB lo hace ser menos\n" +
                "eficiente, ya que pierde, aunque sea de forma parcial, su carácter\n" +
                "binario y se asemeja a una estructura lineal, se han propuesto\n" +
                "diversas estructuras que comparten el aspecto general del ABB pero\n" +
                "presentan la capacidad de autobalancearse ⚖\uFE0F\n" +
                "De esas estructuras, el árbol AVL implementa operaciones que le permiten\n" +
                "corregir los desbalances que pueden surgir en él tras la inserción\n" +
                "o eliminación de un nodo.\n" +
                "La regla principal de un AVL, en cuya evaluación se basa su capacidad\n" +
                "de autobalancearse, es que ningún nodo puede tener un factor de\n" +
                "balance (FB) menor que o mayor que el permitido.\n" +
                "balance (FB) menor que o mayor que el permitido.\n" +
                "A continuación, vamos a aprender sobre el FB y la altura de los nodos.\n" +
                "(Presiona la tecla Enter para seguir aprendiendo)");
        entrada.readLine();
        esperar(5);
    }

    public static void explicarAltura() throws IOException {
        System.out.print("\n\n\uD83D\uDCBB Altura \uD83D\uDCBB\n\n" +
                "Para entender el concepto de factor de balance,\n" +
                "primero es necesario saber qué se entiende por altura\n" +
                "de un nodo \uD83C\uDFD4\uFE0F\n\n" +
                "➡\uFE0F La altura de un nodo se define como la longitud\n" +
                "del camino más largo que se puede seguir desde un nodo\n" +
                "cualquiera hasta llegar a un nodo nulo \uD83C\uDF3F\n" +
                "(\uD83D\uDD0D Nota: Se llama hoja a los nodos que no tienen hijos)\n" +
                "➡\uFE0F Por definición, se dice que la altura de una hoja es\n" +
                "siempre 1, ya que para llegar de ella a un nodo nulo sólo\n" +
                "hace falta referenciar un nodo (algunos de sus hijos nulos).\n" +
                "➡\uFE0F Los nodos nulos, por la misma razón, tienen una altura\n" +
                "de 0.\n" +
                "➡\uFE0F En todo árbol binario de búsqueda, la raíz es siempre\n" +
                "el nodo con mayor altura.\n" +
                "➡\uFE0F La altura de cualquier nodo debe ser igual o mayor que 0\n" +
                "(es decir, no hay alturas negativas).\n" +
                "(Presiona la tecla Enter para ver un ejemplo)");
        entrada.readLine();
        esperar(5);
    }

    public static void ejemploAltura() throws IOException {
        System.out.print("\nAnalicemos el mismo árbol desbalanceado del ejemplo\n" +
                "anterior \uD83D\uDC40\n" +
                "(Presiona la tecla Enter para visualizar el árbol \uD83C\uDF32)");
        entrada.readLine();
        ABB arbolEjemplo = new ABB();
        arbolEjemplo.insertar(10);
        arbolEjemplo.insertar(20);
        arbolEjemplo.insertar(30);
        arbolEjemplo.insertar(5);
        arbolEjemplo.insertar(25);
        arbolEjemplo.insertar(35);
        arbolEjemplo.insertar(15);
        for (int c = 2; c >= 0; --c) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Lo sentimos, sucedió algo inesperado.");
            }
            System.out.println((c + 1) + "...");
        }
        esperar(1);
        System.out.println("\n");
        arbolEjemplo.imprimirArbolPiramide();
        System.out.print("\n\nComo se puede ver, llegar a una hoja desde la raíz\n" +
                "implica un camino de sólo dos nodos si se hace\n" +
                "por la izquierda, mientras que por la derecha sería\n" +
                "de cuatro nodos. Como la altura del nodo es el camino\n" +
                "más largo que se puede seguir desde él hasta una hoja,\n" +
                "se puede concluir que la altura de la raíz del árbol es de 4.\n" +
                "(\uD83D\uDD0D Nota: al indicar la longitud de un camino en un ABB,\n" +
                "tanto el nodo inicial como el nodo final se toman en cuenta)\n" +
                "La altura del nodo 20 es de 3 y la del nodo 30 es 2.\n" +
                "La altura de los nodos 5, 15, 25 y 35, al ser todos\n" +
                "hojas, es de 1.\n" +
                "(Presiona la tecla Enter para practicar lo aprendido)");
        entrada.readLine();
        esperar(5);
    }

    public static void ejerciciosAltura() throws IOException {
        System.out.print("\n\n\uD83C\uDFCB\uFE0F Ejercicios de ABBs \uD83C\uDFCB\uFE0F\n\n" +
                "¿Estás list@ para unos ejercicios? \uD83D\uDC40\n" +
                "(Presiona la tecla Enter para comenzar)");
        entrada.readLine();
        ABB arbolEjercicios = new ABB();
        arbolEjercicios.insertar(70);
        arbolEjercicios.insertar(60);
        arbolEjercicios.insertar(90);
        arbolEjercicios.insertar(40);
        arbolEjercicios.insertar(80);
        arbolEjercicios.insertar(100);
        arbolEjercicios.insertar(85);
        for (int c = 2; c >= 0; --c) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Lo sentimos, sucedió algo inesperado.");
            }
            System.out.println((c + 1) + "...");
        }
        esperar(1);
        System.out.println("\n");
        arbolEjercicios.imprimirArbolPiramide();
        int respuesta;
        while (true) {
            System.out.print("\nPregunta 1: ¿Cuál de las siguientes llaves pertenece\n" +
                    "a un nodo de altura 1?\n\n" +
                    "1) 90\n" +
                    "2) 70\n" +
                    "3) 60\n\n" +
                    "Respuesta: ");
            respuesta = Integer.parseInt(entrada.readLine());
            if (respuesta == 3) {
                System.out.println("\n\n✔\uFE0F ¡Correcto!");
                break;
            } else {
                System.out.println("\n\n❌ Incorrecto. Piénsalo mejor...");
                esperar(3);
            }
        }
        System.out.println("\n");
        arbolEjercicios.imprimirArbolPiramide();
        while (true) {
            System.out.print("\nPregunta 2: ¿Cuál es la altura del nodo de llave 100?\n\n" +
                    "1) 1\n" +
                    "2) 0\n" +
                    "3) 2\n\n" +
                    "Respuesta: ");
            respuesta = Integer.parseInt(entrada.readLine());
            if (respuesta == 1) {
                System.out.println("\n\n✔\uFE0F ¡Correcto!");
                break;
            } else {
                System.out.println("\n\n❌ Incorrecto. Piénsalo mejor...");
                esperar(3);
            }
        }
        System.out.print("¡Excelente trabajo! \uD83D\uDCAF\n" +
                "(Presiona la tecla Enter para continuar aprendiendo)");
        entrada.readLine();
        esperar(5);
    }

    public static void explicarFB() throws IOException {
        System.out.print("\n\n\uD83D\uDCBB Factor de balance \uD83D\uDCBB\n\n" +
                "Ahora que conocemos el concepto de altura, podemos\n" +
                "definir el factor de balance. El FB de un nodo equivale a la\n" +
                "diferencia entre la altura de su hijo izquierdo y la de\n" +
                "su hijo derecho \uD83D\uDE04\n\n" +
                "FB = h_izquierda - h_derecha\n\n" +
                "Como se calcula mediante la resta de números que siempre son" +
                "(Presiona la tecla Enter para ver un ejemplo)");
        entrada.readLine();
        esperar(5);
    }

    public static void ejemploFB() throws IOException {
        System.out.print("\nVamos a construir un ABB con las siguientes llaves:\n" +
                "50, 20, 80, 15, 25, 90, 10 y 85.\n" +
                "(Presiona la tecla Enter para visualizar el árbol \uD83C\uDF32)");
        entrada.readLine();
        ABB arbolEjemplo = new ABB();
        arbolEjemplo.insertar(50);
        arbolEjemplo.insertar(20);
        arbolEjemplo.insertar(80);
        arbolEjemplo.insertar(15);
        arbolEjemplo.insertar(25);
        arbolEjemplo.insertar(90);
        arbolEjemplo.insertar(10);
        arbolEjemplo.insertar(85);
        for (int c = 2; c >= 0; --c) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Lo sentimos, sucedió algo inesperado.");
            }
            System.out.println((c + 1) + "...");
        }
        esperar(1);
        System.out.println("\n");
        arbolEjemplo.imprimirArbolPiramide();
        System.out.print("\n\nEn el árbol anterior, como la raíz tiene un hijo izquierdo\n" +
                "de altura 3 y un hijo derecho de altura 3, se puede decir que la raíz tiene\n" +
                "un FB de 0 (es decir, está perfectamente balanceado \uD83D\uDC4D)\n" +
                "El nodo de llave 80, por otra parte, tiene un FB de -2 (es decir, está\n" +
                "desbalanceado hacia la derecha), mientras que el de llave 15 tiene un FB\n" +
                "de 1 (desbalance izquierdo).\n" +
                "(Presiona la tecla Enter para practicar lo aprendido)");
        entrada.readLine();
        esperar(5);
    }

    public static void ejerciciosFB() throws IOException {
        System.out.print("\n\n\uD83C\uDFCB\uFE0F Ejercicios de FB \uD83C\uDFCB\uFE0F\n\n" +
                "¿Estás list@ para unos ejercicios? \uD83D\uDC40\n" +
                "(Presiona la tecla Enter para comenzar)");
        entrada.readLine();
        ABB arbolEjercicios = new ABB();
        arbolEjercicios.insertar(100);
        arbolEjercicios.insertar(50);
        arbolEjercicios.insertar(120);
        arbolEjercicios.insertar(40);
        arbolEjercicios.insertar(60);
        arbolEjercicios.insertar(150);
        arbolEjercicios.insertar(70);
        arbolEjercicios.insertar(130);
        for (int c = 2; c >= 0; --c) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Lo sentimos, sucedió algo inesperado.");
            }
            System.out.println((c + 1) + "...");
        }
        esperar(1);
        System.out.println("\n");
        arbolEjercicios.imprimirArbolPiramide();
        int respuesta;
        while (true) {
            System.out.print("\nPregunta 1: ¿Cuál es el FB del nodo de llave 50?\n\n" +
                    "1) 2\n" +
                    "2) -1\n" +
                    "3) 1\n\n" +
                    "Respuesta: ");
            respuesta = Integer.parseInt(entrada.readLine());
            if (respuesta == 2) {
                System.out.println("\n\n✔\uFE0F ¡Correcto!");
                break;
            } else {
                System.out.println("\n\n❌ Incorrecto. Piénsalo mejor...");
                esperar(3);
            }
        }
        System.out.println("\n");
        arbolEjercicios.imprimirArbolPiramide();
        while (true) {
            System.out.print("\nPregunta 2: ¿Cuál de los siguientes nodos está balanceado?\n\n" +
                    "1) El de llave 100\n" +
                    "2) El de llave 120\n" +
                    "3) El de llave 150\n\n" +
                    "Respuesta: ");
            respuesta = Integer.parseInt(entrada.readLine());
            if (respuesta == 1) {
                System.out.println("\n\n✔\uFE0F ¡Correcto!");
                break;
            } else {
                System.out.println("\n\n❌ Incorrecto. Piénsalo mejor...");
                esperar(3);
            }
        }
        System.out.print("¡Excelente trabajo! \uD83D\uDCAF\n" +
                "(Presiona la tecla Enter para continuar aprendiendo)");
        entrada.readLine();
        esperar(5);
    }

    public static void explicarAVL() throws IOException {
        System.out.print("\n\n\uD83D\uDCBB Regla de balance de un árbol AVL \uD83D\uDCBB\n\n" +
                "Conociendo ahora el concepto de FB, es posible terminar de\n" +
                "definir el árbol AVL. La característica principal de un\n" +
                "árbol AVL es que no permite ningún factor de balance menor\n" +
                "que -1 ni mayor que +1. En otras palabras, siempre que se\n" +
                "inserta o se elimina un nodo de dicha estructura, se debe\n" +
                "evaluar si los nodos desde la raíz hasta la posición afectada\n" +
                "están bien balanceados; si no lo están, se debe ejecutar una o\n" +
                "más rotaciones para corregir el desbalance del árbol ✏\uFE0F\n" +
                "(Presiona la tecla Enter para ver un ejemplo)");
        entrada.readLine();
        esperar(5);
    }

    public static void ejemploAVL() throws IOException {
        System.out.print("\nVamos a construir un ABB perfectamente balanceado con las siguientes llaves:\n" +
                "25, 12, 28, 6, 15, 26 y 30.\n" +
                "(Presiona la tecla Enter para visualizar el árbol \uD83C\uDF32)");
        entrada.readLine();
        ABB arbolEjemplo = new ABB();
        arbolEjemplo.insertar(25);
        arbolEjemplo.insertar(12);
        arbolEjemplo.insertar(28);
        arbolEjemplo.insertar(6);
        arbolEjemplo.insertar(15);
        arbolEjemplo.insertar(26);
        arbolEjemplo.insertar(30);
        for (int c = 2; c >= 0; --c) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Lo sentimos, sucedió algo inesperado.");
            }
            System.out.println((c + 1) + "...");
        }
        esperar(1);
        System.out.println("\n");
        arbolEjemplo.imprimirArbolPiramide();
        System.out.print("\n\nEl árbol anterior está perfectamente balanceado.\n" +
                "Sin embargo, si se inserta un nodo con llave 17, aparece un\n" +
                "pequeño desbalance \uD83D\uDE1E\n" +
                "(Presiona la tecla Enter para visualizar el árbol \uD83C\uDF32)");
        entrada.readLine();
        esperar(1);
        arbolEjemplo.insertar(17);
        System.out.println("\n");
        arbolEjemplo.imprimirArbolPiramide();
        System.out.print("\n\nSin embargo, el desbalance que hay en el árbol\n" +
                "de momento sigue siendo permitido (es decir, la raíz tiene un\n" +
                "desbalance de +1 y el nodo de llave 15 tiene un desbalance de\n" +
                "-1, pero ambos valores son permitidos) \uD83D\uDE01\n" +
                "No obstante, si se inserta además un nodo con llave 16...\n" +
                "(Presiona la tecla Enter para visualizar el árbol \uD83C\uDF32)");
        entrada.readLine();
        esperar(1);
        arbolEjemplo.insertar(16);
        System.out.println("\n");
        arbolEjemplo.imprimirArbolPiramide();
        System.out.print("\n\nAhora, la raíz del árbol y el nodo de llave 15 tienen\n" +
                "un desbalance no permitido \uD83D\uDE45 (de +2 y -2 respectivamente).\n" +
                "Será necesario aplicar rotaciones para corregir la estructura ♻\uFE0F\n" +
                "(Presiona la tecla Enter para practicar lo aprendido)");
        entrada.readLine();
        esperar(5);
    }

    public static void ejerciciosAVL() throws IOException {
        System.out.print("\n\n\uD83C\uDFCB\uFE0F Ejercicios de AVL \uD83C\uDFCB\uFE0F\n\n" +
                "¿Estás list@ para unos ejercicios? \uD83D\uDC40\n" +
                "(Presiona la tecla Enter para comenzar)");
        entrada.readLine();
        ABB arbolEjercicios = new ABB();
        arbolEjercicios.insertar(20);
        arbolEjercicios.insertar(5);
        arbolEjercicios.insertar(50);
        arbolEjercicios.insertar(10);
        arbolEjercicios.insertar(70);
        arbolEjercicios.insertar(60);
        for (int c = 2; c >= 0; --c) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Lo sentimos, sucedió algo inesperado.");
            }
            System.out.println((c + 1) + "...");
        }
        esperar(1);
        System.out.println("\n");
        arbolEjercicios.imprimirArbolPiramide();
        int respuesta;
        while (true) {
            System.out.print("\nPregunta 1: ¿Cuál es la llave de un nodo cuya inserción\n" +
                    "dejaría la estructura con un desbalance prohibido?\n\n" +
                    "1) 1\n" +
                    "2) 40\n" +
                    "3) 55\n\n" +
                    "Respuesta: ");
            respuesta = Integer.parseInt(entrada.readLine());
            if (respuesta == 3) {
                System.out.println("\n\n✔\uFE0F ¡Correcto!");
                break;
            } else {
                System.out.println("\n\n❌ Incorrecto. Piénsalo mejor...");
                esperar(3);
            }
        }
        System.out.println("\n");
        arbolEjercicios.imprimirArbolPiramide();
        while (true) {
            System.out.print("\nPregunta 2: ¿Cuál es la llave de un nodo cuya eliminación\n" +
                    "dejaría la estructura con un desbalance prohibido?\n\n" +
                    "1) El de llave 20\n" +
                    "2) El de llave 50\n" +
                    "3) El de llave 10\n\n" +
                    "Respuesta: ");
            respuesta = Integer.parseInt(entrada.readLine());
            if (respuesta == 3) {
                System.out.println("\n\n✔\uFE0F ¡Correcto!");
                break;
            } else {
                System.out.println("\n\n❌ Incorrecto. Piénsalo mejor...");
                esperar(3);
            }
        }
        System.out.print("¡Excelente trabajo! \uD83D\uDCAF\n" +
                "(Presiona la tecla Enter para continuar aprendiendo)");
        entrada.readLine();
        esperar(5);
    }

    public static void explicarRotaciones() throws IOException {
        System.out.print("\n\n\uD83D\uDCBB Rotaciones en un árbol AVL \uD83D\uDCBB\n\n" +
                "Una vez que se detecta un desbalance mayor al permitido,\n" +
                "la forma de corregir el defecto, como ya se indicó, consiste\n" +
                "en la realización de una o más rotaciones. Hay cuatro tipos\n" +
                "distintos de rotaciones que se puede llevar a cabo, debido a\n" +
                "que hay también cuatro formas distintas de desbalances que se\n" +
                "pueden presentar:\n\n" +
                "1) Desbalance izquierdo-izquierdo: hay un nodo desbalanceado\n" +
                "hacia la izquierda, cuyo hijo izquierdo también está desbalanceado\n" +
                "hacia la izquierda; es decir, el nodo tiene FB de +2 y su hijo izquierdo de +1.\n" +
                "Este tipo de desbalance se corrige con una rotación derecha sobre el\n" +
                "nodo en el que se detectó el desbalance prohibido originalmente ↩\uFE0F\n\n" +
                "(Presiona la tecla Enter para continuar leyendo)");
        entrada.readLine();
        esperar(1);
        System.out.print("\n2) Desbalance izquierdo-derecho: hay un nodo desbalanceado hacia\n" +
                "la izquierda, pero su hijo izquierdo está desbalanceado hacia la\n" +
                "derecha; es decir, el nodo tiene FB de +2 y su hijo izquierdo de -1.\n" +
                "Este tipo de desbalance se corrige con una rotación izquierda sobre el\n" +
                "hijo izquierdo del nodo en el que se detectó el desbalance prohibido\n" +
                "originalmente, seguida de una rotación derecha sobre el nodo en el que\n" +
                "se detectó el desbalance prohibido originalmente ↪\uFE0F↩\uFE0F\n\n" +
                "(Presiona la tecla Enter para continuar leyendo)");
        entrada.readLine();
        esperar(1);
        System.out.print("\n3) Desbalance derecho-izquierdo: hay un nodo desbalanceado hacia\n" +
                "la derecha, pero su hijo derecho está desbalanceado hacia la\n" +
                "la izquierda; es decir, el nodo tiene FB de -2 y su hijo derecho de +1.\n" +
                "Este tipo de desbalance se corrige con una rotación derecha sobre el\n" +
                "hijo derecho del nodo en el que se detectó el desbalance prohibido\n" +
                "originalmente, seguida de una rotación izquierda sobre el nodo en el que\n" +
                "se detectó el desbalance prohibido originalmente ↩\uFE0F↪\uFE0F\n\n" +
                "(Presiona la tecla Enter para continuar leyendo)");
        entrada.readLine();
        esperar(1);
        System.out.print("\n4) Desbalance derecho-derecho: hay un nodo desbalanceado\n" +
                "hacia la derecha, cuyo hijo derecho también está desbalanceado\n" +
                "hacia la derecha; es decir, el nodo tiene FB de -2 y su hijo derecho de -1.\n" +
                "Este tipo de desbalance se corrige con una rotación izquierda sobre el\n" +
                "nodo en el que se detectó el desbalance prohibido originalmente ↪\uFE0F\n\n" +
                "(Presiona la tecla Enter para ver un ejemplo de cada tipo de desbalance)");
        entrada.readLine();
        esperar(5);
    }
}