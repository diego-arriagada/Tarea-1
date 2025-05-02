public class PagoInsuficienteException extends Exception{
    public PagoInsuficienteException(){
        super("Pago insuficiente para el producto solicitado");
    }
}
