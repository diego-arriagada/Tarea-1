/**
 * La clase `MainInteractivo` es una clase donde se puede utilizar
 * las funciones de la máquina expendedora sin limitaciones, hasta que el
 * usuario decida detenerse
 *
 * Contiene múltiples depósitos de productos y un depósito para monedas devueltas.
 * La clase permite comprar productos y calcular el vuelto.
 *
 * @author Diego Arriagada
 * @author Victor Galaz
 * @author Matias Catril
 * @version 1.0
 */

import java.util.Scanner;
public class MainInteractivo {
    public static void main(String[] args) {
        boolean a = true;
        Expendedor exp = new Expendedor(99);
        Scanner scan = new Scanner(System.in);
        while (a){
            System.out.println("Indique el numero del producto que desea comprar, si desea finalizar ingrese 0");
            System.out.println("Op: 1 -> COCA, 2 -> SPRITE, 3 -> FANTA, 4 -> SNICKERS, 5 -> SUPER8, 0 -> SALIR");
            String prod = scan.nextLine();
            int producto = Integer.parseInt(prod);
            if (producto == 0){
                System.out.println("Prueba Finalizada");
                break;
            }
            System.out.println("Indique el valor de la moneda a utilizar");
            System.out.println("Op: 100, 500, 1000");
            String mon = scan.nextLine();
            int mone = Integer.parseInt(mon);
            Moneda m = null;
            if (mone == 100){
                m = new Moneda100();
            } else if (mone == 500) {
                m = new Moneda500();
            } else if (mone == 1000) {
                m = new Moneda1000();
            }
            Comprador c = new Comprador(m, producto,exp);


        }
    }
}