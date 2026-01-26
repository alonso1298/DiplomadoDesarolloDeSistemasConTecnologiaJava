package unam.diplomado.pixup.disco.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import unam.diplomado.pixup.disco.domain.Disco;

import java.util.Optional;

@ApplicationScoped
public class JpaDiscoRepository implements IDiscoRepository{

    @PersistenceContext(name = "pixup")
    private EntityManager entityManager;

    @Override
    public Disco save(Disco disco) {
        entityManager.persist(disco);
        return disco;
    }

    @Override
    public Optional<Disco> findByTituloAndArtista(String titulo, Integer idArtista) {
        TypedQuery<Disco> query = entityManager.createQuery(
                "SELECT d FROM Disco d WHERE d.titulo = :titulo AND d.artista.id = :idArtista",
                Disco.class
        );
        query.setParameter("titulo", titulo);
        query.setParameter("idArtista", idArtista);
        return query.getResultStream().findFirst();
    }
}
