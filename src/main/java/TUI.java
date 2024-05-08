import java.util.Scanner;

public class TUI {
    private Scanner scanner;

    public TUI() {
        this.scanner = new Scanner(System.in);
    }

    public int solicitarEntradaEntera(String mensaje) {
        System.out.println(mensaje);
        return scanner.nextInt();
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
    public int[] recollirJugada() {
        System.out.println("\nIntrodueix la fila i la columna:");
        int fila = scanner.nextInt();
        int columna = scanner.nextInt();
        return new int[]{fila, columna};
    }

    public void mostrarMissatge(String missatge) {
        System.out.println(missatge);
    }

    public void tancar() {
        scanner.close();
    }
}
