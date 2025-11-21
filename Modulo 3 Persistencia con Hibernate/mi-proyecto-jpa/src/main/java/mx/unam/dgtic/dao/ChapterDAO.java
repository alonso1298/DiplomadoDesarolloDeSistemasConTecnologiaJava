package mx.unam.dgtic.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import mx.unam.dgtic.entities.Chapter;
import mx.unam.dgtic.entities.Publisher;
import mx.unam.dgtic.entities.pk.ChapterPK;

import java.util.List;

public class ChapterDAO implements BookStoreDAO<Chapter>{

    private final EntityManager em;
    private final EntityManagerFactory emf;

    public ChapterDAO() {
        // Creando un EntityMnager de la configuracion que tengo en persistence.xml
        // Necesitostablecer el nombre de mi presistence unit
        emf = Persistence.createEntityManagerFactory("bookstore-pu");

        //Creando un EntityManager con la configuracion de nuestro persistence unit.
        em = emf.createEntityManager();

    }

    @Override
    public List<Chapter> findAll() {
        em.createQuery("SELECT c FROM Chapter c");
        return List.of();
    }

    @Override
    public Chapter findById(String key) {
        // Divides el String para reconstruir el PK
        String[] parts = key.split(":");
        String isbn = parts[0];
        int number = Integer.parseInt(parts[1]);

        ChapterPK pk = new ChapterPK(isbn, number);
        return em.find(Chapter.class, pk);
    }

    @Override
    public void save(Chapter chapter) {
        em.persist(chapter);
    }

    @Override
    public void update(Chapter chapter) {
        em.merge(chapter);
    }

    @Override
    public void delete(String key) {
        String[] parts = key.split(":");
        String isbn = parts[0];
        int number = Integer.parseInt(parts[1]);

        ChapterPK pk = new ChapterPK(isbn, number);

        Chapter chapter = em.find(Chapter.class, pk);
        if (chapter != null) {
            em.remove(chapter);
        }
    }
}
