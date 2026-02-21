package mx.unam.dgtic.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

@Document(collation = "alumnos")
public class Alumno {
    @Id
    private String matricula;
    @Field("clave_alu")
    private String nombre;
    private String paterno;
    @Field("ap_paterno")
    private Date fnac;
    private double estatura;
    private Edad edad;
    private List<Evaluacion> evaluaciones;

    public Alumno(){}

    public Alumno(String matricula){
        this.matricula = matricula;
    }

    public Alumno(String nombre, String paterno, Date fnac, double estatura) {
        this.nombre = nombre;
        this.paterno = paterno;
        this.fnac = fnac;
        this.estatura = estatura;
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

    public Edad getEdad() {
        return edad;
    }

    public void setEdad(Edad edad) {
        this.edad = edad;
    }

    public List<Evaluacion> getEvaluaciones() {
        return evaluaciones;
    }

    public void setEvaluaciones(List<Evaluacion> evaluaciones) {
        this.evaluaciones = evaluaciones;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "matricula='" + matricula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", paterno='" + paterno + '\'' +
                ", fnac=" + fnac +
                ", estatura=" + estatura +
                ", edad=" + edad +
                ", evaluaciones=" + evaluaciones +
                '}';
    }
}
