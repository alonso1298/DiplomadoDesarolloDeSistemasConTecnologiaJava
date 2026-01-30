package dgtic.core.modelo;

public class Servicio {
    private Persona persona;
    public Servicio() {
    }
    public Persona getPersona() {
        return persona;
    }
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public String toString() {
        return "Servicio{" +
                "persona=" + persona +
                '}';
    }
}
