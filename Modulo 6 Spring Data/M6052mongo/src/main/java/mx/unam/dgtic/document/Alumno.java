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
    private Date fnac;
    private double estatura;
    private Edad edad;
    private List<Evaluacion> evaluaciones;

}
