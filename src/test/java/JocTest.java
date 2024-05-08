import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JocTest {


    @Test
    void novaPartida_jugador() {
        Joc j = new Joc();
        j.novaPartida();  // Asegurarse de que el estado inicial es correcto
        Assertions.assertEquals(1, j.getTorn(), "El turno debería ser del jugador 1 al inicio.");
    }

    @Test
    void novaPartida_taulell() {
        Joc j = new Joc();
        j.novaPartida();
        char[][] expectedTaulell = {
                {'_', '_', '_'},
                {'_', '_', '_'},
                {'_', '_', '_'}
        };
        Assertions.assertArrayEquals(expectedTaulell, j.getTaulell(), "El tablero debería estar vacío al inicio.");
    }


    @Test
    void taulellInicialitzatCorrectament() {
        Joc j = new Joc();
        char[][] expected = {
                {'_', '_', '_'},
                {'_', '_', '_'},
                {'_', '_', '_'}
        };
        Assertions.assertArrayEquals(expected, j.getTaulell());
    }


    @Test
    void jugadaGuanyadoraTaulellBuit() {
        Joc j = new Joc();
        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 0; columna < 3; columna++) {
                Assertions.assertFalse(j.jugadaGuanyadora(fila, columna, 'X'));
            }
        }
    }


    @Test
    void jugadaGuanyadoraUnaCasella() {
        Joc j = new Joc();
        j.jugar(0, 0, 'X');  // Marcamos una sola casilla
        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 0; columna < 3; columna++) {
                Assertions.assertFalse(j.jugadaGuanyadora(fila, columna, 'X'), "No debería haber ganador con una sola casilla marcada.");
            }
        }
    }


    @Test
    void jugadaGuanyadoraJugador1Guanya() {
        Joc j = new Joc();
        j.jugar(0, 0, 'X');
        j.jugar(0, 1, 'X');
        j.jugar(0, 2, 'X'); // Marcamos las tres casillas de la fila superior con 'X'
        Assertions.assertTrue(j.jugadaGuanyadora(0, 2, 'X'), "Jugador 'X' debería haber ganado.");
    }

    @Test
    void jugadaGuanyadoraJugador2Guanya() {
        Joc j = new Joc();
        j.jugar(0, 0, 'O');
        j.jugar(0, 1, 'O');
        j.jugar(0, 2, 'O'); // Marcamos las tres casillas de la fila superior con 'O'
        Assertions.assertTrue(j.jugadaGuanyadora(0, 2, 'O'), "Jugador 'O' debería haber ganado.");
    }


    @Test
    void jugarTaulellBuit() {
        Joc j = new Joc(); // inicializa el tablero con '_' en cada casilla
        j.novaPartida();
        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 0; columna < 3; columna++) {
                Assertions.assertTrue(j.jugar(fila, columna, 'X'), "Debería poder jugar en cualquier casilla de un tablero vacío.");
            }
        }
    }


    @Test
    void jugarSegonJugador() {
        Joc j = new Joc();
        j.jugar(0, 0, 'X');  // El primer jugador juega en la posición (0, 0).
        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 0; columna < 3; columna++) {
                if (!(fila == 0 && columna == 0)) {
                    Assertions.assertTrue(j.jugar(fila, columna, 'O'), "El segundo jugador debería poder jugar en cualquier otra casilla.");
                }
            }
        }
    }


}