
package guia2.ejercicios;

import javax.swing.JOptionPane;

public class Ejercicio3 {

    public static void main(String[] args) {

        try {

            String pesoTexto = JOptionPane.showInputDialog(
                "Ingrese su peso en kilogramos:"
            );

            double peso = Double.parseDouble(pesoTexto);

            String estaturaTexto = JOptionPane.showInputDialog(
                "Ingrese su estatura en metros:"
            );

            double estatura = Double.parseDouble(estaturaTexto);

            if (estatura == 0) {
                throw new ArithmeticException(
                    "La estatura no puede ser cero."
                );
            }

            double imc = peso / (estatura * estatura);

            JOptionPane.showMessageDialog(
                null,
                "Su indice de masa corporal es: " + imc
            );

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                null,
                "Error: debe ingresar valores numericos."
            );

        } catch (ArithmeticException e) {

            JOptionPane.showMessageDialog(
                null,
                "Error: la estatura no puede ser cero."
            );
        }
    }
}
