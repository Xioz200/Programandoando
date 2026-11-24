
package guia2.ejercicios;

import javax.swing.JOptionPane;

public class Ejercicio2 {

    public static void main(String[] args) {

        try {

            String entrada = JOptionPane.showInputDialog(
                "Ingrese la temperatura en grados Celsius:"
            );

            double celsius = Double.parseDouble(entrada);

            double fahrenheit = (celsius * 9 / 5) + 32;

            JOptionPane.showMessageDialog(
                null,
                celsius + " grados Celsius equivalen a "
                + fahrenheit + " grados Fahrenheit."
            );

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                null,
                "Error: debe ingresar un valor numerico valido."
            );
        }
    }
}
