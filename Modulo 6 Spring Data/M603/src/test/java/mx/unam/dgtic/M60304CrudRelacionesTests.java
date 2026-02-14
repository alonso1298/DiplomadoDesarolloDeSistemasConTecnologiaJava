package mx.unam.dgtic;

import mx.unam.dgtic.repository.IAlumnoRepository;
import mx.unam.dgtic.repository.IEstadoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class M60304CrudRelacionesTests {
    final String ALUMNO = "ALONSO SAGRERO GRANADOS";
    private static final String ESTADO = "Guerrero";
    private static final String GRUPO = "Primero";
    private static final Integer CALIFICACION = 8;
    private static final String MATRICULA = "1A";
    private static final String MATERIA = "BD";

    @Autowired
    IAlumnoRepository repositorioAlumno;
    @Autowired
    IEstadoRepository repositorioEstado;

    @Test
    @DisplayName("Buscar calificaciones por relacion")
    void buscarAlumnoPorRelacionesTest(){
        System.out.println(ALUMNO);
        System.out.println("Buscar alumnos por Materia" + MATERIA);

        repositorioAlumno.findByCalificacionesMateria(MATERIA).forEach(a->{
            System.out.println(a.getNombre() + " " + a.getPaterno());
        });

        System.out.println("Buscar alumnos por grupo " + GRUPO);
        repositorioAlumno.findByGruposGrupo(GRUPO).forEach(a->{
            System.out.println(a.getNombre() + " " + a.getPaterno());
                }
        );
    }

}
