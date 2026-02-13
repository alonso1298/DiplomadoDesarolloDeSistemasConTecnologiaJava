package mx.unam.dgtic;

import jakarta.transaction.Transactional;
import mx.unam.dgtic.repository.IAlumnoRepository;
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


    @Test
    @Transactional
    void buscarAlumnoPorRelacionesTest(){
        System.out.println(ALUMNO);
        System.out.println();
    }
}
