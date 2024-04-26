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
    }

    public void novaPartida(){
        throw new NotImplementedException();
    }
    public void jugar(){

        throw new NotImplementedException();
    }
    public void jugadaGuanyadora(){
        throw new NotImplementedException();
    }
}
