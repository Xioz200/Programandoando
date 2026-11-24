
package guia2.ejercicios;

import javax.swing.JOptionPane;

public class Ejercicio1 {

    public static void main(String[] args) {

        try {
            String numero1 = JOptionPane.showInputDialog(
                "Ingrese el primer número entero:"
            );

            if (numero1 == null) {
                return;
            }

            String numero2 = JOptionPane.showInputDialog(
                "Ingrese el segundo número entero:"
            );

            if (numero2 == null) {
                return;
            }

            int a = Integer.parseInt(numero1);
            int b = Integer.parseInt(numero2);

            int resultado = a / b;

            JOptionPane.showMessageDialog(
                null,
                "El resultado de la división es: " + resultado
            );

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                null,
                "Error: debe ingresar números enteros."
            );

        } catch (ArithmeticException e) {

            JOptionPane.showMessageDialog(
                null,
                "Error: no se puede dividir entre cero."
            );
        }
    }
}
