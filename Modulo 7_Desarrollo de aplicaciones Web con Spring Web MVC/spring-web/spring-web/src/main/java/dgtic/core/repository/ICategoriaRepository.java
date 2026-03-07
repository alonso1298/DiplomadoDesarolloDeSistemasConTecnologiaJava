package dgtic.core.repository;

import dgtic.core.model.dto.CategoriaDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoriaRepository extends JpaRepository<CategoriaDTO, Long> {
}
