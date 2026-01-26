package unam.diplomado.pixup.disco.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import unam.diplomado.pixup.disco.domain.GeneroMusical;

import java.util.Optional;

@ApplicationScoped
public class JpaGeneroMusical implements IGeneroMusicalRepository{

    @PersistenceContext(name = "pixup")
    private EntityManager entityManager;

    @Override
    public Optional<GeneroMusical> findById(Integer id) {
        GeneroMusical generoMusical = entityManager.find(GeneroMusical.class, id);
        return Optional.ofNullable(generoMusical);
    }
}
