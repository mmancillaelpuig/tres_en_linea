import java.util.Scanner;

public class TUI {
    public static void mostrarMenu(Scanner sc) {
        boolean exit = false;

        while (!exit) {
            System.out.println("Benvingut al tres en línia! Escull una de les següents opcions per a continuar:\n1.Nova Partida\n2.Carregar Partida" +
                    "\n3.Configuració\n4.Sortir");

            int start = sc.nextInt();
            switch (start) {
                case 1:
                    System.out.println("Iniciant partida...");
                    exit = true;
                    break;
                case 2:
                    System.out.println("Carregant partida...");
                    exit = true;
                    break;
                case 3:
                    System.out.println("Accedint a la configuració...");
                    exit = true;
                    break;
                case 4:
                    exit();
                    break;
                default:
                    System.out.println("No es una opció correcta, torna de nou!");
                    break;
            }

        }
    }
    public static void iniciarPartida(Scanner sc){


    }

    public static void carregarPartida(Scanner sc){
        System.out.println("Carregant partida...");
    }

    public static void exit(){
        System.out.println("Sortint...");
        System.exit(0);
    }
}
