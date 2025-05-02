/**
 * Clase Fanta que se desprende de Bebida.
 *
 * @author Diego Arriagada
 * @author Victor Galaz
 * @author Matias Catril
 * @version 1.0
 */
class Fanta extends Bebida {
    public Fanta(int serie) {
        super(serie);
    }
    public String beber() {
        return "fanta";
    }
    public double getPrecio() {
        return PreciosProductos.FANTA.getPrecio();
    }
}
