package guia1;

import java.util.Scanner;

public class Ejercicio29 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese una palabra o frase: ");
        String texto = sc.nextLine();

        for (int i = 0; i < texto.length(); i++) {

            System.out.println(texto.charAt(i));

        }

        sc.close();
    }
}
