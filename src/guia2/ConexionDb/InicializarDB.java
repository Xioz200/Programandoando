package guia2.ConexionDb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class InicializarDB {

    public static void crearTablas() {

        String sqlProductos = "CREATE TABLE IF NOT EXISTS productos ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "nombre TEXT NOT NULL,"
                + "precio REAL NOT NULL,"
                + "cantidad INTEGER NOT NULL"
                + ");";

        String sqlUsuarios = "CREATE TABLE IF NOT EXISTS usuarios ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "username TEXT NOT NULL UNIQUE,"
                + "password TEXT NOT NULL"
                + ");";

        String sqlLibros = "CREATE TABLE IF NOT EXISTS libros ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "titulo TEXT NOT NULL,"
                + "autor TEXT NOT NULL,"
                + "anio INTEGER NOT NULL,"
                + "genero TEXT NOT NULL"
                + ");";

        try (Connection conexion = ConexionDB.getConexion()) {

            if (conexion == null) {
                System.out.println("No se pudo conectar con la base de datos.");
                return;
            }

            try (Statement stmt = conexion.createStatement()) {
                stmt.execute(sqlProductos);
                stmt.execute(sqlUsuarios);
                stmt.execute(sqlLibros);
            }

            System.out.println("Tablas creadas correctamente.");

            insertarUsuarios(conexion);
            insertarLibros(conexion);

        } catch (SQLException e) {
            System.out.println("Error al inicializar la base de datos: " + e.getMessage());
        }
    }

    private static void insertarUsuarios(Connection conexion) throws SQLException {

        String sql = "INSERT OR IGNORE INTO usuarios (username, password) VALUES (?, ?)";

        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {

            pstmt.setString(1, "admin");
            pstmt.setString(2, "admin123");
            pstmt.executeUpdate();

            pstmt.setString(1, "empleado");
            pstmt.setString(2, "emp456");
            pstmt.executeUpdate();
        }

        System.out.println("Usuarios iniciales registrados.");
    }

    private static void insertarLibros(Connection conexion) throws SQLException {

        String sql = "INSERT INTO libros (titulo, autor, anio, genero) "
                + "SELECT ?, ?, ?, ? "
                + "WHERE NOT EXISTS (SELECT 1 FROM libros WHERE titulo = ? AND autor = ?)";

        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {

            insertarLibro(pstmt, "Cien años de soledad",
                    "Gabriel García Márquez", 1967, "Novela");

            insertarLibro(pstmt, "El principito",
                    "Antoine de Saint-Exupéry", 1943, "Fábula");

            insertarLibro(pstmt, "Don Quijote de la Mancha",
                    "Miguel de Cervantes", 1605, "Clásico");
        }

        System.out.println("Libros iniciales registrados.");
    }

    private static void insertarLibro(PreparedStatement pstmt,
            String titulo, String autor, int anio, String genero)
            throws SQLException {

        pstmt.setString(1, titulo);
        pstmt.setString(2, autor);
        pstmt.setInt(3, anio);
        pstmt.setString(4, genero);
        pstmt.setString(5, titulo);
        pstmt.setString(6, autor);

        pstmt.executeUpdate();
    }
}