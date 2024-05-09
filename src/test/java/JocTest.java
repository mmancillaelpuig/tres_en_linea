import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JocTest {


    @Test
    void novaPartida_jugador() {
        Joc j = new Joc();
        j.novaPartida();  // Asegurarse de que el estado inicial es correcto
        Assertions.assertEquals(1, j.getTorn(), "El torn hauri de ser del jugador 1 a l'inici.");
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
        Assertions.assertArrayEquals(expectedTaulell, j.getTaulell(), "El taulell hauria d'estar buit a l'inici.");
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
                Assertions.assertFalse(j.jugadaGuanyadora(fila, columna, 'X'), "No hauria de poder guanyar ningú amb una casella marcada.");
            }
        }
    }


    @Test
    void jugadaGuanyadoraJugador1Guanya() {
        Joc j = new Joc();
        j.jugar(0, 0, 'X');
        j.jugar(0, 1, 'X');
        j.jugar(0, 2, 'X'); // Marcamos las tres casillas de la fila superior con 'X'
        Assertions.assertTrue(j.jugadaGuanyadora(0, 2, 'X'), "Jugador 'X' hauria d'haver guanyat.");
    }

    @Test
    void jugadaGuanyadoraJugador2Guanya() {
        Joc j = new Joc();
        j.jugar(0, 0, 'O');
        j.jugar(0, 1, 'O');
        j.jugar(0, 2, 'O'); // Igual pero con 'O'
        Assertions.assertTrue(j.jugadaGuanyadora(0, 2, 'O'), "Jugador 'O' hauria d'haver guanyat.");
    }


    @Test
    void jugarTaulellBuit() {
        Joc j = new Joc(); // inicializa el tablero con '_' en cada casilla
        j.novaPartida();
        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 0; columna < 3; columna++) {
                Assertions.assertTrue(j.jugar(fila, columna, 'X'), "Hauria de poder jugar a qualsevol casella a un taulell buit.");
            }
        }
    }


    @Test
    void jugarPrimerJugador() {
        Joc j = new Joc();
        j.jugar(0, 0, 'X');  // El primer jugador juega en la posición (0, 0).
        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 0; columna < 3; columna++) {
                if (!(fila == 0 && columna == 0)) {
                    Assertions.assertTrue(j.jugar(fila, columna, 'O'), "El segon jugador hauria de poder jugar a qualsevol casella.");
                }
            }
        }
    }


}