package unam.diplomado.pixup.disco.repository;

import unam.diplomado.pixup.disco.domain.Artista;

import java.util.Optional;

public interface IArtistaRepository {
    Optional<Artista> finById(Integer id);
}
