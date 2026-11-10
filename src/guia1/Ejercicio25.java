package guia1;

public class Ejercicio25 {
    public static void main(String[] args) {

        int[] numeros = {15, 80, 25, 100, 45, 60};

        int menor = numeros[0];

        for (int i = 1; i < numeros.length; i++) {

            if (numeros[i] < menor) {
                menor = numeros[i];
            }

        }

        System.out.println("El numero menor es: " + menor);

    }
}
