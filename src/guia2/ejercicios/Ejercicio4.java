
package guia2.ejercicios;

import javax.swing.JOptionPane;

public class Ejercicio4 {

    public static void main(String[] args) {

        int[] numeros = {10, 20, 30, 40, 50};

        try {

            String entrada = JOptionPane.showInputDialog(
                "Ingrese la posicion del arreglo (0 a 4):"
            );

            int posicion = Integer.parseInt(entrada);

            JOptionPane.showMessageDialog(
                null,
                "El valor en la posicion " + posicion
                + " es: " + numeros[posicion]
            );

        } catch (ArrayIndexOutOfBoundsException e) {

            JOptionPane.showMessageDialog(
                null,
                "Error: la posicion ingresada no existe en el arreglo."
            );
        }
    }
}
