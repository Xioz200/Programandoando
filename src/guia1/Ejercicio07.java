package guia1;


import java.util.Scanner;

public class Ejercicio07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el primer numero: ");
        int num1 = sc.nextInt();

        System.out.print("Ingrese el segundo numero: ");
        int num2 = sc.nextInt();

        System.out.print("Ingrese el tercer numero: ");
        int num3 = sc.nextInt();

        if (num1 == num2 && num2 == num3) {
            System.out.println("Los tres numeros son iguales.");
        } else if (num1 == num2 && num1 > num3) {
            System.out.println("El mayor es " + num1 + ". Hay empate.");
        } else if (num1 == num3 && num1 > num2) {
            System.out.println("El mayor es " + num1 + ". Hay empate.");
        } else if (num2 == num3 && num2 > num1) {
            System.out.println("El mayor es " + num2 + ". Hay empate.");
        } else if (num1 > num2 && num1 > num3) {
            System.out.println("El mayor es " + num1);
        } else if (num2 > num1 && num2 > num3) {
            System.out.println("El mayor es " + num2);
        } else {
            System.out.println("El mayor es " + num3);
        }

        sc.close();
    }
}
