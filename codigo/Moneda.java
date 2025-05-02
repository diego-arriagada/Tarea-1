abstract class Moneda { //
    public Moneda() {
    }
    public Moneda getSerie() { // retorna la referencia a la moneda
        return this;
    }
    public abstract int getValor(); // retorna el valor de la moneda

}
