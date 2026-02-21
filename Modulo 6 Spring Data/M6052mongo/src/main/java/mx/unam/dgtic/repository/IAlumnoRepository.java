package mx.unam.dgtic.repository;

import mx.unam.dgtic.document.Alumno;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IAlumnoRepository extends MongoRepository<Alumno, String> {
    List<Alumno> findByNombre(String nombre);
    List<Alumno> findByPaterno(String paterno);
}
