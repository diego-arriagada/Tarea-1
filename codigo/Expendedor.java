class Expendedor {
    private Deposito<Bebida> coca;
    private Deposito<Bebida> sprite;
    private Deposito<Moneda> monVu;
    private Deposito<Dulce> snicker;
    private Deposito<Dulce> super8;
    private int precio;
    public Expendedor(int numBebidas, int precioBebidas) {
        coca = new Deposito();
        sprite = new Deposito();
        snicker = new Deposito();
        super8 = new Deposito();
        monVu = new Deposito();
        this.precio = precioBebidas;
        for (int i = 0; i < numBebidas; i++) {
            coca.addObjeto(new CocaCola(100 + i));
            sprite.addObjeto(new Sprite(200 + i));
            snicker.addObjeto(new Snicker(300 + i));
            super8.addObjeto(new Super8(400 + i));
        }
    }
    public static final int COCA = 1;
    public static final int SPRITE = 2;
    public static final int SNICKERS = 3;
    public static final int SUPER8 = 4;
    public Producto comprarProducto(Moneda m, int cual) {
        Bebida bebida = null;
        Dulce dulce = null;
        try {
            RevisarMoneda.revisar(m);
        }
        catch (PagoIncorrectoException ex){
            System.out.println(ex.getMessage());
            return null;
        }
        try {
            ComparaPrecio.compara(m.getValor(), precio); //FALTA CAMBIAR ENUMERACION PARA PRECIOS
        }
        catch (PagoInsuficienteException ex){
            System.out.println(ex.getMessage());
            monVu.addObjeto(m);
            return null;
        }

        switch (cual) {
            case COCA:
                bebida = coca.getObjeto();
                break;
            case SPRITE:
                bebida = sprite.getObjeto();
                break;
            case SNICKERS:
                dulce = snicker.getObjeto();
            case SUPER8:
                dulce = super8.getObjeto();
        }
        try {
            RevisaProducto.revisar(bebida); //Revisa si es que bebida es nulo
        }
        catch (NoHayProductoException ex){
            try {
                RevisaProducto.revisar(dulce); //En caso que bebida sea nulo, revisa si dulce es nulo para confirmar que no hay del producto que se pidió
            }
            catch (NoHayProductoException ex2){
                System.out.println(ex.getMessage());
                monVu.addObjeto(m);
                return null;
            }
        }
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
        if (bebida == null){
            return dulce;
        }
        else return bebida;
    }
    public Moneda getVuelto(){ // retorna una moneda desde el deposito de vuelto, hay que llamarla hasta que quede vacio
        return monVu.getObjeto();
    }
}
