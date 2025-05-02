public class PagoIncorrectoException extends Exception{
    public PagoIncorrectoException(){
        super("Pago Incorrecto, ingrese moneda valida");
    }
}

