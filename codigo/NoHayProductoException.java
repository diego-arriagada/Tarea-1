public class NoHayProductoException extends Exception{
    public NoHayProductoException(){
        super("No hay del producto solicitado");
    }
}
