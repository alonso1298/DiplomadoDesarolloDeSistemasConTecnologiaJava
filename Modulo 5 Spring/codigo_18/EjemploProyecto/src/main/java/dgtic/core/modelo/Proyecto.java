package dgtic.core.modelo;

import java.util.ArrayList;

public class Proyecto {
    private String idProyecto;
    private String nombre;
    private String descripcion;
    final ArrayList<Persona> personas = new ArrayList<>();

    public Proyecto() {

    }

    public String getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(String idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList<Persona> getPersonas() {
        return personas;
    }
}
