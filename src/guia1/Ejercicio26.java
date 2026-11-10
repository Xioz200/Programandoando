package guia1;

import java.util.Scanner;

public class Ejercicio26 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] numeros = {5, 10, 5, 20, 5, 30, 10, 40, 5, 50};

        System.out.print("Ingrese el numero que desea buscar: ");
        int buscado = sc.nextInt();

        int contador = 0;

        for (int i = 0; i < numeros.length; i++) {

            if (numeros[i] == buscado) {
                contador++;
            }

        }

        System.out.println(
            "El numero " + buscado + " aparece " + contador + " veces."
        );

        sc.close();
    }
}
