public class ComparaPrecio {
    public static void compara(int pagado, int precio) throws PagoInsuficienteException{
        if (pagado < precio){
            throw new PagoInsuficienteException();
        }
    }
}
