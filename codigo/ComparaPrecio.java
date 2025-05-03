public class ComparaPrecio {
    public static void compara(int pagado, double precio) throws PagoInsuficienteException{
        if (pagado < precio){
            throw new PagoInsuficienteException();
        }
    }
}
