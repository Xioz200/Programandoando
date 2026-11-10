package guia1;

public class Ejercicio24 {
    public static void main(String[] args) {

        int[] numeros = {15, 80, 25, 100, 45, 60};

        int mayor = numeros[0];

        for (int i = 1; i < numeros.length; i++) {

            if (numeros[i] > mayor) {
                mayor = numeros[i];
            }

        }

        System.out.println("El numero mayor es: " + mayor);

    }
}
