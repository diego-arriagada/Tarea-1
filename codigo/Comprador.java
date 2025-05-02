class Comprador {
    private String sonidoBebida;
    private int vueltoTotal;

    public Comprador(Moneda m, int cualBebida, Expendedor exp) {
        Bebida bebida = null;

        try {
            bebida = exp.comprarProducto(m, cualBebida); // Intenta comprar la bebida
        } catch (Exception e) {
            // Si hay algun problema (por ejemplo, sin saldo o sin bebida), no se asigna bebida
            bebida = null;
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
