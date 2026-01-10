package unam.diplomado.pixup.repository;

import java.util.Optional;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import unam.diplomado.pixup.colonia.domain.Municipio;

@ApplicationScoped
public class MunicipioRepositoryImpl implements IMunicipioRepositoryImpl {

    @PersistenceContext(unitName = "pixup")
    private EntityManager entityManager;

    @Override
    public Optional<Municipio> findById(Integer id) {
        Municipio municipio = entityManager.find(Municipio.class, id);
        return municipio != null ? Optional.of(municipio) : Optional.empty();
    }

}
