/**
 * Clase abstracta Dulce que se desprende de Producto.
 *
 * @author Diego Arriagada
 * @author Victor Galaz
 * @author Matias Catril
 * @version 1.0
 */
abstract class Dulce extends Producto {
    private int serie;
    public Dulce(int x){
        super(x);
    }
    public abstract String comer(); // metodo abstracto que se implementa en las subclases
}
