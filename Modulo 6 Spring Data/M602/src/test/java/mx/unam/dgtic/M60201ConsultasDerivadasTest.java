package mx.unam.dgtic;

import mx.unam.dgtic.entity.Alumno;
import mx.unam.dgtic.repository.IAlumnoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class M60201ConsultasDerivadasTest {

    final String ALUMNO = "SAGRERO GRANADOS ALONSO";
    private static final String NOMBRE = "Nadia";
    private static final String PATERNO = "Calles";
    private static final double ESTATURA = 1.65;
    private static final String FECHA = "2026-02-06";

    @Autowired
    IAlumnoRepository repositorioAlumno;

    @Test
    void buscarPorNombreTest(){
        System.out.println(ALUMNO);
        System.out.println("Buscar por nombre " + NOMBRE);

        Iterable<Alumno> alumnos = repositorioAlumno.findByNombre(NOMBRE);
        alumnos.forEach(System.out::println);

        System.out.println("getByNombre");
        repositorioAlumno.getByNombre(NOMBRE).forEach(a->{
            System.out.println(a.getNombre() + " " + a.getPaterno());
        });

        System.out.println("findByNombreEqual");
        repositorioAlumno.findByNombreEquals(NOMBRE).forEach(a->{
            System.out.println(a.getNombre() + " " + a.getPaterno());
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"CARLOS", "Juan", "Marco", "Gema", "Marco 2"})
    void buscarPorNombreParametroTest(String nombre){
        System.out.println(ALUMNO);
        System.out.println("Buscar por nombre " + nombre);

        System.out.println("Numeor de alumnos con el nombre " + nombre
                + " " + repositorioAlumno.countByNombre(nombre));

        Iterable<Alumno> alumnos = repositorioAlumno.findByNombre(nombre);
        alumnos.forEach(System.out::println);
    }

    @ParameterizedTest
    @ValueSource(strings = {"CARLOS", "Juan", "Marco", "Gema", "Marco 2"})
    void buscarPorNombreNotParametroTest(String nombre){
        System.out.println(ALUMNO);
        System.out.println("Buscar por not nombre " + nombre);

        System.out.println("Numeor de alumnos con el nombre " + nombre
                + " " + repositorioAlumno.countByNombreNot(nombre));

        Iterable<Alumno> alumnos = repositorioAlumno.findByNombreNot(nombre);
        alumnos.forEach(System.out::println);
    }
}
