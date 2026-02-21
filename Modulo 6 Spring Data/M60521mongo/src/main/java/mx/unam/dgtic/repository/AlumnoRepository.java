package mx.unam.dgtic.repository;

import mx.unam.dgtic.datos.Alumno;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface AlumnoRepository extends MongoRepository<Alumno, String> {
	long deleteByMatricula(String matricula);

	List<Alumno>  findByNombre(String nombre);
}
