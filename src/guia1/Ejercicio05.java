package guia1;


import java.util.Scanner;

public class Ejercicio05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese un anio: ");
        int anio = sc.nextInt();

        if (anio <= 0) {
            System.out.println("Anio invalido.");
        } else if (anio % 400 == 0 ||
                   (anio % 4 == 0 && anio % 100 != 0)) {
            System.out.println("El anio es bisiesto.");
        } else {
            System.out.println("El anio no es bisiesto.");
        }

        sc.close();
    }
}
