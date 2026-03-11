package dgtic.core.repository;

import dgtic.core.model.entity.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICiudadRepository extends JpaRepository<Ciudad, Long> {
    List<Ciudad> findByPaisId (Long id);
}
