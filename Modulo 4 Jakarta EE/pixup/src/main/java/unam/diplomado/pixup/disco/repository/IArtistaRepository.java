package unam.diplomado.pixup.disco.repository;

import java.util.Optional;

public interface IArtistaRepository {
    Optional<Artista> finById(Integer id);
}
