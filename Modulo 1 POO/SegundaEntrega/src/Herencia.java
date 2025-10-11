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

        // Medico
        Medico o3 = new Medico();
        System.out.println(o3);
        o3.setNombre("Dr. Lopez");
        o3.setEspecialidad("Gereatria");
        o3.setEdad(33);
        System.out.println(o3);


    }
}
