import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class JocTest {

    @Test
    void novaPartida_jugador() {
        Joc j = new Joc();
        short torn1 = 1;

        j.novaPartida();

        Assertions.assertEquals(j.getTorn(), torn1);
    }

    @Test
    void novaPartida_taulell() {
        Joc j = new Joc();
        j.novaPartida();
        char[][] taulellBuit = new char[][]{
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}};
        Assertions.assertArrayEquals(j.getTaulell(), taulellBuit);

    }

    @Test
    void jugadaGuanyadoraTaulellBuit() {
        char[][] taulellBuit = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };

        Joc j = new Joc(taulellBuit, (short) 1);

        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 0; columna < 3; columna++) {
                Assertions.assertFalse((j.jugadaGuanyadora(fila, columna, 'x')));
            }
        }
    }

    @Test
    void jugadaGuanyadoraUnaCasella() {
        char[][] taulellUnaCasella = {
                {'x', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '},
        };

        Joc j = new Joc(taulellUnaCasella, (short) 1);

        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 0; columna < 3; columna++) {
                Assertions.assertFalse((j.jugadaGuanyadora(fila, columna, 'x')));
            }
        }
    }

    @Test
    void jugadaGuanyadoraJugador1Guanya() {
        char[][] taulellGuanya1 = {
                {'x', 'x', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '},
        };

        Joc j = new Joc(taulellGuanya1, (short) 1);
        Assertions.assertTrue(j.jugadaGuanyadora(0,2,'x'));
    }
    @Test
    void jugadaGuanyadoraJugador2Guanya() {
        char[][] taulellGuanya2 = {
                {'o', 'o', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '},
        };

        Joc j = new Joc(taulellGuanya2, (short) 2);
        Assertions.assertTrue(j.jugadaGuanyadora(0,2,'o'));
    }

    @Test
    void jugarTaulellBuit(){
        char[][]taulellBuit = new char[][]{
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };

        Joc j = new Joc();
        j.novaPartida();
        short torn1 = 1;

        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 0; columna < 3; columna++) {
                Assertions.assertFalse((j.jugar(fila, columna, 'x')));
            }
        }

    }

    @Test
    void jugarSegonJugador(){
        char [][]taulellSegonJugador = new char[][]{
                {'x', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };

        Joc j = new Joc();
        j.novaPartida();
        short torn2 = 2;

        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 0; columna < 3; columna++) {
                Assertions.assertFalse((j.jugar(fila, columna, 'x')));
            }
        }
    }

   }