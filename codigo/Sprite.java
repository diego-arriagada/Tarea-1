class Sprite extends Bebida {
    public Sprite(int serie) {
        super(serie);
    }
    public String beber() {
        return "sprite";
    }
    public double getPrecio() {
        return PreciosProductos.SPRITE.getPrecio();
    }
}