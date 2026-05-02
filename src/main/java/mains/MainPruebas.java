package mains;

import expendedor.Expendedor;
import comprador.Comprador;
import expendedor.Inventario;
import monedas.*;

import java.util.ArrayList;
import java.util.Collections;

public class MainPruebas {
    public static void main(String[] args) {
        System.out.println("==== Probando Expendedor ====\n");

        Expendedor exp = new Expendedor(2);

        System.out.printf("%d Pruebas Exitosas para cada producto en inventario:", Inventario.values().length);
        for(int i = 1; i <= Inventario.values().length; i++){
            try {
                Comprador temp = new Comprador(new Moneda1000(), i, exp);
                System.out.printf("\n-> Prueba %d: comprador1 recibe Moneda de 1000 y compra %s:\n", i, temp.queSabor());
                System.out.printf("  - Consume: %s\n  - Vuelto: $%d", temp.queSabor(), temp.cuantoVuelto());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("\n\nProbando compra de CocaCola con Moneda de 500 (Pago Insuficiente):");
        try {
            Comprador comprador1 = new Comprador(new Moneda100(), 1, exp);
        } catch (Exception e) {
            System.out.println(" - Pago insuficiente: " + e.getMessage());
        }

        System.out.println("\nProbando compra de CocaCola sin entregar Noneda (Moneda Null):");
        try {
            Comprador comprador2 = new Comprador(null, 1, exp);
        } catch (Exception e) {
            System.out.println(" - Moneda null: " + e.getMessage());
        }

        System.out.println("\nProbando compra de Producto inexistente:");
        try {
            Comprador comprador3 = new Comprador(new Moneda1000(), 99, exp);
        } catch (Exception e) {
            System.out.println(" - Selección inválida: " + e.getMessage());
        }

        System.out.println("\nProbando excepción: Sin stock (comprar más de lo que queda)");
        try {
            new Comprador(new Moneda1000(), 5, exp);
            new Comprador(new Moneda1000(), 5, exp);
            new Comprador(new Moneda1000(), 5, exp);
        } catch (Exception e) {
            System.out.println(" - Sin stock: " + e.getMessage());
        }

        System.out.println("\n==== Ordenando Monedas ====\n");

        ArrayList<Moneda> monedas = new ArrayList<>();
        monedas.add(new Moneda500());
        monedas.add(new Moneda100());
        monedas.add(new Moneda1000());
        monedas.add(new Moneda500());
        monedas.add(new Moneda100());

        Collections.sort(monedas);

        for (Moneda m : monedas) {
            System.out.println(m.toString());
        }
    }
}