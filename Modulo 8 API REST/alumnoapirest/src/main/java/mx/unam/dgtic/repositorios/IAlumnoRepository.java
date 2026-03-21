package mx.unam.dgtic.repositorios;

import mx.unam.dgtic.entities.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAlumnoRepository extends JpaRepository<Alumno, Long> {
}
