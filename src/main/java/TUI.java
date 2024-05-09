import java.util.Scanner;

public class TUI {
    Scanner sc = new Scanner(System.in);
    public int mostrarMenu() {
            saludo();
            int start = sc.nextInt();
            sc.nextLine();
            return start;
    }
    public void saludo(){
        System.out.println("Benvingut al tres en línia! Escull una de les següents opcions per a continuar:\n1.Nova Partida\n2.Carregar Partida" +
                "\n3.Configuració\n4.Sortir");
    }
    public  void mostrarTaulell(Joc j) {
        char[][] taulell = j.getTaulell();
        for (int i = 0; i < taulell.length; i++) {
            for (int columna= 0; columna < taulell[i].length; columna++) {
                System.out.print(taulell[i][columna] + " ");
            }
            System.out.println();
        }
    }
    public  void iniciarPartida(){
        System.out.println("Iniciant partida...");
        Joc j = new Joc();
        j.novaPartida();
    }
    public  void accedirConfig(Scanner sc, TUI tui, Joc j){
        System.out.println("Accedint a la configuració...");
    }
    public  void carregarPartida(){
        System.out.println("Carregant partida...");
    }
    public  void exit(){
        System.out.println("Sortint...");
        System.exit(0);
    }
}
