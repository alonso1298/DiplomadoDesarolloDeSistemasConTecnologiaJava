public class Arreglos {
    public static void main(String[] args) {
        System.out.println("Arreglos de 1 Dimension");
        // tipo [] nimbre = new tipo [tamaño]
        // tipo [] nombre = { lista de valores del tipo especificado }

        System.out.println("Arreglos de tipo de datos primitivos");
        double [] calificaciones = new double [18];
        // Para hacer referencia a un elemento del arreglo:
        // nombre[indice]

        System.out.println("Elemento con indice 6 - " + calificaciones[6] );
        calificaciones[6] = 9.76;
        System.out.println("Elemento con indice 6 - " + calificaciones[6] );


        System.out.println(calificaciones);
        // Ciclo para imprimir todos los elementos del arreglo
        for (int i = 0; i < calificaciones.length; i++) {
            System.out.println("Elemento con indice: " + i + " = " + calificaciones[i]);
        }

        int numero = 0;
        while (numero < 18) {
            System.out.println("Elemento con indice" + numero + " = " + calificaciones[numero]);
            numero++;
        }

        System.out.println("Arreglos de objetos");
        String[] estuddiantes = {"Alonso", "Mauricio", "Fabiola", "Lisset"};

        int[] asistencias = {8,7,8,8};
        System.out.println(asistencias.length); // 4

        asistencias = new int[5];
        System.out.println(asistencias.length); // 5

        for (int i = 0; i < estuddiantes.length; i++) {
            System.out.println("Estudiantes con indice " + i + " = " + estuddiantes[i]);
        } // Fin del for

        System.out.println("Arreglo 2 Dimensiones (matriz)");
        double [][] parciales = new double[5][6];


    } // Fin del main
} // Fin del class
