import java.util.Scanner;

public class TUI {
    private final Scanner sc = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("Benvingut al tres en línia! Escull una de les següents opcions per a continuar:\n1.Nova Partida\n2.Carregar Partida" +
                "\n3.Configuració\n4.Sortir");

        return this.sc.nextInt();
    }

    public void mostrarTaulell(char[][] taulell) {
        for (int fila = 0; fila < taulell.length; fila++) {
            for (int columna = 0; columna < taulell[fila].length; columna++) {
                System.out.print(taulell[fila][columna] +" ");
            }
            System.out.println();
        }
    }
    public void iniciarPartida(){
        System.out.println("Iniciant partida...");
    }
    public  void accedirConfig(Scanner sc, TUI tui, Joc j){
        System.out.println("Accedint a la configuració...");
        Main.configuracio(sc,tui,j);
    }
    public  void carregarPartida(){
        System.out.println("Carregant partida...");
    }
    public  void exit(){
        System.out.println("Sortint...");
        System.exit(0);
    }
}
