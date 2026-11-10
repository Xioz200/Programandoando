package guia1;

import java.util.Scanner;

public class Ejercicio21 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese un numero: ");
        int numero = sc.nextInt();

        long factorial = 1;

        if (numero < 0 || numero > 20) {

            System.out.println("Numero fuera del rango permitido.");

        } else {

            for (int i = 1; i <= numero; i++) {

                factorial *= i;

            }

            System.out.println(
                "El factorial de " + numero + " es: " + factorial
            );

        }

        sc.close();
    }
}
