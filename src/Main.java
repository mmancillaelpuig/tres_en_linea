import  java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Benvingut al tres en línia! Escull una de les següents opcions per a continuar:\n1.Nova Partida\n2.Carregar Partida" +
                "\n3.Configuració\n4.Sortir");

        int start = sc.nextInt();

        switch (start){
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            case 3:
                System.out.println("3");
                break;
            case 4:
                sc.close();
                break;
            default:
                System.out.println("No es una opció correcta, torna de nou");
        }



    }
}