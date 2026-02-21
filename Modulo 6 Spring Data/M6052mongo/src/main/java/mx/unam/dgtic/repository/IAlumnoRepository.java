package mx.unam.dgtic.repository;

import mx.unam.dgtic.document.Alumno;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IAlumnoRepository extends MongoRepository<Alumno, String> {
    
}
