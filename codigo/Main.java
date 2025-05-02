package tarea1;

import java.util.ArrayList;

// El trabajo consiste en crear un expendedor de bebidas, que cuenta con una entrada para  monedas, un selector numerico para
//elegir el tipo bebida y un retorno de bebida. Cada vez que se le ingresa una moneda y un numero, retorne siempre una bebida
//del tipo solicitado, si queda alguna en el deposito interno correspondiente, si no, se la "traga" la moneda (no la devuelve).

class Deposito {
    ArrayList<Bebida> depositoB;
    ArrayList<Moneda> depositoM;
    public Deposito() {
        depositoB = new ArrayList<Bebida>();
        depositoM = new ArrayList<Moneda>();
    }
    public void addBebida(Bebida b) {
        depositoB.add(b);
    }
    public Bebida getBebida(){ // funciona como FIFO
        if (depositoB.size() > 0) {
            return depositoB.remove(0);
        }
        return null;
    }
    public void addMoneda(Moneda m) {
        // Agregar moneda al deposito de vuelto
        if (m != null) {
            depositoM.add(m);
        }
    }
    public Moneda getMoneda(){
        // Retornar una moneda del deposito de vuelto
        if (depositoM.size() > 0) {
            return (Moneda) depositoM.remove(0);
        }
        return null;
    }
}

abstract class Moneda { //
    public Moneda() {
    }
    public Moneda getSerie() { // retorna la referencia a la moneda
        return this;
    }
    public abstract int getValor(); // retorna el valor de la moneda

}
class Moneda1500 extends Moneda {
    public Moneda1500() {
        super();
    }
    public int getValor() {
        return 1500;
    }
}
class Moneda1000 extends Moneda {
    public Moneda1000() {
        super();
    }
    public int getValor() {
        return 1000;
    }
}
class Moneda500 extends Moneda {
    public Moneda500() {
        super();
    }
    public int getValor() {
        return 500;
    }
}
class Moneda100 extends Moneda {
    public Moneda100() {
        super();
    }
    public int getValor() {
        return 100;
    }
}
class Comprador {
    private String sonidoBebida;
    private int vueltoTotal;

    public Comprador(Moneda m, int cualBebida, Expendedor exp) {
        Bebida bebida = null;

        try {
            bebida = exp.comprarBebida(m, cualBebida); // Intenta comprar la bebida
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

abstract class Bebida {
    private int serie;
    public Bebida(int serie) {
        this.serie = serie;
    }
    public int getSerie() {
        return serie;
    }
    public abstract String beber(); // metodo abstracto que se implementa en las subclases
}

class CocaCola extends Bebida {
    public CocaCola(int serie) {
        super(serie);
    }
    public String beber() {
        return "cocacola";
    }
}

class Sprite extends Bebida {
    public Sprite(int serie) {
        super(serie);
    }
    public String beber() {
        return "sprite";
    }
}

public class Main {
    public static void main(String[] args) {
    }
}