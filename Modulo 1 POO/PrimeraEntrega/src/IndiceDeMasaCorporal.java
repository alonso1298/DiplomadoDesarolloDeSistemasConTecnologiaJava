import java.util.Scanner;

public class IndiceDeMasaCorporal {
    public static void main(String[] args) {
        // Calcular el indice de masa corporal
        System.out.println("Bienvenido a la calculadora de IMC");
        // imc = peso (kg) / cuadrado de la estatura (m)
        // 1. Pedir 3 datos a la persona (nombre, peso, estatura)
        Scanner teclado = new Scanner(System.in);
        System.out.println("Porfavor introduce tu nombre");
        String nombre = teclado.nextLine();
        System.out.println("Porfavor introduce tu peso en kg");
        float peso = teclado.nextFloat();
        System.out.println("Ingresa tu estatura en m");
        float estatura = teclado.nextFloat();
        // 2. Calcular el imc deacuerdo a la formula
        float imc = peso / (estatura * estatura);
        // 3. Desplegar el imc calculado
        System.out.println("Bienvenido " + nombre + " Su indice de masa corporal es: " + imc);
    }
}
