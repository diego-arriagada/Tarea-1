abstract class Bebida extends Producto {
    private int serie;
    public Bebida(int x) {
        super(x);
    }
    public int getSerie() {
        return serie;
    }
    public abstract String beber(); // metodo abstracto que se implementa en las subclases
}
