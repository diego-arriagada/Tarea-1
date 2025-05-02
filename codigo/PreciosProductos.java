public enum PreciosProductos {
    SNICKERS(1200),
    SUPER8(600),

    SPRITE(1100),
    COCACOLA(1200),
    FANTA(1000);

    private final double precio;

    private PreciosProductos(double precio) {
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }
}
