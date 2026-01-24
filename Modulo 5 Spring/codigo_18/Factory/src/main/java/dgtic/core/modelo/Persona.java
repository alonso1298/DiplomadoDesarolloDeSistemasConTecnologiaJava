package dgtic.core.modelo;

public class Persona {
    private String nombre;
    private FabricaCoches coche;

    public Persona(){}

    public String getNomebre() {
        return nombre;
    }

    public void setNomebre(String nombre) {
        this.nombre = nomebre;
    }

    public FabricaCoches getCoche() {
        return coche;
    }

    public void setCoche(FabricaCoches coche) {
        this.coche = coche;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
