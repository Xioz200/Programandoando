package guia1;

import java.util.Scanner;

public class Ejercicio08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el valor de la compra: $");
        double compra = sc.nextDouble();

        double descuento = 0;

        if (compra < 0) {
            System.out.println("Valor de compra invalido.");
        } else {
            if (compra > 500000) {
                descuento = 0.20;
            } else if (compra > 200000) {
                descuento = 0.15;
            } else if (compra > 100000) {
                descuento = 0.10;
            }

            double valorDescuento = compra * descuento;
            double total = compra - valorDescuento;

            System.out.println("Valor original: $" + compra);
            System.out.println("Descuento: " + (descuento * 100) + "%");
            System.out.println("Valor descontado: $" + valorDescuento);
            System.out.println("Total a pagar: $" + total);
        }

        sc.close();
    }
}
