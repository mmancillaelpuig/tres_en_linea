import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        TUI tui = new TUI();
        Joc joc = new Joc();
        boolean sortir = false;

        while (!sortir) {
            tui.mostrarMenu();
            int opcio = tui.solicitarEntradaEntera("");
            switch (opcio) {
                case 1:
                    novaPartida(joc, tui);
                    break;
                case 2:
                    carregarPartida();
                    break;
                case 3:
                    configuracio(joc, tui);
                    break;
                case 4:
                    tui.mostrarMissatge("Sortint del joc...");
                    tui.tancar();
                    sortir = true;
                    break;
                default:
                    tui.mostrarMissatge("Opció no vàlida, torna a intentar-ho.");
            }
        }
    }

    public static void novaPartida(Joc joc, TUI tui) {
        joc.inicialitzarTaulell();
        boolean continuar = true;
        char jugadorActual = 'X';
        while (continuar) {
            tui.mostrarTaulell(joc.getTaulell());
            boolean jugadaValida = false;
            while (!jugadaValida) {
                int[] jugada = tui.recollirJugada(joc);
                if (joc.jugar(jugada[0], jugada[1], jugadorActual)) {
                    jugadaValida = true;
                    for (int fila = 0; fila < joc.getMidaTaulell(); fila++){
                        for (int columna = 0; columna < joc.getMidaTaulell(); columna++){
                            if (joc.jugadaGuanyadora(jugada[0], jugada[1], jugadorActual)) {
                                tui.mostrarTaulell(joc.getTaulell());
                                tui.mostrarMissatge("El jugador " + jugadorActual + " ha guanyat!");
                                continuar = false;
                            } else {
                                jugadorActual = (jugadorActual == 'X') ? 'O' : 'X';
                            }
                        }
                    }


                } else {
                    tui.mostrarMissatge("Posició ocupada. Tria una altra posició.");
                }
            }
        }
    }


    public static void carregarPartida() {

    }

    public static void configuracio(Joc joc, TUI tui) {
        int midaActual = joc.getTaulell().length;
        tui.mostrarMissatge("Configurant mida del taulell. Actual mida: " + midaActual);
        int novaMida = tui.solicitarEntradaEntera("Introdueix la nova mida del taulell (entre 3 y 10):");
        if (novaMida >= 3 && novaMida <= 10) {
            joc.setMidaTaulell((short) novaMida);
            tui.mostrarMissatge("Nova mida establerta: " + novaMida);
        } else {
            tui.mostrarMissatge("La mida introduïda no és vàlida. S'ha de mantenir entre 3 i 10.");
            configuracio(joc,tui);
        }
    }
}
