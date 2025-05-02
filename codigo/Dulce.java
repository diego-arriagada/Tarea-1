abstract class Dulce extends Producto {
    private int serie;
    public Dulce(int x){
        super(x);
    }
    public abstract String comer(); // metodo abstracto que se implementa en las subclases
}
