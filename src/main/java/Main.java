import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
                    carregarPartida(joc, tui);
                    break;
                case 3:
                    eliminarPartida(tui);
                    break;

                case 4:
                    configuracio(joc, tui);
                    break;
                case 5:
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
        tui.mostrarTaulell(joc.getTaulell());
        while (continuar) {
            if (jugadorActual == 'O') {//torn de la IA
                int[] movimentIA = joc.decidirMovimentIA();
                joc.jugar(movimentIA[0], movimentIA[1], 'O');
                tui.mostrarTaulell(joc.getTaulell());
                if (joc.jugadaGuanyadora(movimentIA[0], movimentIA[1], 'O')) {
                    tui.mostrarMissatge("La IA ha guanyat!");
                    break;
                }
            } else { //torn del jugador
                int[] jugada = tui.recollirJugada(joc);
                boolean jugadaValida = joc.jugar(jugada[0], jugada[1], jugadorActual);
                if (!jugadaValida) {
                    tui.mostrarMissatge("Posició ocupada o entrada no vàlida. Tria una altra posició.");
                    continue;
                }
                if (joc.jugadaGuanyadora(jugada[0], jugada[1], jugadorActual)) {
                    tui.mostrarTaulell(joc.getTaulell());
                    tui.mostrarMissatge("El jugador " + jugadorActual + " ha guanyat!");
                    break;
                }
            }
            if (joc.taulellPle()) {
                tui.mostrarMissatge("Empat!");
                break;
            }
            jugadorActual = (jugadorActual == 'X') ? 'O' : 'X';
        }
    }



    public static void carregarPartida(Joc joc, TUI tui) {
        File dir = new File("savedgames");
        File[] arxiu = dir.listFiles();
        if (arxiu == null || arxiu.length == 0) {
            tui.mostrarMissatge("No hi ha cap partida guardada.");
            return;
        }

        tui.mostrarMissatge("Selecciona una partida per carregar:\n");
        for (int i = 0; i < arxiu.length; i++) {
            tui.mostrarMissatge((i + 1) + ": " + arxiu[i].getName());
        }

        int eleccio = tui.solicitarEntradaEntera("\nIntrodueix el número de la partida: ") - 1;
        if (eleccio < 0 || eleccio >= arxiu.length) {
            tui.mostrarMissatge("Selecció no vàlida.");
            return;
        }
        File arxiuSeleccionat = arxiu[eleccio];
        try (Scanner sc = new Scanner(arxiuSeleccionat)) {
            int tamany = sc.nextInt();
            sc.nextLine();
            joc.setMidaTaulell((short) tamany);

            short torn = sc.nextShort();
            sc.nextLine();
            joc.setTorn(torn);


            char[][] nouTaulell = new char[joc.getMidaTaulell()][joc.getMidaTaulell()];
            for (int i = 0; i < joc.getMidaTaulell(); i++) {
                if (sc.hasNextLine()) {
                    String linea = sc.nextLine();
                    nouTaulell[i] = linea.replaceAll("[\\[\\], ]", "").toCharArray();
                } else {
                    tui.mostrarMissatge("Error: L'arxiu no conté suficients línies per obrir el fitxer.");
                    return;
                }
            }

            joc.setTaulell(nouTaulell);
            partidaCarregada(joc, tui);

        } catch (FileNotFoundException e) {
            tui.mostrarMissatge("Arxiu no trobat: " + e.getMessage());
        } catch (Exception e) {
            tui.mostrarMissatge("Error al carregar la partida: " + e.toString());
        }

    }

    public static void partidaCarregada(Joc joc, TUI tui) {
        boolean continuar = true;
        char jugadorActual = joc.getTorn() % 2 == 0 ? 'O' : 'X'; //determinem proper jugador basats en el torn

        while (continuar) {
            tui.mostrarTaulell(joc.getTaulell());
            int[] jugada = tui.recollirJugada(joc);

            if (jugada[0] == -1 && jugada[1] == -1) {
                tui.mostrarMissatge("Guardant y sortint del joc...");
                joc.gravarPartida(joc);
                return;
            }

            boolean jugadaValida = joc.jugar(jugada[0], jugada[1], jugadorActual);
            if (!jugadaValida) {
                tui.mostrarMissatge("Posición ocupada o entrada no válida. Tria un altre posició.");
                continue;
            }

            if (joc.jugadaGuanyadora(jugada[0], jugada[1], jugadorActual)) {
                tui.mostrarTaulell(joc.getTaulell());
                tui.mostrarMissatge("El jugador " + jugadorActual + " ha guanyat!");
                continuar = false;
            } else if (joc.jugadaEmpat(jugada[0], jugada[1], jugadorActual)) {
                tui.mostrarMissatge("¡¡Empat!!");
                continuar = false;
            } else {
                jugadorActual = jugadorActual == 'X' ? 'O' : 'X';
                joc.setTorn((short) (joc.getTorn() + 1));
            }
        }
    }

    public static void eliminarPartida(TUI tui){
        File dir = new File("savedgames");
        File[] arxiu = dir.listFiles();
        if (arxiu == null || arxiu.length == 0) {
            tui.mostrarMissatge("No hi ha cap partida guardada.");
            return;
        }

        tui.mostrarMissatge("Selecciona la partida que vols eliminar:\n");
        for (int i = 0; i < arxiu.length; i++) {
            tui.mostrarMissatge((i + 1) + ": " + arxiu[i].getName());
        }

        int eleccio = tui.solicitarEntradaEntera("\nIntrodueix el número de la partida: ") - 1;
        if (eleccio < 0 || eleccio >= arxiu.length) {
            tui.mostrarMissatge("Selecció no vàlida.");
            return;
        }

        arxiu[eleccio].delete();

        tui.mostrarMissatge("Has esborrat l'arxiu: " + (eleccio + 1));


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
            configuracio(joc, tui);
        }
    }
}
