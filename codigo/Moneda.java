public abstract class Moneda implements Comparable<Moneda> { //
    public Moneda() {
    }
    public Moneda getSerie() { // retorna la referencia a la moneda
        return this;
    }
    public abstract int getValor(); // retorna el valor de la moneda
    @Override
    public int compareTo(Moneda m) {
        return this.getValor() - m.getValor();
    }
}
