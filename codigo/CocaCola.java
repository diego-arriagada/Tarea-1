class CocaCola extends Bebida {
    public CocaCola(int serie) {
        super(serie);
    }
    public String beber() {
        return "cocacola";
    }
    public double getPrecio() {
        return PreciosProductos.COCA.getPrecio();
    }
}