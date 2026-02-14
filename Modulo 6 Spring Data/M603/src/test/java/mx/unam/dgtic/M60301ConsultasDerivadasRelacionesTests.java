package mx.unam.dgtic;

import jakarta.transaction.Transactional;
import mx.unam.dgtic.entity.Estado;
import mx.unam.dgtic.repository.IAlumnoRepository;
import mx.unam.dgtic.repository.IEstadoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class M60301ConsultasDerivadasRelacionesTests {
    final String ALUMNO = "ALONSO SAGRERO GRANADOS";
    private static final String ESTADO = "Guerrero";
    private static final String ESTADOABR = "GRO";
    private static final String INTERES = "Deporte";

    @Autowired
    IAlumnoRepository repositorioAlumno;
    @Autowired
    IEstadoRepository repositorioEstado;

    @Test
    @Transactional
    void buscarAlumnoPorRelacionesTest(){
        System.out.println(ALUMNO);
        System.out.println("Buscar alumnos por el objeto Estado" + ESTADO);

        Estado estado = repositorioEstado.findByEstado(ESTADO);
        System.out.println(estado);
        System.out.println("Numero de alumnos en el estado" + estado.getEstado() +
                " " + repositorioAlumno.countByEstado(estado));
        repositorioAlumno.findByEstado(estado).forEach(System.out::println);

        System.out.println("Buscar alumnos por el objeto Estado" + ESTADO);
        repositorioAlumno.findByEstadoEstado(ESTADO).forEach(System.out::println);

        System.out.println("Alumnos con interes en " + INTERES);
        repositorioAlumno.findByPerfilInteresesLike("%"+INTERES+"%").forEach(
                a->{
                    System.out.println(a.getNombre() + " " + a.getPaterno() +
                            a.getPerfil().getIntereses());
                });
    }
}
