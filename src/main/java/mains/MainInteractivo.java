package mains;

import excepciones.NoHayProductoException;
import excepciones.PagoIncorrectoException;
import excepciones.PagoInsuficienteException;
import expendedor.Expendedor;
import comprador.Comprador;
import monedas.*;
import java.util.Scanner;
/**
 * Clase main que ejecuta la interfaz interactiva del expendedor.
 * Permite al usuario seleccionar productos y pagar con distintas monedas a través de la consola.
 *
 *
 * @author jaocSec
 */
public class MainInteractivo {
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        Expendedor exp= new Expendedor(5);

        System.out.println("---EXPENDEDOR---");

        while(true){
            try{
                System.out.println("\nLISTA DE PRODUCTOS");
                System.out.println("1. CocaCola ($1000)");
                System.out.println("2. Sprite ($1000)");
                System.out.println("3. Fanta ($1000)");
                System.out.println("4. Snickers ($800)");
                System.out.println("5. Super8 ($600)");
                System.out.println("0. SALIR");

                System.out.println("\nIntroduzca el codigo del producto sin el punto: ");
                int seleccion= sc.nextInt();

                if(seleccion == 0)
                {
                    System.out.println("SALIENDO...");
                    break;
                }

                System.out.println("Ingrese valor de la moneda (100, 500, 1000): ");
                int valorMoneda= sc.nextInt();
                Moneda mIngresada= crearMoneda(valorMoneda);

                Comprador c= new Comprador(mIngresada, seleccion, exp);

                System.out.println("Ha comprado un(a): " + c.queSabor());
                System.out.println("Vuelto: " + c.cuantoVuelto());
            }catch (PagoIncorrectoException | PagoInsuficienteException | NoHayProductoException e){
                System.out.println("\nError!: " + e.getMessage());
            }catch (Exception e){
                System.out.println(e.getMessage());
                sc.next();
            }
        }
        sc.close();
    }

    /**
     * Metodo utilitario para instanciar la moneda con el valor ingresado por el usuario.
     * @param valor Valor de la moneda (100, 500, 1000)
     * @return una instancia de {@link Moneda} con el mismo valor ingresado o {@code null} si el valor es invalido.
     */
    private static Moneda crearMoneda(int valor){
        switch(valor){
            case 100:
                return new Moneda100();
            case 500:
                return new Moneda500();
            case 1000:
                return new Moneda1000();
            default:
                return null;
        }
    }
}

