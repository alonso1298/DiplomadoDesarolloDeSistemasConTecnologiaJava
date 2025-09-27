import java.util.Scanner;

public class Ciclos {
    public static void main(String[] args) {
        System.out.println("Ciclos");
        System.out.println("\twhile");

        // Ciclo cuando conozco el numero de vueltas/iteraciones
        int vueltas = 10;
        int contador = 0;
        while (contador < vueltas){
            contador++;
            System.out.println("Dando una vuelta.." + contador);
        }

        // Cuando solo conozco la condicion de parada/finalizacion
        int numero = 0;
        int aleatorio = 77;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Juguemos a adivinar el numero que pense");
        // Estaremos en el ciclo HASTA que numero == aleatorio
        // Estaremos en el ciclo MIENTRAS que numero != aleatorio
        while (numero != aleatorio){
            System.out.println("Dame el numero que pensaste");
            numero = teclado.nextInt();
        }
        System.out.println("Lo adivinaste");

        numero = 14;
        aleatorio = 14;
        do {
            System.out.println("Dame el numero que pensaste");
            numero = teclado.nextInt();
        } while (numero != aleatorio);{
            System.out.println("Fin del programa");
        }
    }
}
