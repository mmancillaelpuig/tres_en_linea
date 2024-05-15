import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

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


    public boolean jugadaEmpat(int fila, int columna, char jugador) {
        for (int i = 0; i < getMidaTaulell(); i++) {
            for (int j = 0; j < getMidaTaulell(); j++) {
                if (taulell[i][j] != '_' && taulell[i + 1][j] != '_' && taulell[i + 2][j] != '_' && taulell[i][j + 1] != '_' && taulell[i][j + 2] != '_') {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public void gravarPartida(Joc j) {
        File file = new File("savedgames");

        if (!file.exists()) {
            file.mkdir();
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String data = dateFormat.format(new Date());
        String nomFitxer = data + ".txt";
        File partidaGuardada = new File(file, nomFitxer);

        try (FileWriter fw = new FileWriter(partidaGuardada)) {
            fw.write(getMidaTaulell() + "\n");
            fw.write(getTorn() + "\n");
            for (char[] fila : j.getTaulell()) {
                fw.write(Arrays.toString(fila) + "\n");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void setMidaTaulell(short mida) {
        if (mida >= 3 && mida <= 10) {
            this.midaTaulell = mida;
            taulell = new char[mida][mida];
            inicialitzarTaulell();
        }

    }
    public int minimax(int profundidad, boolean esMaximizador) {
        int puntuacion = evaluarTaulell();

        //casos base: victoria, derrota o empat
        if (puntuacion == 10) return puntuacion;
        if (puntuacion == -10) return puntuacion;
        if (taulellPle()) return 0;

        if (esMaximizador) {
            int mejorPuntuacion = -1000;
            for (int i = 0; i < midaTaulell; i++) {
                for (int j = 0; j < midaTaulell; j++) {
                    if (taulell[i][j] == '_') {
                        taulell[i][j] = 'O';
                        mejorPuntuacion = Math.max(mejorPuntuacion, minimax(profundidad + 1, false));
                        taulell[i][j] = '_';
                    }
                }
            }
            return mejorPuntuacion;
        } else {
            int peorPuntuacion = 1000;
            for (int i = 0; i < midaTaulell; i++) {
                for (int j = 0; j < midaTaulell; j++) {
                    if (taulell[i][j] == '_') {
                        taulell[i][j] = 'X';
                        peorPuntuacion = Math.min(peorPuntuacion, minimax(profundidad + 1, true));
                        taulell[i][j] = '_';
                    }
                }
            }
            return peorPuntuacion;
        }
    }

    public boolean taulellPle() {
        for (int i = 0; i < midaTaulell; i++) {
            for (int j = 0; j < midaTaulell; j++) {
                if (taulell[i][j] == '_') {
                    return false;
                }
            }
        }
        return true;
    }



    public int evaluarTaulell() {
        for (int i = 0; i < midaTaulell; i++) {
            if (totsIguals(i, 0, 0, 1)) {
                return valor(taulell[i][0]);
            }
            if (totsIguals(0, i, 1, 0)) {
                return valor(taulell[0][i]);
            }
        }

        if (totsIguals(0, 0, 1, 1)) {
            return valor(taulell[0][0]);
        }
        if (totsIguals(0, midaTaulell - 1, 1, -1)) {
            return valor(taulell[0][midaTaulell - 1]);
        }

        return 0;
    }

    private boolean totsIguals(int iniciFila, int iniciColumna, int pasFila, int pasColumna) {
        char primer = taulell[iniciFila][iniciColumna];
        if (primer == ' ') {
            return false;
        }
        int x = iniciFila;
        int y = iniciColumna;
        for (int i = 1; i < midaTaulell; i++) {
            x += pasFila;
            y += pasColumna;
            if (taulell[x][y] != primer) {
                return false;
            }
        }
        return true;
    }
    private int valor(char jugador) {
        if (jugador == 'O') return +10;
        if (jugador == 'X') return -10;
        return 0;
    }


    public int[] decidirMovimentIA() {
        int millorPuntuacio = Integer.MIN_VALUE;
        int[] millorMoviment = new int[]{-1, -1};

        for (int i = 0; i < midaTaulell; i++) {
            for (int j = 0; j < midaTaulell; j++) {
                if (taulell[i][j] == '_') {
                    taulell[i][j] = 'O';
                    int puntuacioMoviment = minimax(0, false);
                    taulell[i][j] = '_';
                    if (puntuacioMoviment > millorPuntuacio) {
                        millorPuntuacio = puntuacioMoviment;
                        millorMoviment[0] = i;
                        millorMoviment[1] = j;
                    }
                }
            }
        }
        return millorMoviment;
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

    public void setTaulell(char[][] taulell) {
        this.taulell = taulell;
    }
}