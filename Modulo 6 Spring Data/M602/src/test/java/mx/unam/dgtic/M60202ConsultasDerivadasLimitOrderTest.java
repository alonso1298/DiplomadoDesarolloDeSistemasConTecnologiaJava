package mx.unam.dgtic;

import jakarta.transaction.Transactional;
import mx.unam.dgtic.entity.Alumno;
import mx.unam.dgtic.repository.IAlumnoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.stream.Stream;

@SpringBootTest
public class M60202ConsultasDerivadasLimitOrderTest {

    final String ALUMNO = "SAGRERO GRANADOS ALONSO";
    private static final String NOMBRE = "Nadia";
    private static final String PATERNO = "Calles";
    private static final Double ESTATURA = 1.65;
    private static final String FECHA = "2026-02-06";

    @Autowired
    IAlumnoRepository repositorioAlumno;

    @Test
    void buscarPorNombreTest() {
        System.out.println(ALUMNO);
        System.out.println("Limitar registros por estatura " + ESTATURA);
        System.out.println("Alumnos con estatura " + ESTATURA);
        repositorioAlumno.findByEstatura(ESTATURA).forEach(System.out::println);

        System.out.println("Primer registro");
        repositorioAlumno.findFirstByEstatura(ESTATURA).forEach(System.out::println);

        System.out.println("Alumno mas alto");
        repositorioAlumno.findFirstByOrderByEstaturaDesc().forEach(System.out::println);

        System.out.println("Alumno mas bajo");
        repositorioAlumno.findFirstByOrderByEstatura().forEach(System.out::println);

        System.out.println("Alumno mas alto con paterno no nulo");
        repositorioAlumno.findFirstByPaternoIsNotNullOrderByEstaturaDesc().forEach(System.out::println);

        System.out.println("Alumno mas alto con nombre diferente a " + NOMBRE);
        repositorioAlumno.findFirstByNombreNotOrderByEstaturaDesc(NOMBRE).forEach(System.out::println);

        System.out.println("Tres primeros alumnos con paterno no nulo");
        repositorioAlumno.findFirst3ByPaternoIsNotNull().forEach(System.out::println);

        System.out.println("Tres primeros alumnos con paterno no nulo ordenados por nombre");
        repositorioAlumno.findFirst3ByPaternoIsNotNullOrderByNombre().forEach(System.out::println);
    }
}
