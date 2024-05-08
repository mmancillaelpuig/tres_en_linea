public class Joc {
    private char[][] taulell;
    private short torn;
    private short midaTaulell;

    public Joc() {
        this.midaTaulell = 3;
        this.taulell = new char[midaTaulell][midaTaulell];
        novaPartida();
    }

    public void novaPartida() {
        for (int i = 0; i < midaTaulell; i++) {
            for (int j = 0; j < midaTaulell; j++) {
                taulell[i][j] = '_';
            }
        }
        this.torn = 1;
    }

    public void inicialitzarTaulell() {
        for (int i = 0; i < midaTaulell; i++) {
            for (int j = 0; j < midaTaulell; j++) {
                taulell[i][j] = '_';
            }
        }
    }

    public boolean jugar(int fila, int columna, char simbol) {
        if (taulell[fila][columna] == '_') {
            taulell[fila][columna] = simbol;
            return true;
        }
        return false;
    }

    public boolean jugadaGuanyadora(int fila, int columna, char jugador) {
        boolean rows = true, columns = true, diagonal1 = true, diagonal2 = true;
        for (int i = 0; i < midaTaulell; i++) {
            if (taulell[i][columna] != jugador) columns = false;
            if (taulell[fila][i] != jugador) rows = false;
            if (taulell[i][i] != jugador) diagonal1 = false;
            if (taulell[i][midaTaulell - i - 1] != jugador) diagonal2 = false;
        }
        return rows || columns || diagonal1 || diagonal2;
    }

    public void setMidaTaulell(short mida) {
        if (mida >= 3 && mida <= 10) {
            this.midaTaulell = mida;
            taulell = new char[mida][mida];
            inicialitzarTaulell();
        }

    }
    public char[][] getTaulell() {
        return taulell;
    }

    public short getMidaTaulell() {
        return midaTaulell;
    }

    public short getTorn() {
        return torn;
    }

    public void setTorn(short torn) {
        this.torn = torn;
    }
}
