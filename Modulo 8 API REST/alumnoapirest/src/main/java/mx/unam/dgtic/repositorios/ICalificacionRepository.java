package mx.unam.dgtic.repositorios;

import mx.unam.dgtic.entities.Calificacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICalificacionRepository extends JpaRepository<Calificacion, Long> {
}
