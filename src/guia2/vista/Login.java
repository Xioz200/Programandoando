
package guia2.vista;

import guia2.dao.UsuarioDAO;
import guia2.modelo.Usuario;

import javax.swing.JOptionPane;

public class Login {

    private UsuarioDAO usuarioDAO;

    public Login() {
        usuarioDAO = new UsuarioDAO();
    }

    public Usuario iniciarSesion() {

        int intentos = 0;
        final int MAX_INTENTOS = 3;

        while (intentos < MAX_INTENTOS) {

            String username = JOptionPane.showInputDialog(
                    null,
                    "Ingrese su nombre de usuario:"
            );

            if (username == null) {
                return null;
            }

            String password = JOptionPane.showInputDialog(
                    null,
                    "Ingrese su contraseña:"
            );

            if (password == null) {
                return null;
            }

            Usuario usuario = usuarioDAO.buscarPorCredenciales(
                    username,
                    password
            );

            if (usuario != null) {
                JOptionPane.showMessageDialog(
                        null,
                        "¡Bienvenido, " + username + "!"
                );

                return usuario;

            } else {
                intentos++;

                JOptionPane.showMessageDialog(
                        null,
                        "Credenciales incorrectas. Intento "
                                + intentos + " de " + MAX_INTENTOS
                );
            }
        }

        JOptionPane.showMessageDialog(
                null,
                "Ha superado el número máximo de intentos. "
                        + "La aplicación se cerrará."
        );

        return null;
    }
}
    