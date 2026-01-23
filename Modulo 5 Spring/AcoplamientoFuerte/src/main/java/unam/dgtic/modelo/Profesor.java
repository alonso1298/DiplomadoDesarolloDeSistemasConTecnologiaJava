package unam.dgtic.modelo;

public class Profesor {

    private String nombre;
    private Reponsabilidades responsabilidades;

    public Profesor(){
        responsabilidades = new Reponsabilidades();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Reponsabilidades getResponsabilidades() {
        return responsabilidades;
    }

    public void setResponsabilidades(Reponsabilidades responsabilidades) {
        this.responsabilidades = responsabilidades;
    }
}
