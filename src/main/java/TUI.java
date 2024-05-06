import java.util.Scanner;

public class TUI {
    public  void mostrarMenu(Scanner sc, TUI tui) {
        boolean exit = false;

        while (!exit) {
            saludo();
            int start = sc.nextInt();
            switch (start) {
                case 1:
                    iniciarPartida();
                    exit = true;
                    break;
                case 2:
                   carregarPartida();
                    exit = true;
                    break;
                case 3:
                    accedirConfig(sc, tui);
                    exit = true;
                    break;
                case 4:
                    exit();
                default:
                    System.out.println("No es una opció correcta, torna de nou!");
            }
        }
    }
    public static void saludo(){
        System.out.println("Benvingut al tres en línia! Escull una de les següents opcions per a continuar:\n1.Nova Partida\n2.Carregar Partida" +
                "\n3.Configuració\n4.Sortir");
    }
    public static void mostrarTaulell() {
        Joc j = new Joc();
        char[][] taulell = j.getTaulell();

        for (int fila = 0; fila < taulell.length; fila++) {
            for (int columna = 0; columna < taulell[fila].length; columna++) {
                System.out.print(taulell[fila][columna] +"_");
            }
            System.out.println();
        }
    }
    public static void iniciarPartida(){
        System.out.println("Iniciant partida...");
        Joc j = new Joc();
        j.novaPartida();
    }
    public static void accedirConfig(Scanner sc, TUI tui){
        System.out.println("Accedint a la configuració...");
        Main.configuracio(sc,tui);
    }
    public static void carregarPartida(){
        System.out.println("Carregant partida...");
    }
    public static void exit(){
        System.out.println("Sortint...");
        System.exit(0);
    }
}
