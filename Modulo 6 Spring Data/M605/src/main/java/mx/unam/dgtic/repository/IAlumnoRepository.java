package mx.unam.dgtic.repository;

import mx.unam.dgtic.entity.Alumno;
import mx.unam.dgtic.projection.IConteoPorCampo;
import org.hibernate.type.descriptor.java.VersionJavaType;
import org.springframework.data.jpa.repository.Query;
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

    // Queries Nombradas en el repositorio
    @Query(value = "SELECT TRUNC(AVG(a.estatura), 2) FROM Alumno a")
    Double estaturaPromedio();

    @Query(value = """
        SELECT a FROM Alumno a
        JOIN a.perfil p
        WHERE p.intereses LIKE CONCAT('%', :patron, '%')
        OR p.habilidades LIKE CONCAT('%', :patron, '%')
        """)
    List<Alumno> buscarInteresesHabilidadesAlumnos(@Param("patron") String patron);

    @Query(value = "SELECT DISTINCT a.nombre FROM Alumno a ORDER BY a.nombre")
    List<String> findDistinctNombre();

    @Query(value = "SELECT DISTINCT a.paterno FROM Alumno a ORDER BY a.paterno")
    List<String> findDistinctPaterno();

    //Consultas de grupo
    @Query(value = "SELECT a.nombre AS campo, COUNT(*) AS  conteo " +
            "FROM Alumno a GROUP BY a.nombre ORDER BY 1")
    List<IConteoPorCampo> contarPorNombre();

    @Query(value = """
    SELECT EXTRACT(YEAR FROM a.fnac) AS campo,
           COUNT(a) AS conteo
    FROM Alumno a
    GROUP BY EXTRACT(YEAR FROM a.fnac)
    ORDER BY campo
                """)
    List<IConteoPorCampo> contarPorAnio();

    @Query(value = """
    SELECT SUBSTRING(a.curp, 11, 1) AS campo,
           COUNT(a) AS conteo
    FROM Alumno a
    GROUP BY SUBSTRING(a.curp, 11, 1)
    ORDER BY campo
    """)
    List<IConteoPorCampo> contarPorSexo();

    // Consulta Nombrada Nativa SQL
    @Query(value = """
        SELECT * FROM Alumnos a WHERE REGEXP :regex
        """,
            nativeQuery = true
    )
    List<Alumno> buscarByCurpRegex(@Param("regex") String regex);

    @Query(value = """
        SELECT * FROM Alumnos a WHERE 
                CONCAT(nombre,  ' ', paterno) LIKE '%?%1'
        OR CONCAT(paterno, ' ', nombre) LIKE '%?1%'
        OR CONCAT(SUBSTRING_INDEX(nombre, ' ', 1), ' ', paterno) LIKE '%?%1'
        ODER BY nombre, paterno
        """)
    List<Alumno> buscarPorCombinacionNombreYPaterno(String cadena);
}
