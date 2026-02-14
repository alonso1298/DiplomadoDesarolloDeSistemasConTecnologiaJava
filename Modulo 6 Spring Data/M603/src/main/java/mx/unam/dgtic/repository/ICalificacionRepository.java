package mx.unam.dgtic.repository;

import mx.unam.dgtic.entity.Alumno;
import mx.unam.dgtic.entity.Calificacion;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ICalificacionRepository extends CrudRepository<Calificacion, Integer> {

    List<Calificacion> findByMateria(String materia);

    List<Calificacion> findByCalificacion(Integer calificaion);

    //N:1 Calificaion -> Alumno
    List<Calificacion> findByAlumnoMatricula(String matricula);
    List<Calificacion> findByAlumnoNombre(String nombre);
    List<Calificacion> findByAlumnoCurpLike(String patron);

    List<Calificacion> findByAlumno(Alumno alumno);

}
