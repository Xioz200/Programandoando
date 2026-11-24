
package guia2.ConexionDb;

import java.sql.Connection;
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

        try (Connection conexion = ConexionDB.getConexion();
             Statement stmt = conexion.createStatement()) {

            stmt.execute(sqlProductos);
            stmt.execute(sqlUsuarios);
            stmt.execute(sqlLibros);

            System.out.println("Tabla productos creada correctamente.");
            System.out.println("Tabla usuarios creada correctamente.");
            System.out.println("Tabla libros creada correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al crear las tablas: " + e.getMessage());
        }
    }
}
