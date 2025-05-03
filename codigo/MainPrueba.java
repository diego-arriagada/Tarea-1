public class MainPrueba {
    public static void main(String[] args) {

        // Prueba comprar 0 productos
        Moneda m = new Moneda100();
        Expendedor exp = new Expendedor(0);
        Comprador c = new Comprador(m,4,exp);

        // Prueba comprar con moneda nula
        Moneda mo = null;
        Expendedor expe = new Expendedor(2);
        Comprador co = new Comprador(mo,2,expe);

        // Prueba comprar sin suficiente saldo
        Moneda mon = new Moneda100();
        Expendedor expen = new Expendedor(2);
        Comprador com = new Comprador(mon,3,expen);
    }
}