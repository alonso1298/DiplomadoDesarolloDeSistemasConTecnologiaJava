package mx.unam.dgtic.repository;

import mx.unam.dgtic.entity.Alumno;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IAlumnoRepository extends CrudRepository<Alumno, String> {

    // Consultas derivadas
    // SELECT * FROM Alumno a WHERE a.nombre = nombre;
    List<Alumno> findByNombre(String nombre);

    // SELECT COUNT(a) FROM Alumno
    long countByNombre(String nombre);


}
