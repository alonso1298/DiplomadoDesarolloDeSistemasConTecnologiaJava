public class PacientePrimeraEntrega {
    //Define a los pacientes de un consultorio de nutricion
    // Atributos(nombre, edad, genero, peso, estatura, ...)
    public String nombre;
    public int edad;
    public char genero;
    public double peso;
    public double estatura;

    public double calcularIMC() {
        return this.peso / (this.estatura * this.estatura);
    }

    public String estado() {
        double imc = this.calcularIMC();
        if (imc < 18.5) {
            return "Tienes bajo peso, cuidado";
        } else if (imc < 25) {
            return "IMC ideal, vas bien";
        } else if (imc < 30) {
            return "Tienes sobrepeso, cuidate";
        } else {
            return "Tienes obesidad";
        }
    }
}
