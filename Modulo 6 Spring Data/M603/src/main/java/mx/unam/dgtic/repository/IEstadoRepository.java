package mx.unam.dgtic.repository;

import mx.unam.dgtic.entity.Estado;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IEstadoRepository extends CrudRepository<Estado, Integer> {

    Estado findByEstado(String estado);

    List<Estado> findByEstadoContainig(String contiene);
}
