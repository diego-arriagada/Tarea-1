class Expendedor {
    private Deposito<Bebida> coca;
    private Deposito<Bebida> sprite;
    private Deposito<Moneda> monVu;
    private int precio;
    public Expendedor(int numBebidas, int precioBebidas) {
        coca = new Deposito();
        sprite = new Deposito();
        monVu = new Deposito();
        this.precio = precioBebidas;
        for (int i = 0; i < numBebidas; i++) {
            coca.addObjeto(new CocaCola(100 + i));
            sprite.addObjeto(new Sprite(200 + i));
        }
    }
    public static final int COCA = 1;
    public static final int SPRITE = 2;
    public static final int SNICKERS = 3;
    public static final int SUPER8 = 4;
    public Producto comprarProducto(Moneda m, int cual) {
        Bebida bebida = null;
        Dulce dulce = null;
        if (m != null) {
            if (m.getValor() >= precio) { // Verifica si el dinero es suficiente
                switch (cual) {
                    case COCA:
                        bebida = coca.getObjeto();
                        break;
                    case SPRITE:
                        bebida = sprite.getObjeto();
                        break;
                    case SNICKERS:
                        dulce = dulce.getObjeto();
                }
                if (bebida != null) { // Solo calcula vuelto si hay bebida disponible
                    int vuelto = m.getValor() - precio;
                    while (vuelto > 0) {
                        if (vuelto >= 1500) {
                            monVu.addObjeto(new Moneda1500());
                            vuelto -= 1500;
                        } else if (vuelto >= 1000) {
                            monVu.addObjeto(new Moneda1000());
                            vuelto -= 1000;
                        } else if (vuelto >= 500) {
                            monVu.addObjeto(new Moneda500());
                            vuelto -= 500;
                        } else if (vuelto >= 100) {
                            monVu.addObjeto(new Moneda100());
                            vuelto -= 100;
                        }
                    }
                } else {
                    // Si no hay bebida, devuelve la moneda completa
                    monVu.addObjeto(m);
                }
            } else {
                // Si el pago es insuficiente, devuelve la moneda completa
                monVu.addObjeto(m);
                return null; // Retorna null explicitamente
            }
        }
        return bebida;
    }
    public Moneda getVuelto(){ // retorna una moneda desde el deposito de vuelto, hay que llamarla hasta que quede vacio
        return monVu.getObjeto();
    }
}
