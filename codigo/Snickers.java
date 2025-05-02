public class Snickers extends Dulce {
    private int serie;
    public Snickers(int x){
        super(x);
    }
    public String comer(){
        return "snickers";
    }
    public double getPrecio() {
        return PreciosProductos.SNICKERS.getPrecio();
    }
}
