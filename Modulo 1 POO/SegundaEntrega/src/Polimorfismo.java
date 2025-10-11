public class Polimorfismo {
    public static void main(String[] args) {
        System.out.println("Polimorfismo");
        Persona o1 = new Persona();
        Paciente o2 = new Paciente();
        Medico o3 = new Medico();

        Persona[] grupo = new Persona[4];

        grupo[0] = o1; // Persona
        grupo[1] = o2; // Paciente
        grupo[2] = o3; // Medico
        grupo[3] = new Paciente(); // Paciente

        for (int i = 0; i < 4; i++) {
            System.out.println("Elemento " + i + " = " + grupo[i].getNombre());
        }

        // Medico objetoM = new Persona(); // ERROR
        Persona objetoP = new Medico(); // OK
        // SuperClase objeto = new SubClase();
    }
}
