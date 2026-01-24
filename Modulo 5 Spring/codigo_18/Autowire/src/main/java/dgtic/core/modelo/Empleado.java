package dgtic.core.modelo;

import java.util.Collection;

public class Empleado {

    private String nombre;
    private int edad;
    private Collection<IActividades> actividades;

    public Empleado() {
    }

    public Empleado(String nombre) {
        this.nombre = nombre;
    }

    public Collection<IActividades> getActividades() {
        return actividades;
    }

    public void setActividades(Collection<IActividades> actividades) {
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
