abstract class Bebida {
    private int serie;
    public Bebida(int serie) {
        this.serie = serie;
    }
    public int getSerie() {
        return serie;
    }
    public abstract String beber(); // metodo abstracto que se implementa en las subclases
}
