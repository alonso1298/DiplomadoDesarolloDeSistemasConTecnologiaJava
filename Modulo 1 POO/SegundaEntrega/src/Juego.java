import java.util.Scanner;

public class Juego {
    public static void main(String[] args) {
        System.out.println("Juego");
        Scanner teclado = new Scanner(System.in);

        System.out.println("Jugador 1: Selecciona tu personaje: [1-4]");
        int numero = teclado.nextInt();
        Personaje jugador1 = new Personaje(numero);
        System.out.println(jugador1);

        System.out.println("Jugador 2: Selecciona tu personaje: [1-4]");
        numero = teclado.nextInt();
        Personaje jugador2 = new Personaje(numero);
        System.out.println(jugador2);
    }
}
