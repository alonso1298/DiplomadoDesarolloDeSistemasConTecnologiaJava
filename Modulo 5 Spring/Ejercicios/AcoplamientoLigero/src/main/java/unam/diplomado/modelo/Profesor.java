package unam.diplomado.modelo;

import java.util.ArrayList;

public class Profesor {

    private String nombre;
    private ArrayList<IResponsabilidades> responsabilidades
            = new ArrayList<>();

    public Profesor() {
        // responsabilidades = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<IResponsabilidades> getResponsabilidades() {
        return responsabilidades;
    }
}
