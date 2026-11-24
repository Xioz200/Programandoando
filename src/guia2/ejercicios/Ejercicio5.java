
package guia2.ejercicios;

import javax.swing.JOptionPane;

public class Ejercicio5 {

    public static void main(String[] args) {

        int numero = 0;
        boolean valido = false;

        while (!valido) {

            try {

                String entrada = JOptionPane.showInputDialog(
                    "Ingrese un numero entre 1 y 100:"
                );

                numero = Integer.parseInt(entrada);

                if (numero < 1 || numero > 100) {
                    throw new IllegalArgumentException(
                        "El numero debe estar entre 1 y 100."
                    );
                }

                valido = true;

            } catch (NumberFormatException e) {

                JOptionPane.showMessageDialog(
                    null,
                    "Error: debe ingresar un numero entero."
                );

            } catch (IllegalArgumentException e) {

                JOptionPane.showMessageDialog(
                    null,
                    "Error: el numero debe estar entre 1 y 100."
                );
            }
        }

        JOptionPane.showMessageDialog(
            null,
            "Numero valido ingresado: " + numero
        );
    }
}
