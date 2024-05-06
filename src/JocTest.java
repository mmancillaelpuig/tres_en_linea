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
    void jugar_TaullelBuitpos00() {
        Joc j = new Joc();
        j.jugar();

        //torn del jugador 1
        short torn1 = 1;

        char[][] taulellPos00 = new char[][]{
                {'o', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
        Assertions.assertEquals(j.getTorn(), torn1);
        Assertions.assertArrayEquals(j.getTaulell(), taulellPos00);
    }


    @Test
    void jugar_TaullelBuitpos01() {
        Joc j = new Joc();
        j.jugar();

        //torn del jugador 1
        short torn1 = 1;


        char[][] taulellPos01 = new char[][]{
                {' ', 'o', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
        Assertions.assertEquals(j.getTorn(), torn1);
        Assertions.assertArrayEquals(j.getTaulell(), taulellPos01);

    }

    @Test
    void jugar_TaullelBuitpos02() {
        Joc j = new Joc();
        j.jugar();

        //torn del jugador 1
        short torn1 = 1;
        char[][] taulellPos02 = new char[][]{
                {' ', ' ', 'o'},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
        Assertions.assertEquals(j.getTorn(), torn1);
        Assertions.assertArrayEquals(j.getTaulell(), taulellPos02);
    }

    @Test
    void jugar_TaullelBuitpos10() {
        Joc j = new Joc();
        j.jugar();

        //torn del jugador 1
        short torn1 = 1;
        char[][] taulellPos10 = new char[][]{
                {' ', ' ', ' '},
                {'o', ' ', ' '},
                {' ', ' ', ' '}
        };
        Assertions.assertEquals(j.getTorn(), torn1);
        Assertions.assertArrayEquals(j.getTaulell(), taulellPos10);
    }

    @Test
    void jugar_TaullelBuitpos11() {
        Joc j = new Joc();
        j.jugar();

        //torn del jugador 1
        short torn1 = 1;
        char[][] taulellPos11 = new char[][]{
                {' ', ' ', ' '},
                {' ', 'o', ' '},
                {' ', ' ', ' '}
        };
        Assertions.assertEquals(j.getTorn(), torn1);
        Assertions.assertArrayEquals(j.getTaulell(), taulellPos11);
    }

    @Test
    void jugar_TaullelBuitpos12() {
        Joc j = new Joc();
        j.jugar();

        //torn del jugador 1
        short torn1 = 1;
        char[][] taulellPos12 = new char[][]{
                {' ', ' ', ' '},
                {' ', ' ', 'o'},
                {' ', ' ', ' '}
        };
        Assertions.assertEquals(j.getTorn(), torn1);
        Assertions.assertArrayEquals(j.getTaulell(), taulellPos12);
    }

    @Test
    void jugar_TaullelBuitpos20() {
        Joc j = new Joc();
        j.jugar();

        //torn del jugador 1
        short torn1 = 1;
        char[][] taulellPos20 = new char[][]{
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {'o', ' ', ' '}
        };
        Assertions.assertEquals(j.getTorn(), torn1);
        Assertions.assertArrayEquals(j.getTaulell(), taulellPos20);
    }

    @Test
    void jugar_TaullelBuitpos21() {
        Joc j = new Joc();
        j.jugar();

        //torn del jugador 1
        short torn1 = 1;
        char[][] taulellPos21 = new char[][]{
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', 'o', ' '}
        };
        Assertions.assertEquals(j.getTorn(), torn1);
        Assertions.assertArrayEquals(j.getTaulell(), taulellPos21);
    }

    @Test
    void jugar_TaullelBuitpos22() {
        Joc j = new Joc();
        j.jugar();

        //torn del jugador 1
        short torn1 = 1;

        char[][] taulellPos22 = new char[][]{
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', 'o'}
        };
        Assertions.assertEquals(j.getTorn(), torn1);
        Assertions.assertArrayEquals(j.getTaulell(), taulellPos22);
    }


    @Test
    void jugar_TaullelNoBuit_01() {
        Joc j = new Joc();
        j.jugar();

        //torn del jugador 2
        short torn = 2;

        char[][] taulellPos00_01 = new char[][]{
                {'o', 'o', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
        Assertions.assertEquals(j.getTorn(), torn);
        Assertions.assertArrayEquals(j.getTaulell(), taulellPos00_01);
    }

    @Test
    void jugar_TaullelNoBuit_02() {
        Joc j = new Joc();
        j.jugar();

        //torn del jugador 2
        short torn = 2;


        char[][] taulellPos00_02 = new char[][]{
                {'o', ' ', 'o'},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
        Assertions.assertEquals(j.getTorn(), torn);
        Assertions.assertArrayEquals(j.getTaulell(), taulellPos00_02);
    }

    @Test
    void jugar_TaullelNoBuit_03() {
        Joc j = new Joc();
        j.jugar();

        //torn del jugador 2
        short torn = 2;

        char[][] taulellPos00_10 = new char[][]{
                {'o', ' ', ' '},
                {'o', ' ', ' '},
                {' ', ' ', ' '}
        };
        Assertions.assertEquals(j.getTorn(), torn);
        Assertions.assertArrayEquals(j.getTaulell(), taulellPos00_10);
    }

    @Test
    void jugar_TaullelNoBuit_04() {
        Joc j = new Joc();
        j.jugar();

        //torn del jugador 2
        short torn = 2;

        char[][] taulellPos00_11 = new char[][]{
                {'o', ' ', ' '},
                {' ', 'o', ' '},
                {' ', ' ', ' '}
        };
        Assertions.assertEquals(j.getTorn(), torn);
        Assertions.assertArrayEquals(j.getTaulell(), taulellPos00_11);
    }

    @Test
    void jugar_TaullelNoBuit_05() {
        Joc j = new Joc();
        j.jugar();

        //torn del jugador 2
        short torn = 2;

        char[][] taulellPos00_12 = new char[][]{
                {'o', ' ', ' '},
                {' ', ' ', 'o'},
                {' ', ' ', ' '}
        };
        Assertions.assertEquals(j.getTorn(), torn);
        Assertions.assertArrayEquals(j.getTaulell(), taulellPos00_12);
    }

    @Test
    void jugar_TaullelNoBuit_06() {
        Joc j = new Joc();
        j.jugar();

        //torn del jugador 2
        short torn = 2;

        char[][] taulellPos00_20 = new char[][]{
                {'o', ' ', ' '},
                {' ', ' ', ' '},
                {'o', ' ', ' '}
        };
        Assertions.assertEquals(j.getTorn(), torn);
        Assertions.assertArrayEquals(j.getTaulell(), taulellPos00_20);
    }

    @Test
    void jugar_TaullelNoBuit_07() {
        Joc j = new Joc();
        j.jugar();

        //torn del jugador 2
        short torn = 2;

        char[][] taulellPos00_21 = new char[][]{
                {'o', ' ', ' '},
                {' ', ' ', ' '},
                {' ', 'o', ' '}
        };
        Assertions.assertEquals(j.getTorn(), torn);
        Assertions.assertArrayEquals(j.getTaulell(), taulellPos00_21);
    }

    @Test
    void jugar_TaullelNoBuit_08() {
        Joc j = new Joc();
        j.jugar();

        //torn del jugador 2
        short torn = 2;

        char[][] taulellPos00_22 = new char[][]{
                {'o', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', 'o'}
        };
        Assertions.assertEquals(j.getTorn(), torn);
        Assertions.assertArrayEquals(j.getTaulell(), taulellPos00_22);
    }

    @Test
    void jugar_TaullelNoBuit_09() {
        Joc j = new Joc();
        j.jugar();

        //torn del jugador 2
        short torn = 2;


        char[][] taulellPos01 = new char[][]{
                {' ', 'o', 'o'},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
        Assertions.assertEquals(j.getTorn(), torn);
        Assertions.assertArrayEquals(j.getTaulell(), taulellPos01);
    }

    @Test
    void jugar_TaullelNoBuit_10() {
        Joc j = new Joc();
        j.jugar();

        //torn del jugador 2
        short torn = 2;

        char[][] taulellPos02 = new char[][]{
                {' ', 'o', ' '},
                {'o', ' ', ' '},
                {' ', ' ', ' '}
        };
        Assertions.assertEquals(j.getTorn(), torn);
        Assertions.assertArrayEquals(j.getTaulell(), taulellPos02);
    }

    @Test
    void jugar_TaullelNoBuit_11() {
        Joc j = new Joc();
        j.jugar();

        //torn del jugador 2
        short torn = 2;

        char[][] taulellPos10 = new char[][]{
                {' ', 'o', ' '},
                {' ', 'o', ' '},
                {' ', ' ', ' '}
        };
        Assertions.assertEquals(j.getTorn(), torn);
        Assertions.assertArrayEquals(j.getTaulell(), taulellPos10);
    }

    @Test
    void jugar_TaullelNoBuit_12() {
        Joc j = new Joc();
        j.jugar();

        //torn del jugador 2
        short torn = 2;


        char[][] taulellPos11 = new char[][]{
                {' ', 'o', ' '},
                {' ', ' ', 'o'},
                {' ', ' ', ' '}
        };
        Assertions.assertEquals(j.getTorn(), torn);
        Assertions.assertArrayEquals(j.getTaulell(), taulellPos11);
    }

    @Test
    void jugar_TaullelNoBuit_13() {
        Joc j = new Joc();
        j.jugar();

        //torn del jugador 2
        short torn = 2;

        char[][] taulellPos12 = new char[][]{
                {' ', 'o', ' '},
                {' ', ' ', ' '},
                {'o', ' ', ' '}
        };
        Assertions.assertEquals(j.getTorn(), torn);
        Assertions.assertArrayEquals(j.getTaulell(), taulellPos12);
    }

    @Test
    void jugar_TaullelNoBuit_14() {
        Joc j = new Joc();
        j.jugar();

        //torn del jugador 2
        short torn = 2;

        char[][] taulellPos20 = new char[][]{
                {' ', 'o', ' '},
                {' ', ' ', ' '},
                {' ', 'o', ' '}
        };
        Assertions.assertEquals(j.getTorn(), torn);
        Assertions.assertArrayEquals(j.getTaulell(), taulellPos20);
    }

    @Test
    void jugar_TaullelNoBuit_15() {
        Joc j = new Joc();
        j.jugar();

        //torn del jugador 2
        short torn = 2;

        char[][] taulellPos21 = new char[][]{
                {' ', 'o', ' '},
                {' ', ' ', ' '},
                {' ', ' ', 'o'}
        };
        Assertions.assertEquals(j.getTorn(), torn);
        Assertions.assertArrayEquals(j.getTaulell(), taulellPos21);
    }

    @Test
    void jugar_TaullelNoBuit_16() {
        Joc j = new Joc();
        j.jugar();

        //torn del jugador 2
        short torn = 2;

        char[][] taulellPos22 = new char[][]{
                {' ', ' ', 'o'},
                {'o', ' ', ' '},
                {' ', ' ', ' '}
        };
        Assertions.assertEquals(j.getTorn(), torn);
        Assertions.assertArrayEquals(j.getTaulell(), taulellPos22);
    }

    @Test
    void jugar_TaullelNoBuit_17() {
        Joc j = new Joc();
        j.jugar();

        //torn del jugador 2
        short torn = 2;

        char[][] taulellPos22 = new char[][]{
                {' ', ' ', 'o'},
                {' ', 'o', ' '},
                {' ', ' ', ' '}
        };
        Assertions.assertEquals(j.getTorn(), torn);
        Assertions.assertArrayEquals(j.getTaulell(), taulellPos22);
    }

    @Test
    void jugar_TaullelNoBuit_18() {
        Joc j = new Joc();
        j.jugar();

        //torn del jugador 2
        short torn = 2;

        char[][] taulellPos22 = new char[][]{
                {' ', ' ', 'o'},
                {' ', 'o', ' '},
                {' ', ' ', ' '}
        };
        Assertions.assertEquals(j.getTorn(), torn);
        Assertions.assertArrayEquals(j.getTaulell(), taulellPos22);
    }

    @Test
    void jugar_TaullelNoBuit_19() {
        Joc j = new Joc();
        j.jugar();

        //torn del jugador 2
        short torn = 2;

        char[][] taulellPos22 = new char[][]{
                {' ', ' ', 'o'},
                {' ', ' ', 'o'},
                {' ', ' ', ' '}
        };
        Assertions.assertEquals(j.getTorn(), torn);
        Assertions.assertArrayEquals(j.getTaulell(), taulellPos22);
    }

    @Test
    void jugar_TaullelNoBuit_20() {
        Joc j = new Joc();
        j.jugar();

        //torn del jugador 2
        short torn = 2;

        char[][] taulellPos22 = new char[][]{
                {' ', ' ', 'o'},
                {' ', ' ', ' '},
                {'o', ' ', ' '}
        };
        Assertions.assertEquals(j.getTorn(), torn);
        Assertions.assertArrayEquals(j.getTaulell(), taulellPos22);
    }

    @Test
    void jugar_TaullelNoBuit_21() {
        Joc j = new Joc();
        j.jugar();

        //torn del jugador 2
        short torn = 2;

        char[][] taulellPos22 = new char[][]{
                {' ', ' ', 'o'},
                {' ', ' ', ' '},
                {' ', 'o', ' '}
        };
        Assertions.assertEquals(j.getTorn(), torn);
        Assertions.assertArrayEquals(j.getTaulell(), taulellPos22);
    }

    @Test
    void jugar_TaullelNoBuit_22() {
        Joc j = new Joc();
        j.jugar();

        //torn del jugador 2
        short torn = 2;

        char[][] taulellPos22 = new char[][]{
                {' ', ' ', 'o'},
                {' ', ' ', ' '},
                {' ', ' ', 'o'}
        };
        Assertions.assertEquals(j.getTorn(), torn);
        Assertions.assertArrayEquals(j.getTaulell(), taulellPos22);
    }

    @Test
    void jugar_TaullelNoBuit_23() {
        Joc j = new Joc();
        j.jugar();

        //torn del jugador 2
        short torn = 2;

        char[][] taulellPos22 = new char[][]{
                {' ', ' ', ' '},
                {'o', 'o', ' '},
                {' ', ' ', ' '}
        };
        Assertions.assertEquals(j.getTorn(), torn);
        Assertions.assertArrayEquals(j.getTaulell(), taulellPos22);
    }

    @Test
    void jugar_TaullelNoBuit_24() {
        Joc j = new Joc();
        j.jugar();

        //torn del jugador 2
        short torn = 2;

        char[][] taulellPos22 = new char[][]{
                {' ', ' ', ' '},
                {'o', ' ', 'o'},
                {' ', ' ', ' '}
        };
        Assertions.assertEquals(j.getTorn(), torn);
        Assertions.assertArrayEquals(j.getTaulell(), taulellPos22);
    }

    @Test
    void jugar_TaullelNoBuit_25() {
        Joc j = new Joc();
        j.jugar();

        //torn del jugador 2
        short torn = 2;

        char[][] taulellPos22 = new char[][]{
                {' ', ' ', ' '},
                {'o', ' ', ' '},
                {'o', ' ', ' '}
        };
        Assertions.assertEquals(j.getTorn(), torn);
        Assertions.assertArrayEquals(j.getTaulell(), taulellPos22);
    }

    @Test
    void jugar_TaullelNoBuit_26() {
        Joc j = new Joc();
        j.jugar();

        //torn del jugador 2
        short torn = 2;

        char[][] taulellPos22 = new char[][]{
                {' ', ' ', ' '},
                {'o', ' ', ' '},
                {' ', 'o', ' '}
        };
        Assertions.assertEquals(j.getTorn(), torn);
        Assertions.assertArrayEquals(j.getTaulell(), taulellPos22);
    }

    @Test
    void jugar_TaullelNoBuit_27() {
        Joc j = new Joc();
        j.jugar();

        //torn del jugador 2
        short torn = 2;

        char[][] taulellPos22 = new char[][]{
                {' ', ' ', ' '},
                {'o', ' ', ' '},
                {' ', ' ', 'o'}
        };
        Assertions.assertEquals(j.getTorn(), torn);
        Assertions.assertArrayEquals(j.getTaulell(), taulellPos22);
    }

    @Test
    void jugar_TaullelNoBuit_28() {
        Joc j = new Joc();
        j.jugar();

        //torn del jugador 2
        short torn = 2;

        char[][] taulellPos22 = new char[][]{
                {' ', ' ', ' '},
                {' ', 'o', 'o'},
                {' ', ' ', ' '}
        };
        Assertions.assertEquals(j.getTorn(), torn);
        Assertions.assertArrayEquals(j.getTaulell(), taulellPos22);
    }

    @Test
    void jugar_TaullelNoBuit_29() {
        Joc j = new Joc();
        j.jugar();

        //torn del jugador 2
        short torn = 2;

        char[][] taulellPos22 = new char[][]{
                {' ', ' ', ' '},
                {' ', 'o', ' '},
                {'o', ' ', ' '}
        };
        Assertions.assertEquals(j.getTorn(), torn);
        Assertions.assertArrayEquals(j.getTaulell(), taulellPos22);
    }

    @Test
    void jugar_TaullelNoBuit_30() {
        Joc j = new Joc();
        j.jugar();

        //torn del jugador 2
        short torn = 2;

        char[][] taulellPos22 = new char[][]{
                {' ', ' ', ' '},
                {' ', 'o', ' '},
                {' ', 'o', ' '}
        };
        Assertions.assertEquals(j.getTorn(), torn);
        Assertions.assertArrayEquals(j.getTaulell(), taulellPos22);
    }

    @Test
    void jugar_TaullelNoBuit_31() {
        Joc j = new Joc();
        j.jugar();

        //torn del jugador 2
        short torn = 2;

        char[][] taulellPos22 = new char[][]{
                {' ', ' ', ' '},
                {' ', 'o', ' '},
                {' ', ' ', 'o'}
        };
        Assertions.assertEquals(j.getTorn(), torn);
        Assertions.assertArrayEquals(j.getTaulell(), taulellPos22);
    }

    @Test
    void jugar_TaullelNoBuit_32() {
        Joc j = new Joc();
        j.jugar();

        //torn del jugador 2
        short torn = 2;

        char[][] taulellPos22 = new char[][]{
                {' ', ' ', ' '},
                {' ', ' ', 'o'},
                {'o', ' ', ' '}
        };
        Assertions.assertEquals(j.getTorn(), torn);
        Assertions.assertArrayEquals(j.getTaulell(), taulellPos22);
    }

    @Test
    void jugar_TaullelNoBuit_33() {
        Joc j = new Joc();
        j.jugar();

        //torn del jugador 2
        short torn = 2;

        char[][] taulellPos22 = new char[][]{
                {' ', ' ', ' '},
                {' ', ' ', 'o'},
                {' ', 'o', ' '}
        };
        Assertions.assertEquals(j.getTorn(), torn);
        Assertions.assertArrayEquals(j.getTaulell(), taulellPos22);
    }

    @Test
    void jugar_TaullelNoBuit_34() {
        Joc j = new Joc();
        j.jugar();

        //torn del jugador 2
        short torn = 2;

        char[][] taulellPos22 = new char[][]{
                {' ', ' ', ' '},
                {' ', ' ', 'o'},
                {' ', ' ', 'o'}
        };
        Assertions.assertEquals(j.getTorn(), torn);
        Assertions.assertArrayEquals(j.getTaulell(), taulellPos22);
    }

    @Test
    void jugar_TaullelNoBuit_35() {
        Joc j = new Joc();
        j.jugar();

        //torn del jugador 2
        short torn = 2;

        char[][] taulellPos22 = new char[][]{
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {'o', 'o', ' '}
        };
        Assertions.assertEquals(j.getTorn(), torn);
        Assertions.assertArrayEquals(j.getTaulell(), taulellPos22);
    }

    @Test
    void jugar_TaullelNoBuit_36() {
        Joc j = new Joc();
        j.jugar();

        //torn del jugador 2
        short torn = 2;

        char[][] taulellPos22 = new char[][]{
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {'o', ' ', 'o'}
        };
        Assertions.assertEquals(j.getTorn(), torn);
        Assertions.assertArrayEquals(j.getTaulell(), taulellPos22);
    }

    @Test
    void jugar_TaullelNoBuit_37() {
        Joc j = new Joc();
        j.jugar();

        //torn del jugador 2
        short torn = 2;

        char[][] taulellPos22 = new char[][]{
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', 'o', 'o'}
        };
        Assertions.assertEquals(j.getTorn(), torn);
        Assertions.assertArrayEquals(j.getTaulell(), taulellPos22);
    }

}