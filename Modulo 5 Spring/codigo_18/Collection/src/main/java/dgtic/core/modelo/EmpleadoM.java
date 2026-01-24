package dgtic.core.modelo;

public class EmpleadoM {
    private String nombre;
    private int edad;
    private Map<String,IActividades> actividades;

    public EmpleadoM() {
    }

    public EmpleadoM(String nombre) {
        this.nombre = nombre;
    }

    public Map<String, IActividades> getActividades() {
        return actividades;
    }

    public void setActividades(Map<String, IActividades> actividades) {
        this.actividades = actividades;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "edad=" + edad +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
