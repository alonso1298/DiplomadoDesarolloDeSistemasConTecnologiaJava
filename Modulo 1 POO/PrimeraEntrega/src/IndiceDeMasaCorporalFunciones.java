import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class IndiceDeMasaCorporalFunciones {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // Bienvenida del programa e ingreso de datos
        System.out.println("Ingresa tu nombre");
        String nombre = teclado.nextLine();
        System.out.println("Ingresa tu estatura en metros");
        double estatura = teclado.nextDouble();
        System.out.println("Ingresa tu peso en Kilogramos");
        double peso = teclado.nextDouble();

        // Utiliza funcion calcula imc y guarda los datos en la variable imc
        double imc = calculaimc(peso, estatura);


        System.out.println("Hola " + nombre + " gracias por usar el programa IMC");
        System.out.println("Tu Indice de masa corporal es: " + imc);
        System.out.println("Y tu valoracion es la siguiente: ");
        // Manda a imprimir la funcion estado con la variable imc para el calculo
        System.out.println(estado(imc));
    }

    public static double calculaimc(double peso, double estatura) {
        return peso / (estatura * estatura);
    }

    public static String estado(double imc) {
        if (imc < 18.5) {
            return "Tienes bajo peso, cuidado";
        } else if (imc < 25) {
            return "IMC ideal, vas bien";
        } else if (imc < 30) {
            return "Tienes sobrepeso, cuidate";
        } else {
            return "Tienes obesidad";
        }
    }

}
