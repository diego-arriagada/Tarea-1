import java.util.ArrayList;

public class Deposito<T> {
    ArrayList<T> deposito;
    public Deposito() {
        deposito = new ArrayList<T>();
    }
    public void addObjeto(T m) {
        // Agregar moneda al deposito de vuelto
        if (m != null) {
            deposito.add(m);
        }
    }
    public Moneda getObjeto(){
        // Retornar una moneda del deposito de vuelto
        if (deposito.size() > 0) {
            return (Moneda) deposito.remove(0);
        }
        return null;
    }
}
