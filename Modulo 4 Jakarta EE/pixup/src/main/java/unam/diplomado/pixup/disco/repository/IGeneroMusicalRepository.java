package unam.diplomado.pixup.disco.repository;

import java.util.Optional;

public interface IGeneroMusicalRepository {
    Optional<GeneroMusical> findById(Integer id);
}
