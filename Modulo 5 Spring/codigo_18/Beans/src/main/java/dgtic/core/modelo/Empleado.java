package dgtic.core.modelo;

public class Empleado {

    private String nombre;
    private int edad;
    private IActividades actividades;

    public Empleado(){}

    public Empleado(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public IActividades getActividades() {
        return actividades;
    }

    public void setActividades(IActividades actividades) {
        this.actividades = actividades;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }
}
