public class Herencia {
    public static void main(String[] args) {
        System.out.println("Herencia");

        // Creacion de objetos de la superclase Persona
        Persona o1 = new Persona();
        o1.setNombre("Ana");
        o1.setEdad(19);
        System.out.println(o1);

        // Pacientes
        Paciente o2 = new Paciente();
        System.out.println(o2);
    }
}
