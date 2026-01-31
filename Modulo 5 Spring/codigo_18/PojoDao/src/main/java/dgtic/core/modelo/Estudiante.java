package dgtic.core.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Estudiante {

    private String matricula;
    private String nombre;
    private int edad;
    private List<Materia> materias = new ArrayList<>();

    public Estudiante(String matricula, String nombre, int edad) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.edad = edad;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(Materia ... materia) { // ... recibe tantos parametros que necesita
        this.materias = Arrays.asList(materia);
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "matricula='" + matricula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", materias=" + materias +
                '}';
    }
}
