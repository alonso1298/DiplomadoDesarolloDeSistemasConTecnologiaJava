package mx.unam.dgtic.repository;

import mx.unam.dgtic.entity.Alumno;
import mx.unam.dgtic.entity.Calificacion;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ICalificacionRepository extends CrudRepository<Calificacion, Integer> {

}
