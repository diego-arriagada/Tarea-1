/**
 * Clase Comprador que sirve para simular la compra de un producto en la máquina expendedora.
 *
 * @author Diego Arriagada
 * @author Victor Galaz
 * @author Matias Catril
 * @version 1.0
 */
class Comprador {
    private String sonidoBebida;
    private int vueltoTotal;

    public Comprador(Moneda m, int cualProducto, Expendedor exp) {
        Bebida bebida = null;
        Producto producto = null;
        try {
            producto = exp.comprarProducto(m, cualProducto); // Intenta comprar la bebida
        } catch (PagoIncorrectoException e){
            // Si hay algun problema (por ejemplo, sin saldo o sin bebida), no se asigna bebida
            producto = null;
            System.out.println(e.getMessage());
        } catch (PagoInsuficienteException ex){
            producto = null;
            System.out.println(ex.getMessage());
        } catch (NoHayProductoException exe){
            producto = null;
            System.out.println(exe.getMessage());
        }

        if (bebida != null) {
            sonidoBebida = bebida.beber(); // Guarda el sonido de la bebida
        } else {
            sonidoBebida = null;
        }

        // Calcula la suma del vuelto entregado por el expendedor
        vueltoTotal = 0;
        Moneda vuelto;
        while ((vuelto = exp.getVuelto()) != null) {
            vueltoTotal += vuelto.getValor(); // Suma el valor de cada moneda al total
        }
    }

    public int cuantoVuelto() {
        return vueltoTotal;
    }

    public String queBebiste() {
        return sonidoBebida;
    }
}
