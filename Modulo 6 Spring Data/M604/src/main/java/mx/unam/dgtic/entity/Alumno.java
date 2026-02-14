package mx.unam.dgtic.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Alumnos")
@NamedQuery(name = "Alumno.buscarAltos",
        query = "SELECT a FROM Alumno a WHERE a.estatura >= 1.70" //(JPQL)
        // SELECT * FROM Alumnos WHERE a.estatura >= 1.70 (SQL)
)
public class Alumno {
    @Id
    private String matricula;
    private String nombre;
    private String paterno;
    private Date fnac;
    private double estatura;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado")
    private Estado estado;
    private String curp;
    @OneToMany(mappedBy = "alumno")
    private List<Calificacion> calificaciones = new ArrayList<>();
    @ManyToMany
    @JoinTable(
            name = "Alumnos_Grupos",
            joinColumns = @JoinColumn(name = "matricula", referencedColumnName = "matricula"),
            inverseJoinColumns = @JoinColumn(name = "id_grupo", referencedColumnName = "id_grupo")
    )
    private List<Grupo> grupos = new ArrayList<>();
    @OneToOne(mappedBy = "alumno", cascade = CascadeType.ALL)
    private Perfil perfil;

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Alumno() {
    }

    public Alumno(String matricula) {
        this.matricula = matricula;
    }

    public Alumno(String matricula, String nombre, String paterno, Date fnac, double estatura, String curp) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.paterno = paterno;
        this.fnac = fnac;
        this.estatura = estatura;
        this.curp = curp;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public Date getFnac() {
        return fnac;
    }

    public void setFnac(Date fnac) {
        this.fnac = fnac;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public List<Calificacion> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(List<Calificacion> calificaciones) {
        this.calificaciones = calificaciones;
    }

    public List<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }

    public void addGrupos(Grupo grupo){
        if (!grupos.contains(grupo)){
            grupos.add(grupo);
            grupo.addAlumno(this);
        }
    }

    public void removeGrupo(Grupo grupo){
        if (grupos.contains(grupo)){
            grupos.remove(grupo);
            grupo.removeAlumno(this);
        }
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    @Override
    public String toString() {
        String estadoStr = (getEstado() != null) ? getEstado().getEstado() : "null";
        return "Alumno{" +
                "matricula='" + matricula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", paterno='" + paterno + '\'' +
                ", fnac=" + fnac +
                ", estatura=" + estatura +
                ", estado=" + estadoStr +
                ", curp='" + curp + '\'' +
                '}';
    }
}
