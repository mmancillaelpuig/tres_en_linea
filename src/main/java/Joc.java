import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.Scanner;

public class Joc {
    public char[][] getTaulell() {
        return taulell;
    }

    private char[][] taulell;
    private short torn;

    public short getTorn() {
        return torn;
    }

    public void setTorn(short torn) {
        this.torn = torn;
    }

    public Joc(){
        novaPartida();
    }

    public void carregarPartida(String filePath){
        //Llegir fitxer
        //modificar this.taulell
        //*modificar this.torn
    }

    public void novaPartida() {
        //Llegir mida del fitxer de config
        int mida = 3;   //mida default
        this.taulell = new char[mida][mida];
        this.torn = 1;

        for (int i = 0; i < this.taulell.length; i++){
            for (int j = 0; j < this.taulell[i].length; j++){
                this.taulell[i][j] = '_';
            }
        }
    }

    public boolean jugar(int fila, int columna) {
        if (this.taulell[fila][columna] == '_') {
            this.taulell[fila][columna] = (this.torn == 1 ? 'X' : 'O');
            this.torn = (this.torn == 1 ? (short)2 : (short)1);
            return true;
        } else {
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