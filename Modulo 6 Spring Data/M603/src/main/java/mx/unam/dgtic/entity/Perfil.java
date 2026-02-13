package mx.unam.dgtic.entity;

import jakarta.persistence.*;

@Entity
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String biografia;
    private String intereses;
    private String habilidades;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "alumno_matricula")
    private Alumno alumno;

    public Perfil(){}

    public Perfil(String biografia, String intereses, String habilidades) {
        this.biografia = biografia;
        this.intereses = intereses;
        this.habilidades = habilidades;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public String getIntereses() {
        return intereses;
    }

    public void setIntereses(String intereses) {
        this.intereses = intereses;
    }

    public String getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(String habilidades) {
        this.habilidades = habilidades;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    @Override
    public String toString() {
        return "Perfil{" +
                "id=" + id +
                ", biografia='" + biografia + '\'' +
                ", intereses='" + intereses + '\'' +
                ", habilidades='" + habilidades + '\'' +
                '}';
    }
}
