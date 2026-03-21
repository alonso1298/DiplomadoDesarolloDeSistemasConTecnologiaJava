package mx.unam.dgtic.repositories;

import mx.unam.dgtic.entities.Calificacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICalificacionRepository extends JpaRepository<Calificacion, Long> {
}
