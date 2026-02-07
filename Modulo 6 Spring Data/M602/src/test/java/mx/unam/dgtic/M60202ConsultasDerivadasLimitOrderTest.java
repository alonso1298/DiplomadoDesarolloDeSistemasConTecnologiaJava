package mx.unam.dgtic;

import mx.unam.dgtic.repository.IAlumnoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;

@SpringBootTest
public class M60202ConsultasDerivadasLimitOrderTest {

    final String ALUMNO = "SAGRERO GRANADOS ALONSO";
    private static final String NOMBRE = "Nadia";
    private static final String PATERNO = "Calles";
    private static final Double ESTATURA = 1.65;
    private static final Double ESTATURAMAX = 1.70;
    private static final Date FECHA = Date.valueOf("2026-01-06");
    private static final String CADENA = "a";

    @Autowired
    IAlumnoRepository repositorioAlumno;

    @Test
    void limitarConsultaTest() {
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

    @Test
    void buscarOperadoresInBetweenTest() {
        System.out.println("\n");
        System.out.println(ALUMNO);
        System.out.println("Buscar alumnos en una lista de estatura " + Arrays.asList(ESTATURA, 1.68, 1.78));
        repositorioAlumno.findByEstaturaIn(Arrays.asList(ESTATURA, 1.68, 1.78)).forEach(System.out::println);

        System.out.println("Buscar alumnos que no esten lista de estatura " + Arrays.asList(ESTATURA, 1.68, 1.78));
        repositorioAlumno.findByEstaturaNotIn(Arrays.asList(ESTATURA, 1.68, 1.78)).forEach(System.out::println);

        System.out.println("Alumnos en una lista de nombres " + Arrays.asList(NOMBRE, "Carlos", "Javier"));
        repositorioAlumno.findByNombreIn(Arrays.asList(NOMBRE, "Carlos", "Javier")).forEach(System.out::println);

        System.out.println("Alumnos que no esten lista de nombres " + Arrays.asList(NOMBRE, "Carlos", "Javier"));
        repositorioAlumno.findByNombreNotIn(Arrays.asList(NOMBRE, "Carlos", "Javier")).forEach(System.out::println);

        System.out.println("Buscar alumno con estatura entre " + ESTATURA + " y " + ESTATURAMAX);
        repositorioAlumno.findByEstaturaBetweenOrderByEstatura(ESTATURA, ESTATURAMAX).forEach(System.out::println);

       /* System.out.println("Buscar alumno que no tengan estatura entre " + ESTATURA + " y " + ESTATURAMAX);
        repositorioAlumno.findByEstaturaBetweenNotOrderByEstatura(ESTATURA, ESTATURAMAX)
                .forEach(System.out::println);*/

        System.out.println("Buscar alumnos con nombre entre Cecilia y Maria");
        repositorioAlumno.findByNombreBetweenOrderByNombre("Cecilia", "Maria")
                .forEach(System.out::println);

       /* System.out.println("Buscar alumnos que no tengan nombre entre Cecilia y Maria");
        repositorioAlumno.findByNombreNotBetweenOrderByNombre("Cecilia", "Maria")
                .forEach(System.out::println);*/

        System.out.println("\n");
    }

    @Test
    void buscarOperadoresMayorMenorTest() {
        System.out.println("\n");
        System.out.println(ALUMNO);
        System.out.println("Alumnos con Fnac antes de " + FECHA);
        repositorioAlumno.findByFnacBefore(FECHA).forEach(System.out::println);

        System.out.println("Alumnos con Fnac despues de " + FECHA);
        repositorioAlumno.findByFnacAfter(FECHA).forEach(System.out::println);

        System.out.println("Alumnos con estatura Mayor a " + ESTATURA);
        repositorioAlumno.findByEstaturaGreaterThan(ESTATURA).forEach(System.out::println);

        System.out.println("Alumnos con estatura Mayor o Igual a " + ESTATURA);
        repositorioAlumno.findByEstaturaGreaterThanEqual(ESTATURA).forEach(System.out::println);

        System.out.println("Alumnos con estatura Menos a " + ESTATURAMAX);
        repositorioAlumno.findByEstaturaLessThan(ESTATURA).forEach(System.out::println);

        System.out.println("Alumnos con estatura Menor o Igual a " + ESTATURAMAX);
        repositorioAlumno.findByEstaturaLessThanEqual(ESTATURA).forEach(System.out::println);


        System.out.println("\n");
    }
}
