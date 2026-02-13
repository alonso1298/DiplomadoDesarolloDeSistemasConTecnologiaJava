package mx.unam.dgtic.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Grupos")
public class Grupo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_grupo")
    protected int id;
    protected String grupo;

    public Grupo(){}

    public Grupo(String grupo) {
        this.grupo = grupo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    @Override
    public String toString() {
        return "Grupo{" +
                "id=" + id +
                ", grupo='" + grupo + '\'' +
                '}';
    }
}
