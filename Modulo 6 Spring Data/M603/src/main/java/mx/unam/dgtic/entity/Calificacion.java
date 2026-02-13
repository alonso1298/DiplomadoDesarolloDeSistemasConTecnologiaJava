package mx.unam.dgtic.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Calificaciones")
public class Calificacion {
    @Id
    private int id;
    private String materia;
    private int calificacion;
    @ManyToOne
    @JoinColumn(name = "alumnos_matricula")
    private Alumno alumno;

    public Calificacion() {
    }

    public Calificacion(int id) {
        this.id = id;
    }

    public Calificacion(int id, String materia, int calificacion) {
        this.id = id;
        this.materia = materia;
        this.calificacion = calificacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    @Override
    public String toString() {
        return "Calificacion{" +
                "id=" + id +
                ", materia='" + materia + '\'' +
                ", calificacion=" + calificacion +
                ", alumno=" + alumno +
                '}';
    }
}
