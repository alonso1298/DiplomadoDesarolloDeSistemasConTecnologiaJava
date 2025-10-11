public class Paciente extends Persona{
    //Atributos
    private String expediente;
    private String  padeciento;


    // Métodos
    public Paciente() {
        this.expediente = "abc001/2025";
        this.padeciento = "Desconocido";
    }

    public String getExpediente() {
        return expediente;
    }

    public void setExpediente(String expediente) {
        this.expediente = expediente;
    }

    public String getPadeciento() {
        return padeciento;
    }

    public void setPadeciento(String padeciento) {
        this.padeciento = padeciento;
    }

    @Override
    public String toString() {
        return getNombre() + " (" + getGenero() + "). " + getEdad() + " años " +
                "expediente='" + expediente + '\'' +
                ", padeciento='" + padeciento + '\'' +
                '}';
    }

    public static String listaDePacientes(){
        // Ejecutamos un SELECT nombre FROM tablaDePacientes en la BD
        return "Eligio\nAlonso\nLucia\nJose";
    }
}
