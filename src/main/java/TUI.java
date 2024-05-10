import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TUI {
    private Scanner sc;

    public TUI() {
        this.sc = new Scanner(System.in);
    }

    public int solicitarEntradaEntera(String mensaje) {
        System.out.println(mensaje);
        return sc.nextInt();
    }

    public void mostrarMenu() {
        System.out.println("Benvingut al tres en línia! Escull una de les següents opcions per a continuar:\n" +
                "1. Nova Partida\n" +
                "2. Carregar Partida\n" +
                "3. Configuració\n" +
                "4. Sortir");
    }

    public void mostrarTaulell(char[][] taulell) {
        for (char[] fila : taulell) {
            for (char c : fila) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    public int[] recollirJugada(Joc j) {
        System.out.println("\nIntrodueix la fila i la columna:");
        int fila = sc.nextInt();
        int columna = sc.nextInt();
        if (fila >= j.getMidaTaulell() || columna >= j.getMidaTaulell()) {
            System.out.println("Entrada no vàlida, torna a provar");
            return recollirJugada(j); //recursivitat per tornar a preguntar les dades

        } else if (fila == -1 && columna == -1) {
            System.out.println("Guardant i sortint del joc...");
            j.gravarPartida(j);
            mostrarMenu();
        }
        return new int[]{fila, columna};
    }



    public void mostrarMissatge(String missatge) {
        System.out.println(missatge);
    }

    public void tancar() {
        sc.close();
    }
}
