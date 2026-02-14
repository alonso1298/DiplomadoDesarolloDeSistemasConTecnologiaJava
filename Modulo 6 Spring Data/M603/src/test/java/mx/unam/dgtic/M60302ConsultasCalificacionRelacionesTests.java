package mx.unam.dgtic;

import mx.unam.dgtic.entity.Alumno;
import mx.unam.dgtic.entity.Estado;
import mx.unam.dgtic.repository.IAlumnoRepository;
import mx.unam.dgtic.repository.ICalificacionRepository;
import mx.unam.dgtic.repository.IEstadoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootTest
@Transactional
public class M60302ConsultasCalificacionRelacionesTests {
    final String ALUMNO = "ALONSO SAGRERO GRANADOS";
    private static final String ESTADO = "Guerrero";
    private static final String ESTADOABR = "GRO";
    private static final String INTERES = "Deporte";
    private static final String MATERIA = "BD";
    private static final Integer CALIFICACION = 8;
    private static final String MATRICULA = "1A";
    private static final String PATRON = "Pe%";

    @Autowired
    IAlumnoRepository repositorioAlumno;
    @Autowired
    ICalificacionRepository repositorioCalificacion;

    @Test
    @DisplayName("Buscar calificaciones por relacion")
    void buscarAlumnoPorMateriaTest(){
        System.out.println(ALUMNO);
        System.out.println("Calificaciones por materia " + MATERIA);
        repositorioCalificacion.findByMateria(MATERIA).forEach(c->{
            System.out.println(c.getAlumno().getNombre() + " " + c.getAlumno().getPaterno() + " | "
            + " | " + c.getMateria() + " " + c.getCalificacion());
        });

        System.out.println("Buscar calificaciones por valor " + CALIFICACION);
        repositorioCalificacion.findByCalificacion(CALIFICACION).forEach(System.out::println);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Juan", "Carlos", "Gema"})
    void buscarCalificacionPorAlumnoNombre(String nombre){
        System.out.println(ALUMNO);
        System.out.println("Buscar calificacion de " + nombre);
        repositorioCalificacion. findByAlumnoNombre (nombre) . forEach(c ->{
            System.out.println(c.getAlumno().getNombre() + " " + c.getAlumno().getPaterno()
                    + " | " + c.getMateria() + " " + c.getCalificacion());
        });
    }

    @Test
    @DisplayName("Buscar calificacion por objeto Alumno")
    void buscarCalificacionPorAlumno(){
        System.out.println(ALUMNO);
        System.out.println("Buscar calificacion por objeto Alumno");

        Optional<Alumno> optional = repositorioAlumno.findById(MATRICULA);
        if(! optional. isEmpty()) {
            System.out.println(optional.get());
            repositorioCalificacion.findByAlumnoNombre(optional.get().getNombre()).forEach(System.out::println);
        }else {
            System.out.println("Alumng no localizado");
        }
    }
}
