public class MainPrueba {
    public static void main(String[] args) {
        Moneda m = new Moneda100();
        Expendedor exp = new Expendedor(0,100);
        Comprador c = new Comprador(m,4,exp);

        Moneda mo = null;
        Expendedor expe = new Expendedor(2,100);
        Comprador co = new Comprador(mo,2,expe);

        Moneda mon = new Moneda100();
        Expendedor expen = new Expendedor(2,200);
        Comprador com = new Comprador(mon,3,expen);


    }
}