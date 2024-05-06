import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Joc {
    public  char[][] getTaulell() {
        return taulell;
    }

    private char [][] taulell;
    private short torn;

    public short getTorn() {
        return torn;
    }

    public Joc() {
        this.taulell = new char[][]{
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
        this.torn = 1;
    }
    public Joc(char[][] taulellInici, short torn1) {
        this.taulell = taulellInici;
        this.torn = torn1;
    }
    public void novaPartida(){
        throw new NotImplementedException();
    }
    public boolean jugar(int fila, int columna, char jugador){

        throw new NotImplementedException();
    }
    public boolean jugadaGuanyadora(int fila, int columna, char jugador) {
        throw new NotImplementedException();
    }
}
