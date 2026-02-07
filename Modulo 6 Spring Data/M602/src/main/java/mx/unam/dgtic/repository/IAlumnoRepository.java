package mx.unam.dgtic.repository;

import mx.unam.dgtic.entity.Alumno;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

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

    Stream<Alumno> streamByNombre(String nombre);
    Stream<Alumno> streamByNombreNot(String nombre);

    //Campos
    List<Alumno> findByPaterno(String paterno);
    List<Alumno> findByEstatura(Double estatura);
    List<Alumno> findByFnac(Date fnac);

    //Nulos
    List<Alumno> findByPaternoIsNull();
    List<Alumno> findByPaternoIsNotNull();

    long countByPaternoIsNull();
    long countByPaternoIsNotNull();

    // Operadores logicos
    List<Alumno> findByNombreAndPaterno(String nombre, String paterno);
    List<Alumno> findByNombreOrPaterno(String nombre, String paterno);
    List<Alumno> findByNombreOrPaternoNull(String nombre);
    // nombre OR (paterno AND estatura)
    List<Alumno> findByNombreOrPaternoAndEstatura(String nombre, String paterno, Double estatura);

    long countByNombreAndPaterno(String nombre, String paterno);
    boolean existsByNombreAndPaterno(String nombre, String paterno);

    //Limitar registros
    List<Alumno> findFirstByEstatura(Double estatura);
    List<Alumno> findTopByEstatura(Double estatura);

    //El mas bajo
    List<Alumno> findFirstByOrderByEstatura();
    //El mas alto
    List<Alumno> findFirstByOrderByEstaturaDesc();

    // el mas alto con paterno no nulo
    List<Alumno> findFirstByPaternoIsNotNullOrderByEstaturaDesc();

    //El mas alto que no coincida con NOMBRE
    List<Alumno> findFirstByNombreNotOrderByEstaturaDesc(String nombre);

    // Ver los tres primeros alumnos con paterno no nulo
    List<Alumno> findFirst3ByPaternoIsNotNull();

    // Ver los tres primeros alumnos con paterno no nulo ordenados por nombre
    List<Alumno> findFirst3ByPaternoIsNotNullOrderByNombre();

}
