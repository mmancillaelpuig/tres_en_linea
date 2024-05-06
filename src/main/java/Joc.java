import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Joc {
    public  char[][] getTaulell() {
        return taulell;
    }

    private char [][] taulell;
    private short torn;
    private short midaTaulell = 3;

    public short getTorn() {
        return torn;
    }
    public short getMidaTaulell(){return midaTaulell;}

    public void setMidaTaulell(short midaTaulell) {
        this.midaTaulell = midaTaulell;
    }

    public Joc() {
        this.taulell = new char[][]{
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
        this.torn = 1;
    }

    public Joc(short midaTaulell){
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
