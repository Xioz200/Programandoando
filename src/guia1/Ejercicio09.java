package guia1;

import java.util.Scanner;

public class Ejercicio09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String usuarioCorrecto = "admin";
        String contrasenaCorrecta = "1234";

        System.out.print("Ingrese el usuario: ");
        String usuario = sc.nextLine();

        System.out.print("Ingrese la contrasena: ");
        String contrasena = sc.nextLine();

        if (usuario.equals(usuarioCorrecto) &&
            contrasena.equals(contrasenaCorrecta)) {
            System.out.println("Bienvenido.");
        } else {
            System.out.println("Credenciales incorrectas.");
        }

        sc.close();
    }
}
