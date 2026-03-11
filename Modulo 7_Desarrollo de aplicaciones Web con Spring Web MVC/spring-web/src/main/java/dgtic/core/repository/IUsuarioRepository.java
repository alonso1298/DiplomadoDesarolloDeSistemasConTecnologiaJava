package dgtic.core.repository;

import dgtic.core.model.entity.UsuarioBd;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<UsuarioBd, Integer> {
}
