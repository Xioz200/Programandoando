
package guia2.vista;

import guia2.dao.LibroDAO;
import guia2.modelo.Libro;
import guia2.modelo.Usuario;

import javax.swing.JOptionPane;
import java.util.List;

public class MenuPrincipal {

    private LibroDAO libroDAO;

    public MenuPrincipal() {
        libroDAO = new LibroDAO();
    }

    public void mostrarMenu(Usuario usuario) {
        boolean sesionActiva = true;

        while (sesionActiva) {
            String opcion = JOptionPane.showInputDialog(
                    null,
                    "BIBLIOTECA DIGITAL DE LIBROS\n\n"
                    + "Usuario: " + usuario.getUsername() + "\n\n"
                    + "1. Registrar libro\n"
                    + "2. Consultar libros\n"
                    + "3. Actualizar libro\n"
                    + "4. Eliminar libro\n"
                    + "5. Cerrar sesión\n\n"
                    + "Seleccione una opción:"
            );

            if (opcion == null) {
                sesionActiva = false;
                continue;
            }

            switch (opcion.trim()) {
                case "1":
                    agregarLibro();
                    break;

                case "2":
                    verTodos();
                    break;

                case "3":
                    actualizarLibro();
                    break;

                case "4":
                    eliminarLibro();
                    break;

                case "5":
                    JOptionPane.showMessageDialog(
                            null,
                            "Sesión cerrada correctamente."
                    );
                    sesionActiva = false;
                    break;

                default:
                    JOptionPane.showMessageDialog(
                            null,
                            "Opción no válida."
                    );
                    break;
            }
        }
    }

    private void agregarLibro() {
        String titulo = JOptionPane.showInputDialog(
                null, "Ingrese el título del libro:"
        );
        if (titulo == null) return;

        String autor = JOptionPane.showInputDialog(
                null, "Ingrese el autor:"
        );
        if (autor == null) return;

        String anioTexto = JOptionPane.showInputDialog(
                null, "Ingrese el año de publicación:"
        );
        if (anioTexto == null) return;

        String genero = JOptionPane.showInputDialog(
                null, "Ingrese el género:"
        );
        if (genero == null) return;

        try {
            int anio = Integer.parseInt(anioTexto.trim());

            if (titulo.trim().isEmpty()
                    || autor.trim().isEmpty()
                    || genero.trim().isEmpty()) {
                JOptionPane.showMessageDialog(
                        null, "Todos los campos son obligatorios."
                );
                return;
            }

            Libro libro = new Libro(
                    titulo.trim(),
                    autor.trim(),
                    anio,
                    genero.trim()
            );

            if (libroDAO.agregar(libro)) {
                JOptionPane.showMessageDialog(
                        null, "Libro registrado correctamente."
                );
            } else {
                JOptionPane.showMessageDialog(
                        null, "No se pudo registrar el libro."
                );
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    null, "El año debe ser un número entero."
            );
        }
    }

    private void verTodos() {
        List<Libro> libros = libroDAO.verTodos();

        if (libros.isEmpty()) {
            JOptionPane.showMessageDialog(
                    null, "No hay libros registrados."
            );
            return;
        }

        StringBuilder mensaje = new StringBuilder(
                "LISTA DE LIBROS\n\n"
        );

        for (Libro libro : libros) {
            mensaje.append("ID: ").append(libro.getId()).append("\n");
            mensaje.append("Título: ").append(libro.getTitulo()).append("\n");
            mensaje.append("Autor: ").append(libro.getAutor()).append("\n");
            mensaje.append("Año: ").append(libro.getAnio()).append("\n");
            mensaje.append("Género: ").append(libro.getGenero()).append("\n");
            mensaje.append("--------------------------\n");
        }

        JOptionPane.showMessageDialog(
                null, mensaje.toString()
        );
    }

    private void actualizarLibro() {
        String idTexto = JOptionPane.showInputDialog(
                null, "Ingrese el ID del libro que desea actualizar:"
        );
        if (idTexto == null) return;

        try {
            int id = Integer.parseInt(idTexto.trim());

            String titulo = JOptionPane.showInputDialog(
                    null, "Nuevo título:"
            );
            if (titulo == null) return;

            String autor = JOptionPane.showInputDialog(
                    null, "Nuevo autor:"
            );
            if (autor == null) return;

            String anioTexto = JOptionPane.showInputDialog(
                    null, "Nuevo año:"
            );
            if (anioTexto == null) return;

            String genero = JOptionPane.showInputDialog(
                    null, "Nuevo género:"
            );
            if (genero == null) return;

            int anio = Integer.parseInt(anioTexto.trim());

            if (titulo.trim().isEmpty()
                    || autor.trim().isEmpty()
                    || genero.trim().isEmpty()) {
                JOptionPane.showMessageDialog(
                        null, "Todos los campos son obligatorios."
                );
                return;
            }

            Libro libro = new Libro(
                    titulo.trim(),
                    autor.trim(),
                    anio,
                    genero.trim()
            );

            libro.setId(id);

            if (libroDAO.actualizar(libro)) {
                JOptionPane.showMessageDialog(
                        null, "Libro actualizado correctamente."
                );
            } else {
                JOptionPane.showMessageDialog(
                        null, "No se encontró el libro o no se pudo actualizar."
                );
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    null, "El ID y el año deben ser números enteros."
            );
        }
    }

    private void eliminarLibro() {
        String idTexto = JOptionPane.showInputDialog(
                null, "Ingrese el ID del libro que desea eliminar:"
        );
        if (idTexto == null) return;

        try {
            int id = Integer.parseInt(idTexto.trim());

            int confirmacion = JOptionPane.showConfirmDialog(
                    null,
                    "¿Está seguro de eliminar el libro con ID " + id + "?",
                    "Confirmar eliminación",
                    JOptionPane.YES_NO_OPTION
            );

            if (confirmacion == JOptionPane.YES_OPTION) {
                if (libroDAO.eliminar(id)) {
                    JOptionPane.showMessageDialog(
                            null, "Libro eliminado correctamente."
                    );
                } else {
                    JOptionPane.showMessageDialog(
                            null, "No se encontró el libro."
                    );
                }
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    null, "El ID debe ser un número entero."
            );
        }
    }
}
