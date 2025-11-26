package mx.unam.dgtic.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "peliculas")
public class Pelicula {
    @Column(name = "clasificacion")
    private String clasificacion;
    @Column(name = "duracion")
    private int duracion;
    @Id
    @Column(name = "id_pelicula")
    private int idPelicula;
    @Column(name = "titulo")
    private String titulo;

    public Pelicula(){}

    public Pelicula(String clasificacion, int duracion, int idPelicula, String titulo) {
        this.clasificacion = clasificacion;
        this.duracion = duracion;
        this.idPelicula = idPelicula;
        this.titulo = titulo;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Pelicula: " + titulo +
                ", clasificacion: " + clasificacion +
                ", duracion: " + duracion +
                ", idPelicula: " + idPelicula;
    }
}
