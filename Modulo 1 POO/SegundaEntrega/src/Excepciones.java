import java.util.Scanner;

public class Excepciones {
    public static void main(String[] args) {
        System.out.println("Deteccion y manejo de exceciones");
        int numerador = 10;
        Scanner teclado = new Scanner(System.in); //2
        System.out.println("Dame un numero");
        int denominador = teclado.nextInt();
        String[] dias = {"Lun", "Mar", "Juev", "Vier"};

        try {
            int resultado = numerador/denominador;
            System.out.println(numerador + "/" + denominador + " = " + resultado);
            System.out.println(dias[denominador]);
        } catch (ArithmeticException e) {
            // Class               Objeto
            // Lo que se ejecuta si sucede una ArithmeticException
            System.out.println("No puedes dividir por 0, es una indeterminacion");
            System.out.println(e.getMessage());
        }
        teclado.close(); // Cerrar la conexion con el teclado
    }
}
