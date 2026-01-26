package unam.diplomado.pixup.disco.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import unam.diplomado.pixup.disco.domain.Artista;

import java.util.Optional;

@ApplicationScoped
public class JpaArtistaRepository implements IArtistaRepository{

    @PersistenceContext(name = "pixup")
    private EntityManager entityManager;

    @Override
    public Optional<Artista> findById(Integer id) {
        Artista artista = entityManager.find(Artista.class, id);
        return Optional.ofNullable(artista);
    }
}
