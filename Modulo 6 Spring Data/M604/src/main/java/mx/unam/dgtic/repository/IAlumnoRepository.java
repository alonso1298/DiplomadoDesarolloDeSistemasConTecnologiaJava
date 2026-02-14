package mx.unam.dgtic.repository;

import mx.unam.dgtic.entity.Alumno;
import mx.unam.dgtic.entity.Estado;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IAlumnoRepository extends CrudRepository<Alumno, String> {
    // Consulta Derivada
    List<Alumno> findByNombre(String nombre);

    // NamedQuery
    List<Alumno> buscarAltos();
}
