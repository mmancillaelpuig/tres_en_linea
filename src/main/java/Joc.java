import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.Scanner;

public class Joc {
    public char[][] getTaulell() {
        return taulell;
    }

    private char[][] taulell;
    private short torn;
    private short midaTaulell;

    public short getTorn() {
        return torn;
    }
    public short getMidaTaulell(){return midaTaulell;}

    public void setMidaTaulell(short midaTaulell) {
        this.midaTaulell = midaTaulell;
    }

    public void setTorn(short torn) {
        this.torn = torn;
    }

    public Joc(){
        this.midaTaulell = 3;
        this.taulell = new char[midaTaulell][midaTaulell];
            for (int i = 0; i < midaTaulell; i++){
                for (int j = 0; j < midaTaulell; j++){
                    this.taulell[i][j] = '_';
                }
            }

        this.torn = 1;
    }

    public Joc(char[][] taulellInici, short torn1) {
        this.taulell = taulellInici;
        this.torn = torn1;
    }

    public void novaPartida(Scanner sc, TUI tui, Joc j) {
        tui.mostrarTaulell(j);
        System.out.println("És el torn del jugador: "+ torn);
        jugar(sc.nextInt(), sc.nextInt(), sc.next().charAt(0), sc, tui, j);
    }

    public boolean jugar(int fila, int columna, char jugador, Scanner sc, TUI tui, Joc j) {

            if (getTaulell()[fila][columna] == '_') {
                getTaulell()[fila][columna] = jugador;
                tui.mostrarTaulell(j);
                if (getTorn() == (short) 1){
                    setTorn((short) 2);
                    System.out.println("Torn del jugador " + getTorn());
                } else {
                    setTorn((short) 1);
                    System.out.println("Torn del jugador " + getTorn());
                }
                jugar(sc.nextInt(), sc.nextInt(), sc.next().charAt(0), sc, tui, j);

                return true;
            } else {
                System.out.println("Posicio ocupada, torna de nou!");
                jugar(sc.nextInt(), sc.nextInt(), sc.next().charAt(0), sc, tui, j);
                return false;
            }
    }



    public boolean jugadaGuanyadora(int fila, int columna, char jugador) {
        char original = taulell[fila][columna];
        if (original != ' ') return false;
        taulell[fila][columna] = jugador;

        boolean ganadora = (taulell[fila][0] == jugador && taulell[fila][1] == jugador && taulell[fila][2] == jugador)
                || (taulell[0][columna] == jugador && taulell[1][columna] == jugador && taulell[2][columna] == jugador)
                || (fila == columna && taulell[0][0] == jugador && taulell[1][1] == jugador && taulell[2][2] == jugador)
                || (fila + columna == 2 && taulell[0][2] == jugador && taulell[1][1] == jugador && taulell[2][0] == jugador);

        taulell[fila][columna] = original;

        if (ganadora){
            System.out.println("Has guanyat!!");
        }

        return ganadora;
    }
}