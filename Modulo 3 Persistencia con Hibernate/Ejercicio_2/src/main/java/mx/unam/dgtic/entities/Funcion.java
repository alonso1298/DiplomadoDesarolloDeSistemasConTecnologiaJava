package mx.unam.dgtic.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "funciones")
public class Funcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_funcion")
    private int idFuncion;

    @Column(name = "fecha")
    private Date fecha;
    @Column(name = "hora")
    private Date hora;

    @ManyToOne
    @JoinColumn(name = "id_pelicula")
    private int idPelicula;

    @ManyToOne
    @JoinColumn(name = "id_sala")
    private int idSala;

    public Funcion(){}

    public Funcion(Date fecha, Date hora, int idFuncion, int idPelicula, int idSala) {
        this.fecha = fecha;
        this.hora = hora;
        this.idFuncion = idFuncion;
        this.idPelicula = idPelicula;
        this.idSala = idSala;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public int getIdFuncion() {
        return idFuncion;
    }

    public void setIdFuncion(int idFuncion) {
        this.idFuncion = idFuncion;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    @Override
    public String toString() {
        return "Funcion{" +
                "fecha=" + fecha +
                ", hora=" + hora +
                ", idFuncion=" + idFuncion +
                ", idPelicula=" + idPelicula +
                ", idSala=" + idSala +
                '}';
    }
}
