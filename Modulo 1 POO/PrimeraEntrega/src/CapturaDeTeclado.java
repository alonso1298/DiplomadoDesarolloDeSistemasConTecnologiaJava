import java.util.Scanner;

public class CapturaDeTeclado {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Captura de datos desde el teclado");

        // Captura String
        System.out.println("Como te llamas?");
        String nombre = "Desconocido";
        nombre = teclado.nextLine();
        System.out.println("Tu nombre es " + nombre);

        // Captura int
        System.out.println("Cuantos años tienes? ");
        int edad = 0;
        edad = teclado.nextInt();
        System.out.println("Tienes " + edad + " años");
    }
}
