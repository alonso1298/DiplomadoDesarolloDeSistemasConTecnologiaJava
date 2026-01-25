package unam.diplomado.pixup.disco.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import unam.diplomado.pixup.disco.domain.Disco;
import unam.diplomado.pixup.disco.domain.Disquera;

import java.util.Optional;

@ApplicationScoped
public class JpaDisqueraRepository implements IDisqueraRepository {

    @PersistenceContext(name = "pixup")
    private EntityManager entityManager;

    @Override
    public Optional<Disquera> finById(Integer id) {
        return Optional.empty();
    }
}
