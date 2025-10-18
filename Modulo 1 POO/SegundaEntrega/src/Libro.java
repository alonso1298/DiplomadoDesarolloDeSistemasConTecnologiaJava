import java.util.Objects;

public class Libro {
    private String titulo;
    private String autor;
    private int edicion;

    public Libro() {
        this.setTitulo("Sin titulo");
        this.setAutor("Desconocido");
        this.setEdicion(1);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getEdicion() {
        return edicion;
    }

    public void setEdicion(int edicion) {
        this.edicion = edicion;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return Objects.equals(getTitulo(), libro.getTitulo()) && Objects.equals(getAutor(), libro.getAutor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitulo(), getAutor());
    }

    public int compareTo(Libro otrolibro){
        // Un libro esta antes que otro si el nombte es, alfabeticamente, menos que el otro
        // Y que la edicion sea menor (en cado de que los titulos sean iguales)
        int regreso = this.getTitulo().compareTo((otrolibro.getTitulo()));
        if (regreso == 0) // Son uguales los titulos
            if (this.getEdicion() > otrolibro.getEdicion()){
                regreso = 1;
            }else {
                regreso = -1;
            }
        return regreso;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", edicion=" + edicion +
                '}';
    }
}
