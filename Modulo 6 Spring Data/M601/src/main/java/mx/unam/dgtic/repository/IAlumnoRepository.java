package mx.unam.dgtic.repository;

import mx.unam.dgtic.entity.Alumno;
import org.springframework.data.repository.CrudRepository;

public interface IAlumnoRepository extends CrudRepository<Alumno, String> {
}
