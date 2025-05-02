class Expendedor {
    private Deposito<Producto> coca;
    private Deposito<Producto> sprite;
    private Deposito<Producto> fanta;
    private Deposito<Producto> snicker;
    private Deposito<Producto> super8;
    private Deposito<Moneda> monVu;

    public Expendedor(int numProductos) {
        coca = new Deposito<>();
        sprite = new Deposito<>();
        fanta = new Deposito<>();
        snicker = new Deposito<>();
        super8 = new Deposito<>();
        monVu = new Deposito<>();

        for (int i = 0; i < numProductos; i++) {
            coca.addObjeto(new CocaCola(100 + i));
            sprite.addObjeto(new Sprite(200 + i));
            fanta.addObjeto(new Fanta(300 + i));
            snicker.addObjeto(new Snickers(400 + i));
            super8.addObjeto(new Super8(500 + i));
        }
    }

    public static final int COCA = 1;
    public static final int SPRITE = 2;
    public static final int FANTA = 3;
    public static final int SNICKERS = 4;
    public static final int SUPER8 = 5;

    public Producto comprarProducto(Moneda m, int cual) {
        if (m == null) {
            return null;
        }

        Deposito<Producto> depositoSeleccionado = null;
        double precioProducto = 0;

        switch (cual) {
            case COCA:
                depositoSeleccionado = coca;
                precioProducto = PreciosProductos.COCA.getPrecio();
                break;
            case SPRITE:
                depositoSeleccionado = sprite;
                precioProducto = PreciosProductos.SPRITE.getPrecio();
                break;
            case FANTA:
                depositoSeleccionado = fanta;
                precioProducto = PreciosProductos.FANTA.getPrecio();
                break;
            case SNICKERS:
                depositoSeleccionado = snicker;
                precioProducto = PreciosProductos.SNICKERS.getPrecio();
                break;
            case SUPER8:
                depositoSeleccionado = super8;
                precioProducto = PreciosProductos.SUPER8.getPrecio();
                break;
            default:
                monVu.addObjeto(m); // Devuelve la moneda si no existe el producto
                return null;
        }

        if (m.getValor() < precioProducto) {
            monVu.addObjeto(m); // Devuelve la moneda si no alcanza
            return null;
        }

        Producto producto = depositoSeleccionado.getObjeto();
        if (producto == null) {
            monVu.addObjeto(m); // Devuelve la moneda si no hay stock
            return null;
        }

        // Calcula el vuelto
        int vuelto = (int)(m.getValor() - precioProducto);
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

        return producto;
    }

    public Moneda getVuelto() {
        return monVu.getObjeto();
    }
}