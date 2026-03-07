package dgtic.core.repository;

import dgtic.core.model.dto.CategoriaDTO;
import dgtic.core.model.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoriaRepository extends JpaRepository<Categoria, Long> {
}
