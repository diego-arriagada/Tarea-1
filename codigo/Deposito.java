import java.util.ArrayList;

class Deposito {
    ArrayList<Bebida> depositoB;
    ArrayList<Moneda> depositoM;
    public Deposito() {
        depositoB = new ArrayList<Bebida>();
        depositoM = new ArrayList<Moneda>();
    }
    public void addBebida(Bebida b) {
        depositoB.add(b);
    }
    public Bebida getBebida(){ // funciona como FIFO
        if (depositoB.size() > 0) {
            return depositoB.remove(0);
        }
        return null;
    }
    public void addMoneda(Moneda m) {
        // Agregar moneda al deposito de vuelto
        if (m != null) {
            depositoM.add(m);
        }
    }
    public Moneda getMoneda(){
        // Retornar una moneda del deposito de vuelto
        if (depositoM.size() > 0) {
            return (Moneda) depositoM.remove(0);
        }
        return null;
    }
}
