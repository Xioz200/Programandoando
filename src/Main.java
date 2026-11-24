
import guia2.ConexionDb.InicializarDB;
import guia2.modelo.Usuario;
import guia2.vista.Login;
import guia2.vista.MenuPrincipal;

public class Main {

    public static void main(String[] args) {

        // Inicializar la base de datos
        InicializarDB.crearTablas();

        // Iniciar sesión
        Login login = new Login();
        Usuario usuario = login.iniciarSesion();

        // Mostrar el menú si el usuario inició sesión
        if (usuario != null) {
            MenuPrincipal menu = new MenuPrincipal();
            menu.mostrarMenu(usuario);
        }
    }
}
