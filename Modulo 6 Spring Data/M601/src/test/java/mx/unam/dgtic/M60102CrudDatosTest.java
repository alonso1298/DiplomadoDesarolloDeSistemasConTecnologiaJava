package mx.unam.dgtic;

import mx.unam.dgtic.entity.Alumno;
import mx.unam.dgtic.repository.IAlumnoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class M60102CrudDatosTest {

    final String ALUMNO = "SAGRERO GRANADOS ALONSO";
    final String MATRICULA = "1F";

    @Autowired
    IAlumnoRepository repositorioAlumno;

    @Test
    void insertarUnoTest(){
        System.out.println(ALUMNO);
        System.out.println("Insertar un alumno");
        LocalDate fechaLocal = LocalDate.of(1987, 6, 26);
        Date fecha = Date.from(fechaLocal.atStartOfDay(ZoneId.systemDefault()).toInstant());

        Alumno alumno = new Alumno(MATRICULA, "OMAR", "MENDOZA", fecha, 1.50);
        repositorioAlumno.save(alumno);

        if (repositorioAlumno.findById(MATRICULA).isPresent()){
            System.out.println("Alumno localizado en la BD");
            System.out.println(repositorioAlumno.findById(MATRICULA).get());
        }else {
            System.out.println("Alumno no localizado");
        }
    }

    @Test
    void actualizarUnoTest() throws ParseException {
        System.out.println(ALUMNO);
        System.out.println("Actualizar alumno");
        Optional<Alumno> optional = repositorioAlumno.findById(MATRICULA);
        if (optional.isPresent()){
            Alumno a = optional.get();
            System.out.println("Alumno antes del cambio");
            System.out.println(a);

            a.setPaterno("SAGRERO GRANADOS");
            a.setFnac(new SimpleDateFormat("yyyy-MM-dd").parse("1998-12-12"));
            a.setEstatura(1.74);

            repositorioAlumno.save(a);

            System.out.println("Alumno despues del cambio");
            System.out.println(repositorioAlumno.findById(MATRICULA).get());
        }
    }

    @Test
    void insertarVariosTest(){
        System.out.println(ALUMNO);
        System.out.println("Insertar Varios Alumnos");

        List<Alumno> alumnos = new ArrayList<>();
        for (int i = 1; i <= 5; i++){
            alumnos.add(new Alumno("V"+i, "Marco"+i,
                    "Polo "+i, new Date(), 1.70 + i));
        }
        System.out.println("Numero de alumnos despues de la insercion "
        + repositorioAlumno.count());

        repositorioAlumno.saveAll(alumnos);

        System.out.println("NUmero de alumnos antes de insercion " + repositorioAlumno.count());

        System.out.println("Alumnos insetados");
        repositorioAlumno.findAllById(alumnos.stream()
                .map(Alumno::getMatricula).toList())
                .forEach(System.out::println);
    }

    @Test
    void buscarUnoTest(){
        String matricula = "4A";
        System.out.println(ALUMNO);
        System.out.println("Buscar alumno con matrcula " + matricula);

        Optional<Alumno> optional = repositorioAlumno.findById(matricula);
        if (optional.isPresent()){
            Alumno alumno = optional.get();
            System.out.println("Alumno a eliminar");
            System.out.println(alumno);
        }else {
            System.out.println(matricula + " no utilizada");
        }
    }
}
