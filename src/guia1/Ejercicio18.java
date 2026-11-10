package guia1;

public class Ejercicio18 {
    public static void main(String[] args) {

        for (int tabla = 1; tabla <= 10; tabla++) {

            System.out.println("\nTabla del " + tabla);

            for (int i = 1; i <= 10; i++) {

                int resultado = tabla * i;

                System.out.println(
                    tabla + " x " + i + " = " + resultado
                );

            }
        }

    }
}
