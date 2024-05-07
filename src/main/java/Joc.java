import sun.reflect.generics.reflectiveObjects.NotImplementedException;

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

    public Joc(){
        this.midaTaulell = 3;
        this.taulell = new char[midaTaulell][midaTaulell];
            for (int i = 0; i < midaTaulell; i++){
                for (int j = 0; j < midaTaulell; j++){
                    this.taulell[i][j] = ' ';
                }
            }

        this.torn = 1;
    }

    public Joc(char[][] taulellInici, short torn1) {
        this.taulell = taulellInici;
        this.torn = torn1;
    }

    public void novaPartida() {
        TUI.mostrarTaulell();
        System.out.println("És el torn del jugador: "+ torn);
    }

    public boolean jugar(int fila, int columna, char jugador) {

        throw new NotImplementedException();
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

        return ganadora;
    }
}