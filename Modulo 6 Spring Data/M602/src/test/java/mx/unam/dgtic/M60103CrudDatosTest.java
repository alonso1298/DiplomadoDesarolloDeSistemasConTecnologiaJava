package mx.unam.dgtic;

import mx.unam.dgtic.entity.Alumno;
import mx.unam.dgtic.repository.IAlumnoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class M60103CrudDatosTest {

    final String ALUMNO = "SAGRERO GRANADOS ALONSO";
    final String MATRICULA = "1F";

    @Autowired
    IAlumnoRepository repositorioAlumno;

    @Test
    void eliminarAlumnosTest(){
        System.out.println(ALUMNO);
        System.out.println("Buscar alumno con matrcula " + MATRICULA);

        System.out.println("Nuemero de alumnos antes de la elminiacion "
        + repositorioAlumno.count());

        Optional<Alumno> optional = repositorioAlumno.findById(MATRICULA);
        if (optional.isPresent()){
            System.out.println("Alumno a eliminar");
            System.out.println(optional.get());
            repositorioAlumno.delete(optional.get());
        }else {
            System.out.println(MATRICULA + " no utilizada");
        }

        System.out.println("Eliminar alumno por matricula");
        repositorioAlumno.deleteById("5A");

        System.out.println("Eliminar una lista de matriculas");
        repositorioAlumno.deleteAllById(List.of("V1", "V3", "V5"));

        System.out.println("Nuemro de alumnos despuesde la eliminacion "
        + repositorioAlumno.count());

        repositorioAlumno.findAll().forEach(System.out::println);
    }
}
