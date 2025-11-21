import ui.PasosJuego;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        //Introducción.
        PasosJuego.intro();

        PasosJuego.espacio();

        //Etapa 1: Explicación del ABB.
        PasosJuego.explicarABB();

        PasosJuego.ejemploABB();

        PasosJuego.espacio();

        //Etapa 2: Explicación del desbalance.
        PasosJuego.explicarDesbalance();
    }
}