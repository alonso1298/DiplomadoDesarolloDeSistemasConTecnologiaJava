import java.util.Objects;

public class Alumno {
    private String nombre;
    private String matricula;
    private String carrera;

    public Alumno(){

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Alumno alumno)) return false;
        return Objects.equals(getMatricula(), alumno.getMatricula());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getMatricula());
    }

    public int compareTo(Alumno otroAlumno){
        // Queremos hacer una comparacion por valor numerico, no de String
        long numero1;
        long numero2;
        numero1 = Long.parseLong(this.getMatricula());
        numero2 = Long.parseLong(otroAlumno.getMatricula());
        int regreso = 0; // Son iguales por default
        if (numero1 > numero2){
            regreso = 1; // this > otroAlumno
        }else {
            if (numero1 < numero2){
                regreso = -1;  // this < otroAlumno
            }
        }
        return regreso;
        // return this.getMatricula().compareTo(otroAlumno.getMatricula());
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", matricula='" + matricula + '\'' +
                ", carrera='" + carrera + '\'' +
                '}';
    }
}
