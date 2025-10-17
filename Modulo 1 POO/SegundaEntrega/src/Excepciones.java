import java.util.InputMismatchException;
import java.util.Scanner;

public class Excepciones {
    public static void metodo (int numero){
        int algo = 100 / numero;
    }
    public static void main(String[] args) {
        System.out.println("Deteccion y manejo de exceciones");
        int numerador = 10;
        int denominador = 0;
        int resultado;
        String[] dias = {"Lun", "Mar", "Juev", "Vier"};
        Scanner teclado = new Scanner(System.in); //2
        System.out.println("Dame un numero");
        try {
            metodo(0);
            denominador = teclado.nextInt();
            resultado = numerador/denominador;
            System.out.println(numerador + "/" + denominador + " = " + resultado);
            System.out.println(dias[denominador]);
        }
        catch (ArithmeticException e) {
            // Class               Objeto
            // Lo que se ejecuta si sucede una ArithmeticException
            System.out.println("No puedes dividir por 0, es una indeterminacion");
            System.out.println(e.getMessage());
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Ese dia ("+denominador+") no existe");
        }
        catch (InputMismatchException e){
            System.out.println("Solo debes dar numero enteros");
        }
        catch (Exception e){
            System.out.println("Secedio algo raro");
        }
        teclado.close(); // Cerrar la conexion con el teclado
        System.out.println("Fin del Programa");
    }
}
