import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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


    public boolean jugadaEmpate(int fila, int columna, char jugador) {
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

    public void gravarPartida(Joc j)  {
        // mirar si existe el directorio
        // si no existe crearlo
        // crear un fichero y guardar la partida
        boolean result = false;
        File file = new File("savedgames");

        if ((file.exists())) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
            String data = dateFormat.format(new Date());

            String nomFitxer = data + ".txt";
            File partidaGuardada = new File(file, nomFitxer);

            FileWriter myWriter = null;
            try {
                myWriter = new FileWriter(partidaGuardada);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                myWriter.write(j.getTorn());
                myWriter.write(Arrays.deepToString(j.getTaulell()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

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