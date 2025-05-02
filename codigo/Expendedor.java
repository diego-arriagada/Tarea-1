class Expendedor {
    private Deposito coca;
    private Deposito sprite;
    private Deposito monVu;
    private int precio;
    public Expendedor(int numBebidas, int precioBebidas) {
        coca = new Deposito();
        sprite = new Deposito();
        monVu = new Deposito();
        this.precio = precioBebidas;
        for (int i = 0; i < numBebidas; i++) {
            coca.addBebida(new CocaCola(100 + i));
            sprite.addBebida(new Sprite(200 + i));
        }
    }
    public static final int COCA = 1;
    public static final int SPRITE = 2;
    public Bebida comprarBebida(Moneda m, int cual) {
        Bebida bebida = null;
        if (m != null) {
            if (m.getValor() >= precio) { // Verifica si el dinero es suficiente
                switch (cual) {
                    case COCA:
                        bebida = coca.getBebida();
                        break;
                    case SPRITE:
                        bebida = sprite.getBebida();
                        break;
                }
                if (bebida != null) { // Solo calcula vuelto si hay bebida disponible
                    int vuelto = m.getValor() - precio;
                    while (vuelto > 0) {
                        if (vuelto >= 1500) {
                            monVu.addMoneda(new Moneda1500());
                            vuelto -= 1500;
                        } else if (vuelto >= 1000) {
                            monVu.addMoneda(new Moneda1000());
                            vuelto -= 1000;
                        } else if (vuelto >= 500) {
                            monVu.addMoneda(new Moneda500());
                            vuelto -= 500;
                        } else if (vuelto >= 100) {
                            monVu.addMoneda(new Moneda100());
                            vuelto -= 100;
                        }
                    }
                } else {
                    // Si no hay bebida, devuelve la moneda completa
                    monVu.addMoneda(m);
                }
            } else {
                // Si el pago es insuficiente, devuelve la moneda completa
                monVu.addMoneda(m);
                return null; // Retorna null explicitamente
            }
        }
        return bebida;
    }
    public Moneda getVuelto(){ // retorna una moneda desde el deposito de vuelto, hay que llamarla hasta que quede vacio
        return monVu.getMoneda();
    }
}
