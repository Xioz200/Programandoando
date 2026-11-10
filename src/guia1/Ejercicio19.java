package guia1;

public class Ejercicio19 {
    public static void main(String[] args) {

        int contador = 0;

        for (int i = 1; i <= 200; i++) {

            if (i % 10 == 0) {
                contador++;
            }

        }

        System.out.println(
            "Cantidad de multiplos de 10: " + contador
        );

    }
}
