package mx.unam.dgtic.repository;

import mx.unam.dgtic.entity.Alumno;
import mx.unam.dgtic.projection.IConteoPorCampo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IAlumnoJpaRepository extends JpaRepository<Alumno, String> {

    Page<Alumno> findByCurpLike(String patron, Pageable pagina);
    Page<Alumno> findByCurpNotLike(String patron, Pageable pagina);

    @Query(
            value = "SELECT DISTINCT a.nombre FROM Alumno a",
            countQuery = "SELECT COUNT(DISTINCT a.nombre) FROM Alumno a"
    )
    Page<String> findDistinctNombre(Pageable pagina);

    @Query(value = "SELECT a.nombre AS campo, COUNT(a) AS conteo " +
            "FROM Alumno a GROUP BY a.nombre",
            countQuery = "SELECT COUNT(DISTINCT a.nombre) FROM Alumno a")
    Page<IConteoPorCampo> contarPorNomabre(Pageable pagina);

    @Query(value = """
        SELECT SUBSTRING(a.curp, 11, 1) AS campo, COUNT(*) AS conteo
        FROM Alumnos a
        GROUP BY campo
        """,
    nativeQuery = true)
    Page<IConteoPorCampo> conteoPorSexo(Pageable pagina);

    @Query(
            value = """
        SELECT a
        FROM Alumno a
        WHERE LOWER(a.nombre) LIKE LOWER(CONCAT('%', :texto, '%'))
           OR LOWER(a.paterno) LIKE LOWER(CONCAT('%', :texto, '%'))
           OR LOWER(CONCAT(a.nombre, ' ', COALESCE(a.paterno, '')))
                LIKE LOWER(CONCAT('%', :texto, '%'))
           OR LOWER(CONCAT(COALESCE(a.paterno, ''), ' ', a.nombre))
                LIKE LOWER(CONCAT('%', :texto, '%'))
        """,
            countQuery = """
        SELECT COUNT(a)
        FROM Alumno a
        WHERE LOWER(a.nombre) LIKE LOWER(CONCAT('%', :texto, '%'))
           OR LOWER(a.paterno) LIKE LOWER(CONCAT('%', :texto, '%'))
           OR LOWER(CONCAT(a.nombre, ' ', COALESCE(a.paterno, '')))
                LIKE LOWER(CONCAT('%', :texto, '%'))
           OR LOWER(CONCAT(COALESCE(a.paterno, ''), ' ', a.nombre))
                LIKE LOWER(CONCAT('%', :texto, '%'))
        """)
    Page<Alumno> buscarPorNombreFlexible(@Param("texto") String texto, Pageable pagina);
}
