package mx.unam.dgtic.repository;

import mx.unam.dgtic.entity.Alumno;
import mx.unam.dgtic.entity.Estado;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IAlumnoRepository extends CrudRepository<Alumno, String> {
    // Consulta derivada para buscar un alumno por Estado
    // N:1 Alumno -> Estado
    List<Alumno> findByEstado(Estado estado);
    long countByEstado(Estado estado);

    // Cosulta derivada para buscar un alumno por una propiedad de estado
    List<Alumno> findByEstadoEstado(String estado);
    List<Alumno> findByEstadoAbreviatura(String abreviaturaEstado);

    List<Alumno> findByPerfilInteresesLike(String interes);
}
