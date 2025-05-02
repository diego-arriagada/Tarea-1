/**
 * Clase abstracta Moneda, que forma la base de la jerarquía de monedas.
 *
 * La clase implementa la interfaz Comparable, para establecer un criterio a usar en la ordenacion del main.
 *
 * @author Diego Arriagada
 * @author Victor Galaz
 * @author Matias Catril
 * @version 1.0
 */
abstract class Moneda implements Comparable { //
    public Moneda() {
    }
    public Moneda getSerie() { // retorna la referencia a la moneda
        return this;
    }
    public abstract int getValor(); // retorna el valor de la moneda

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
