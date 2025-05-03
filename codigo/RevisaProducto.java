public class RevisaProducto {
    public static void revisar(Producto prod) throws NoHayProductoException{
        if (prod == null){
            throw new NoHayProductoException();
        }
    }
}
