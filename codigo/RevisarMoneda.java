public class RevisarMoneda {
    public static void revisar(Moneda mon) throws PagoIncorrectoException{
        if (mon == null){
            throw new PagoIncorrectoException();
        }
    }
}
