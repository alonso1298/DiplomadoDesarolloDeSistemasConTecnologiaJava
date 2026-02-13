package mx.unam.dgtic.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Estados")
public class Estado {
    @Id
    @Column(name = "id_estado")
    private int idEstado;
    private String estado;
    private String abreviatura;

    public Estado() {
    }

    public Estado(int idEstado, String estado, String abreviatura) {
        this.idEstado = idEstado;
        this.estado = estado;
        this.abreviatura = abreviatura;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    @Override
    public String toString() {
        return "Estado{" +
                "idEstado=" + idEstado +
                ", estado='" + estado + '\'' +
                ", abreviatura='" + abreviatura + '\'' +
                '}';
    }
}
