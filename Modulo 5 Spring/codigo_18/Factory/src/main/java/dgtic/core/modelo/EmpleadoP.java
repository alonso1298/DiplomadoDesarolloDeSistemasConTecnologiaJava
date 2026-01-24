package dgtic.core.modelo;

import java.util.Properties;

public class EmpleadoP {
    private String nombre;
    private int edad;
    private Properties actividades;

    public EmpleadoP() {
    }

    public EmpleadoP(String nombre) {
        this.nombre = nombre;
    }

    public Properties getActividades() {
        return actividades;
    }

    public void setActividades(Properties actividades) {
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
