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
        //Comprovar linea recta
            for (int i = 0; i < midaTaulell; i++) {
                for (int j = 0; j < midaTaulell - 2; j++) {
                    if (taulell[i][j] == jugador && taulell[i][j + 1] == jugador && taulell[i][j + 2] == jugador) {
                        return true;
                    }
                }
            }

            // Comprovar columna
            for (int i = 0; i < midaTaulell - 2; i++) {
                for (int j = 0; j < midaTaulell; j++) {
                    if (taulell[i][j] == jugador && taulell[i + 1][j] == jugador && taulell[i + 2][j] == jugador) {
                        return true;
                    }
                }
            }

            //Comprovar diagonal
            for (int i = 0; i < midaTaulell - 2; i++) {
                for (int j = 0; j < midaTaulell - 2; j++) {
                    if (taulell[i][j] == jugador && taulell[i + 1][j + 1] == jugador && taulell[i + 2][j + 2] == jugador) {
                        return true;
                    }
                }
            }

            //Comprovar diagonal 2
            for (int i = 0; i < midaTaulell - 2; i++) {
                for (int j = 2; j < midaTaulell; j++) {
                    if (taulell[i][j] == jugador && taulell[i + 1][j - 1] == jugador && taulell[i + 2][j - 2] == jugador) {
                        return true;
                    }
                }
            }

            return false;
        }


        public boolean jugadaEmpate(int fila, int columna, char jugador){
        for (int i = 0; i < getMidaTaulell(); i++){
            for (int j = 0; j < getMidaTaulell(); j++){
                if (taulell[i][j] != '_' && taulell[i + 1][j] != '_' && taulell[i + 2][j] != '_' && taulell[i][j + 1] != '_' && taulell[i][j + 2] != '_'){
                    return true;
                } else {
                    return false;
                }
            }
        } return false;
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