package mx.unam.dgtic;

import jakarta.transaction.Transactional;
import mx.unam.dgtic.entity.Alumno;
import mx.unam.dgtic.repository.IAlumnoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

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

    @Test
    @Transactional
    void streamByNombreTest(){
        System.out.println(ALUMNO);
        System.out.println("StreamByNombre");
        try (Stream<Alumno> alumnoStream =
                     repositorioAlumno.streamByNombreNot(NOMBRE)) {
            System.out.println("Alumnos con nombre diferente a " + NOMBRE);
            alumnoStream.forEach(a -> {
                System.out.println("Procesando alumno " + a.getNombre() + " " + a.getPaterno()
                        + " " + a.getMatricula());
            });
            alumnoStream.close();
        }
    }

    @Test
    void buscarPorCamposTest() throws ParseException {
        System.out.println(ALUMNO);
        System.out.println("Buscar por distintos campos");
        System.out.println("Buscar por paterno " + PATERNO);
        repositorioAlumno.findByPaterno(PATERNO).forEach(System.out::println);

        System.out.println("Buscar por estatura " + ESTATURA);
        repositorioAlumno.findByEstatura(ESTATURA).forEach(System.out::println);

        System.out.println("Buscar por Fnac " + FECHA);
        repositorioAlumno.findByFnac(new SimpleDateFormat("yyyy-MM-dd")
                .parse(FECHA)).forEach(System.out::println);
    }

    @Test
    void buscarNulosTest(){
        System.out.println(ALUMNO);
        System.out.println("No. de alumnos que tienen Paterno null "
            + repositorioAlumno.countByPaternoIsNull());
        repositorioAlumno.findByPaternoIsNull().forEach(System.out::println);

        System.out.println("Numero de alumnos que NO tienen Paterno null "
        + repositorioAlumno.countByPaternoIsNotNull());
        repositorioAlumno.findByPaternoIsNotNull().forEach(System.out::println);
    }

    @Test
    void buscarPorNombrePaterno(){
        System.out.println(ALUMNO);
        System.out.println("Busca alumnos nombre, paterno");
        System.out.println("Numero de alumnos con nombre " + NOMBRE + " y paterno " + PATERNO
            + repositorioAlumno.countByNombreAndPaterno(NOMBRE, PATERNO));

        if (repositorioAlumno.existsByNombreAndPaterno(NOMBRE, PATERNO)){
            System.out.println("Existen alumnos con nombre " + NOMBRE + " y paterno " + PATERNO);
        }else {
            System.out.println("NO Existen alumnos con nombre " + NOMBRE + " y paterno " + PATERNO);
        }

        System.out.println("Existen alumnos con nombre " + NOMBRE + " y paterno " + PATERNO
                + repositorioAlumno.existsByNombreAndPaterno(NOMBRE, PATERNO));

        System.out.println("Alumnos con nombre " + NOMBRE + " y paterno " + PATERNO);
        repositorioAlumno.findByNombreOrPaterno(NOMBRE, PATERNO).forEach(System.out::println);

        System.out.println("Alumnos con nombre " + NOMBRE + " o paterno Null");
        repositorioAlumno.findByNombreOrPaternoNull(NOMBRE).forEach(System.out::println);

        System.out.println("Alumnos con nombre " + NOMBRE + " o paterno null " + PATERNO);
        repositorioAlumno.findByNombreOrPaternoAndEstatura(NOMBRE, PATERNO, ESTATURA).forEach(System.out::println);
    }
}
