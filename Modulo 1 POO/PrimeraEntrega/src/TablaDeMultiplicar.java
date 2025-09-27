import java.util.Scanner;

public class TablaDeMultiplicar {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int numero;
        System.out.println("Bienvenido a la tabla de multiplicar");
        System.out.println("Ingresa a continuacion el numero de la tabla que deseas consultar: ");
        numero = teclado.nextInt();

        System.out.println("La tabla del " + numero + " es: ");
        for (int i = 1; i < 11; i++) {
            System.out.println(i + " x " + numero + " = " + i*numero);
        }
    }
}
