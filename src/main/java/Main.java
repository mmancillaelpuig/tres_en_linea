import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Joc j = new Joc();
        TUI tui = new TUI();

        menu:
        while (true) {
            int opcio = tui.mostrarMenu();
            switch (opcio) {
                case 1:
                    novaPartida(tui, j);
                    break;
                case 2:
                    carregarPartida();
                    break;
                case 3:
                    configuracio(sc, tui, j);
                    break;
                case 4:
                    break menu;
                default:
                    System.out.println("No es una opció correcta, torna de nou!");
                    tui.mostrarMenu(sc, tui, j);
            }
        }
    }

    public static void novaPartida(TUI tui, Joc j){
        tui.iniciarPartida();
        j.novaPartida();
        tui.mostrarTaulell(j.getTaulell());
        //demanar jugada a TUI del J1
        //enviar jugada a joc
        //demanar jugada a TUI del J2
        //enviar jugada a joc
        //demanar jugada a TUI del J1
        //enviar jugada a joc
        //demanar jugada a TUI del J2
        //enviar jugada a joc
        //BUCLE!!! fins que acabi la artida
    }

    public static void carregarPartida(){
        throw new NotImplementedException();
    }

    public static void configuracio(Scanner sc, TUI tui, Joc j){
        System.out.println("Configuració:\n1.La mida predeterminada és: " + j.getMidaTaulell() + "(La mida del taulell ha ser entre 3 i 10)\nVols modificar la mida del taulell?\n1.Si\n2.No");
        int configEdit = sc.nextInt();

        if (configEdit == 1){
            System.out.println("Mida desitjada?");
            int novaMida = sc.nextInt();
            if (novaMida > 10 || novaMida < 3){
                System.out.println("Aquests valors no son correctes! Només pot ser entre 3 i 10");
                configuracio(sc, tui,j);
            } else {
                j.setMidaTaulell((short)novaMida);
                System.out.println("La nova mida és:" + j.getMidaTaulell());
                System.out.println("Tornant al menú...");
                tui.mostrarMenu(sc, tui,j);
            }
        } else if (configEdit == 2) {
            System.out.println("Tornant a menú principal");
            tui.mostrarMenu(sc, tui,j);

        }
    }

}
