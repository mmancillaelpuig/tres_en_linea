import java.util.Scanner;

public class TUI {
    public  void mostrarMenu(Scanner sc) {
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
                    accedirConfig();
                    exit = true;
                    break;
                case 4:
                    exit();
                default:
                    System.out.println("No es una opció correcta, torna de nou!");
                    mostrarMenu(sc);
            }
        }
    }
    public static void saludo(){
        System.out.println("Benvingut al tres en línia! Escull una de les següents opcions per a continuar:\n1.Nova Partida\n2.Carregar Partida" +
                "\n3.Configuració\n4.Sortir");
    }
    public static void iniciarPartida(){
        System.out.println("Iniciant partida...");
    }
    public static void accedirConfig(){
        System.out.println("Accedint a la configuració...");
    }
    public static void carregarPartida(){
        System.out.println("Carregant partida...");
    }
    public static void exit(){
        System.out.println("Sortint...");
        System.exit(0);
    }
}
