
package guia2.ejercicios;

import javax.swing.JOptionPane;

public class Ejercicio6 {

    public static void main(String[] args) {

        try {

            String nombre = JOptionPane.showInputDialog(
                "Ingrese su nombre:"
            );

            if (nombre == null) {
                throw new NullPointerException(
                    "El usuario cancelo la ventana."
                );
            }

            JOptionPane.showMessageDialog(
                null,
                "Bienvenido: " + nombre
            );

        } catch (NullPointerException e) {

            JOptionPane.showMessageDialog(
                null,
                "Advertencia: no se ingreso un nombre porque se cancelo la ventana."
            );
        }
    }
}
