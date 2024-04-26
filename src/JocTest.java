import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JocTest {

    @Test
    void novaPartida_jugador() {
        Joc j = new Joc();
        j.novaPartida();

    }

    @Test
    void novaPartida_taulell() {
        Joc j = new Joc();
        j.novaPartida();
        char[][] taulellBuit = new char[][]{{' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}};
        Assertions.assertArrayEquals(j.getTaulell(), taulellBuit);

    }

    @Test
    void jugar() {
    }
}