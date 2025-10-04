import java.util.Scanner;

// Alonso Sagrero Granados

public class Practica1 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // Captura de datos
        System.out.println("Bienvenido a la universidad");
        System.out.println("Porfavor ingrese su nombre: ");
        String nombre = teclado.nextLine();
        System.out.println("Porfavor ingrese su edad: ");
        int edad = teclado.nextInt();
        System.out.println("Porfavor ingrese el numero de materias cursadas: ");
        int materias = teclado.nextInt();
        System.out.println("Ingrese su promedio final");
        double promedio = teclado.nextDouble();
        System.out.println("Ingrese la cantidad de creditos cursado");
        int creditos = teclado.nextInt();

        // Porcentaje de creditos faltantes
        int creditosTotales = 120;
        int creditosFaltantes = 120 - creditos;
        double porcentajeFaltante = ((double) creditosFaltantes / creditosTotales) * 100;

        System.out.println("Estimado alumno " + nombre + " su unformacion es la siguiente: ");
        System.out.println("El numeor de materias cursadas es de: " + materias);
        // Uso de las funciones
        System.out.println(evaluarEdad(edad));
        System.out.println(estadoAcademico(promedio, creditos));
        System.out.println(evaluarElegibilidadBeca(promedio, creditos));

        System.out.println("Tus creditos faltantes son: " + porcentajeFaltante + "%");

    }

    public static String evaluarEdad(int edad){
        if (edad >= 18){
            return "Eres mayor de edad";
        }else {
            return "Eres menor de edad";
        }
    }

    public static String estadoAcademico(double promedio, int creditos){
        if (promedio >= 8.0 && creditos >= 20){
            return "Eres un alumno rregular";
        }else {
            return "Eres alumno irrgular";
        }
    }

    public static String evaluarElegibilidadBeca(double promedio, int creditos){
        if (promedio >= 9 && creditos >= 30){
            return "Eres un candidato legible para la beca";
        }else {
            return "No eres candidato para la beca";
        }
    }
}
