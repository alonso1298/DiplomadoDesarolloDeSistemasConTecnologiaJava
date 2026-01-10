package unam.diplomado.pixup.usuario.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import unam.diplomado.pixup.usuario.domain.Domicilio;

@ApplicationScoped
public class JpaDomicilioRepository implements IDomicilioRepository{

    @PersistenceContext(unitName = "pixup")
    private EntityManager entityManager;

    @Override
    public Domicilio save(Domicilio domicilio) {
        entityManager.persist(domicilio);
        return domicilio;
    }
}
