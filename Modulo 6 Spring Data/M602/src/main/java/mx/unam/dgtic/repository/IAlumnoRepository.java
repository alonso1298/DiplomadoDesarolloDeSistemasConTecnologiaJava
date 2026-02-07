package mx.unam.dgtic.repository;

import mx.unam.dgtic.entity.Alumno;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IAlumnoRepository extends CrudRepository<Alumno, String> {

    // Consultas derivadas
    // SELECT * FROM Alumno a WHERE a.nombre = nombre;
    List<Alumno> findByNombre(String nombre);

    // Ejemplos de nombramiento que realizan la misma consulta
    List<Alumno> queryByNombre(String nombre);
    // Se puede poner un operador logico dentro de la consulta
    List<Alumno> findByNombreEquals(String nombre);
    List<Alumno> getByNombre(String nombre);
    List<Alumno> searchByNombre(String nombre);
    List<Alumno> readByNombre(String nombre);
    // Ignora las mayusculas
    List<Alumno> readByNombreIgnoreCase(String nombre);

    // SELECT COUNT(a) FROM Alumno
    long countByNombre(String nombre);

    List<Alumno> findByNombreNot(String nombre);

    long countByNombreNot(String nombre);


}
