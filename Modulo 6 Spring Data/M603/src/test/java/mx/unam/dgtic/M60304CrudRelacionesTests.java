package mx.unam.dgtic;

import mx.unam.dgtic.entity.Alumno;
import mx.unam.dgtic.entity.Estado;
import mx.unam.dgtic.entity.Perfil;
import mx.unam.dgtic.repository.IAlumnoRepository;
import mx.unam.dgtic.repository.IEstadoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.Optional;

@SpringBootTest
@Transactional
@Rollback(value = false)
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
        System.out.println("Crear un alumno ");

        Estado estado = repositorioEstado.findByEstado(ESTADO);
        if (estado == null){
            throw new RuntimeException("Estado no localizado");
        }
        Alumno alumno = new Alumno("1F", "Alonso", "Sgrero",
                Date.valueOf("1998-12-12"), 1.74, "SAGA981212HDFGRL08");

        alumno.setEstado(estado);
        Perfil perfil = new Perfil();
        perfil.setBiografia("Ingeniero en computacion");
        perfil.setIntereses("Leer, Deporte, Cine");
        perfil.setHabilidades("Poo");

        perfil.setAlumno(alumno);
        alumno.setPerfil(perfil);

        repositorioAlumno.save(alumno);

        System.out.println("Verificar persistencia de alumno");
        Optional<Alumno> optional = repositorioAlumno.findById("1F");
        if (optional.isPresent()){
            System.out.println("Alumno guardado exitosamente");
            System.out.println(optional.get());
            System.out.println(optional.get().getEstado());
            System.out.println(optional.get().getPerfil());
        }

    }

}
