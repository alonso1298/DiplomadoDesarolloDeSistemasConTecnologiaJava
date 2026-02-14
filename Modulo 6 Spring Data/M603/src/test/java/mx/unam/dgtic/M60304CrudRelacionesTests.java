package mx.unam.dgtic;

import mx.unam.dgtic.entity.*;
import mx.unam.dgtic.repository.IAlumnoRepository;
import mx.unam.dgtic.repository.ICalificacionRepository;
import mx.unam.dgtic.repository.IEstadoRepository;
import mx.unam.dgtic.repository.IGrupoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.Optional;

@SpringBootTest
@Transactional
//@Rollback(value = false)
@Commit
public class M60304CrudRelacionesTests {
    final String ALUMNO = "ALONSO SAGRERO GRANADOS";
    private static final String ESTADO = "Guerrero";
    private static final String GRUPO = "Primero";
    private static final Integer ID_GRUPO = 4;
    private static final Integer CALIFICACION = 8;
    private static final String MATRICULA = "1F";
    private static final String MATERIA = "JAVA";

    @Autowired
    IAlumnoRepository repositorioAlumno;
    @Autowired
    IEstadoRepository repositorioEstado;
    @Autowired
    ICalificacionRepository repositorioCalificacion;
    @Autowired
    IGrupoRepository repositorioGrupo;

    @Test
    @DisplayName("Buscar calificaciones por relacion")
    void buscarAlumnoPorRelacionesTest(){
        System.out.println(ALUMNO);
        System.out.println("Crear un alumno ");

        Optional<Alumno> optional = repositorioAlumno.findById(MATRICULA);
        if(optional.isEmpty()){

            Estado estado = repositorioEstado.findByEstado(ESTADO);
            if (estado == null){
                throw new RuntimeException("Estado no localizado");
            }

            Alumno alumno = new Alumno(MATRICULA, "Alonso", "Sagrero",
                    Date.valueOf("1998-12-12"), 1.74, "SAGA981212HDFGRL08");

            alumno.setEstado(estado);
            Perfil perfil = new Perfil();
            perfil.setBiografia("Ingeniero en computacion");
            perfil.setIntereses("Leer, Deporte, Cine");
            perfil.setHabilidades("Poo");

            perfil.setAlumno(alumno);
            alumno.setPerfil(perfil);

            repositorioAlumno.save(alumno);
        }

        System.out.println("Verificar persistencia de alumno");
        optional = repositorioAlumno.findById(MATRICULA);
        if (optional.isPresent()){
            System.out.println("Alumno guardado exitosamente");
            System.out.println(optional.get());
            System.out.println(optional.get().getEstado());
            System.out.println(optional.get().getPerfil());
        }

    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void guardarCalificacionAlumnoTest(){
        System.out.println(ALUMNO);
        // 1:N Alumno -> Calificacion
        Alumno alumno = repositorioAlumno.findById(MATRICULA).orElseThrow();

        Calificacion calificacion = new Calificacion();
        calificacion.setId(100);
        calificacion.setMateria(MATERIA);
        calificacion.setCalificacion(CALIFICACION);
        calificacion.setAlumno(alumno);

        repositorioCalificacion.save(calificacion);
        System.out.println("Calificaciones guardadas del alumno " + alumno.getNombre());
        repositorioCalificacion.findByAlumno(alumno).forEach(c->{
            System.out.println(c.getId() + " " + c.getMateria() + " " + c.getCalificacion());
        });
    }

    @Test
    @Transactional
    @Commit
    public void guardarAlumnoGrupoTest(){
        System.out.println(ALUMNO);
        Alumno alumno = repositorioAlumno.findById(MATRICULA)
                .orElseThrow(()-> new RuntimeException(
                        "No existe el alumno con la matricula " + MATRICULA));
        Grupo grupo = repositorioGrupo.findById(ID_GRUPO)
                .orElseThrow(()-> new RuntimeException(
                        "No existe elgrupo " + ID_GRUPO));

        //Relacion N:N se guarda por ambos lados
        // Sin Helper
        //alumno.getGrupos().add(grupo);
        //grupo.getAlumnos().add(alumno);
        alumno.addGrupos(grupo);
        grupo.addAlumno(alumno);
        //repositorioAlumno.save(alumno);

        System.out.println("Alumno agregado al grupo");
        alumno = repositorioAlumno.findById(MATRICULA)
                .orElseThrow(()-> new RuntimeException(
                        "No existe el alumno con la matricula " + MATRICULA));
        alumno.getGrupos().forEach(System.out::println);
    }

    @Test
    @Transactional
    @Commit
    void eliminar
}
