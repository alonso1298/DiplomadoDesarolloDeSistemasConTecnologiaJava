public class IndiceMasaCorporalPOO {
    // Programa que usara el/la nutriologa para calcular el IMC de un paciente
    public static void main(String[] args) {
        System.out.println("Consultorio nutricion");
        System.out.println("Calculo del IMC");

        // Perdir datos
        Paciente objeto = new Paciente();
        objeto.nombre = "Lucia";
        objeto.edad = 90;
        objeto.genero = 'F';
        objeto.estatura = 1.80;
        objeto.peso = 70;

        // Calculo del IMC y despliegue
        double imc = objeto.calcularIMC();
        System.out.println("Tu IMC es de: " + imc);

        // Determinacion del nivel de peso
        System.out.println(objeto.estado());
    }
}
