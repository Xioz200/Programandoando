package guia1;


import java.util.Scanner;

public class Ejercicio06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese una nota entre 0 y 100: ");
        double nota = sc.nextDouble();

        if (nota < 0 || nota > 100) {
            System.out.println("Nota fuera del rango permitido.");
        } else if (nota >= 90) {
            System.out.println("Excelente.");
        } else if (nota >= 80) {
            System.out.println("Bueno.");
        } else if (nota >= 70) {
            System.out.println("Aceptable.");
        } else if (nota >= 60) {
            System.out.println("Insuficiente.");
        } else {
            System.out.println("Reprobado.");
        }

        sc.close();
    }
}
