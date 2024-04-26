import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JocTest {

    @Test
    void novaPartida_jugador() {
        //Setup
        Joc j = new Joc();
        short torn1 = 1;


        //prov
        j.novaPartida();


        Assertions.assertEquals(j.getTorn(),torn1);
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
    void jugar() {
    }
}