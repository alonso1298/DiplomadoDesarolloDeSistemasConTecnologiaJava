package mx.unam.dgtic;

import mx.unam.dgtic.repository.IAlumnoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;

@SpringBootTest
public class M60203ConsultasDerivadasPatronesTest {

    final String ALUMNO = "SAGRERO GRANADOS ALONSO";
    private static final String NOMBRE = "Nadia";
    private static final String PATERNO = "Calles";
    private static final Double ESTATURA = 1.65;
    private static final Double ESTATURAMAX = 1.70;
    private static final Date FECHA = Date.valueOf( "2026-01-06");
    private static final String PATRON = "a";

    @Autowired
    IAlumnoRepository repositorioAlumno;

    @Test
    void buscarPatronesTest(){
        System.out.println(ALUMNO);
        System.out.println("Alumnos que le nombre inicia con " + PATRON);
        repositorioAlumno.findByNombreStartingWith(PATRON).forEach(a->{
            System.out.println(a.getNombre());
        });

        System.out.println("Alumnos que le nombre contenga  " + PATRON);
        repositorioAlumno.findByNombreContaining(PATRON).forEach(a->{
            System.out.println(a.getNombre());
        });

        System.out.println("Alumnos que le nombre termina con " + PATRON);
        repositorioAlumno.findByNombreEndingWith(PATRON).forEach(a->{
            System.out.println(a.getNombre());
        });

        System.out.println("Alumnos que no contenga el " + PATRON);
        repositorioAlumno.findByNombreNotLike(PATRON).forEach(a->{
            System.out.println(a.getNombre());
        });

        System.out.println("Alumnos que no contenga el " + PATRON);
        repositorioAlumno.findByNombreLike(PATRON).forEach(a->{
            System.out.println(a.getNombre());
        });
    }

    @Test
    void buscarLikeTest(){

        System.out.println("Alumnos que el nombre inicia con " + PATRON + " - " + PATRON + "%");
        repositorioAlumno.findByNombreLike(PATRON + "%").forEach(a->{
            System.out.println(a.getNombre());
        });
        System.out.println("Alumnos que el nombre contiene " + PATRON + " - " + "%" + PATRON + "%");
        repositorioAlumno.findByNombreLike("%" + PATRON + "%").forEach(a->{
            System.out.println(a.getNombre());
        });
        System.out.println("Alumnos que el nombre termina con " + PATRON + " - " + "%" + PATRON );
        repositorioAlumno.findByNombreLike("%" + PATRON).forEach(a->{
            System.out.println(a.getNombre());
        });
        System.out.println("Alumnos que el nombre NOT contiene " + PATRON + " - " + "%" + PATRON + "%");
        repositorioAlumno.findByNombreLike("%" + PATRON + "%").forEach(a->{
            System.out.println(a.getNombre());
        });
        System.out.println("Alumnos que el contienen en la segunda posicion " + PATRON + " - " + "_" + PATRON + "%");
        repositorioAlumno.findByNombreLike("_" + PATRON + "%").forEach(a->{
            System.out.println(a.getNombre());
        });

        System.out.println("Alumnos con nombre con 6 caracteres " + " - " + "______" );
        repositorioAlumno.findByNombreLike("______").forEach(a->{
            System.out.println(a.getNombre());
        });

        System.out.println("Alumnos con nombre de 5 caracteres y la a en la segunda posicion " + " - " + "_"+PATRON+"___" );
        repositorioAlumno.findByNombreLike("_"+PATRON+"___").forEach(a->{
            System.out.println(a.getNombre());
        });

    }
}
