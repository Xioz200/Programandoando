package guia1;

public class Ejercicio16 {
    public static void main(String[] args) {

        int suma = 0;

        for (int i = 1; i <= 50; i++) {

            if (i % 2 != 0) {
                suma += i;
            }

        }

        System.out.println("La suma de los impares es: " + suma);

    }
}
