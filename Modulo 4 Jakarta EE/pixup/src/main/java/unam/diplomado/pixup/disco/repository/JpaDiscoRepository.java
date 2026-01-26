package unam.diplomado.pixup.disco.repository;

import unam.diplomado.pixup.disco.domain.Disco;

import java.util.Optional;

public class JpaDiscoRepository implements IDiscoRepository{
    @Override
    public Disco save(Disco disco) {
        return null;
    }

    @Override
    public Optional<Disco> findByTituloAndArtista(String titulo, Integer idArtista) {
        return Optional.empty();
    }
}
