import java.util.Scanner;

public class Switch {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int numero = 0;
        System.out.println("Ejemplo de switch");
        System.out.println("Dame un numero del 1 al 7:");
        numero = teclado.nextInt();
        // 1 = Lunes, 2 = Martes, 3 = Miercoles, 4 = Jueves, 5 = Viernes, 6 = Sabado, 7 = Domingo
        // Switch como sentencia
        switch (numero){
            case 1: // Lunes
                System.out.println("El numero " + numero + " corresponde al lunes");
                break;
            case 2:
                System.out.println("El numero " + numero + " corresponde al martes");
                break;
            case 3:
                System.out.println("El numero " + numero + " corresponde al miercoles");
                break;
            case 4:
                System.out.println("El numero " + numero + " corresponde al jueves");
                break;
            case 5:
                System.out.println("El numero " + numero + " corresponde al viernes");
                break;
            case 6:
                System.out.println("El numero " + numero + " corresponde al sabado");
                break;
            case 7:
                System.out.println("El numero " + numero + " corresponde al domingo");
                break;
            default: // Si no fue ninguno de los casos anteriores
                System.out.println("Opcion no valida");
                break;
        }

        // Switch como expresión compatible con java 14 en adelante
        String dia = "Desconocido";
        dia =  switch (numero){
          case 1 -> "LUNES";
          case 2 -> "MARTES";
          case 3 -> "MIERCOLES";
          case 4 -> "JUEVES";
          case 5 -> "VIERNES";
          case 6 -> "SABADO";
          case 7 -> "DOMINGO";
          default -> "No valido";
        };
        System.out.println("El numero " + numero + " es " + dia);
    }
}
