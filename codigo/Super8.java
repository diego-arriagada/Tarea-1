public class Super8 extends Dulce {
    private int serie;
    public Super8(int x){
        super(x);
    }
    public String comer(){
        return "super8";
    }
    public double getPrecio() {
        return PreciosProductos.SUPER8.getPrecio();
    }
}
