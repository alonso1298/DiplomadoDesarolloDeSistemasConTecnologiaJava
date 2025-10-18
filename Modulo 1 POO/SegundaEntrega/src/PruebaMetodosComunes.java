// Ejemeplo de uso de equals
public class PruebaMetodosComunes {
    public static void main(String[] args) {
        System.out.println("Metodos comunes en las clases");
        System.out.println("** equals()");

        Libro libroA = new Libro();
        libroA.setTitulo("El principito");
        libroA.setAutor("Antoine de Saint-Exupéry");
        libroA.setEdicion(1);
        System.out.println(libroA);

        Libro libroB = new Libro();
        libroB.setTitulo("El principito");
        libroB.setAutor("Antoine de Saint-Exupéry");
        libroB.setEdicion(2);
        System.out.println(libroB);

        if (libroA == libroB){ // Pregunta por referencias
            System.out.println("Iguales");
        }else {
            System.out.println("Diferentes");
        }

        if(libroA.equals(libroB)){ // Pregunta por contenido
            System.out.println("Para equals son iguales");
        }else {
            System.out.println("Para equals son diferentes");
        }

        System.out.println("HashCode()");
        System.out.println("Hash code: "+ libroA.hashCode());
        System.out.println("Hash code: "+ libroB.hashCode());

        System.out.println("** compareTo()");
        Alumno uno = new Alumno();
        uno.setNombre("Alonso");
        uno.setMatricula("12345");

        Alumno dos = new Alumno();
        dos.setNombre("Eligio");
        dos.setMatricula("54321");

        System.out.println(uno.compareTo(dos));
    }
}
