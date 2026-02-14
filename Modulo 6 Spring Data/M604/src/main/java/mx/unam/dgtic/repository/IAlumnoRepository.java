package mx.unam.dgtic.repository;

import mx.unam.dgtic.entity.Alumno;
import mx.unam.dgtic.entity.Estado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAlumnoRepository extends CrudRepository<Alumno, String> {
    // Consulta Derivada
    List<Alumno> findByNombre(String nombre);

    // NamedQuery
    List<Alumno> buscarAltos();

    long contarPorEstadoCurp(@Param("codigoEstado") String codigoEstado);
    List<Alumno> buscarPorEstadoCurp(@Param("codigoEstado") String codigoEstado);

    //NamedNativeQuery
    List<Alumno> buscarAltosMayorAlPromedio();

    List<Alumno> buscarSinCalificacion();
    List<Alumno> buscarConReprobacion();

    List<Alumno> buscarEnMultiplesGrupos();
    List<Alumno> buscarGrupoAndEstado(@Param("grupo") String grupo,
                                      @Param("estado") String estado);
}
