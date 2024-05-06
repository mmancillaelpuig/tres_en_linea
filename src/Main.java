import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TUI tui = new TUI();
        tui.mostrarMenu();

        int opcio = sc.nextInt();
        switch (opcio) {
            case 1:
                novaPartida();
                break;
                case 2:
                    carregarPartida();
                    break;
                case 3:
                    configuracio();
                    break;
                case 4:
                    sortir();
                    break;
                default:
                    System.out.println("No es una opció correcta, torna de nou!");
                    tui.mostrarMenu();
            }

    }

    public static void novaPartida(){
        throw new NotImplementedException();
    }

    public static void carregarPartida(){
        throw new NotImplementedException();
    }

    public static void configuracio(){
        throw new NotImplementedException();
    }

    public static void sortir(){
        System.exit(0);
    }
}
