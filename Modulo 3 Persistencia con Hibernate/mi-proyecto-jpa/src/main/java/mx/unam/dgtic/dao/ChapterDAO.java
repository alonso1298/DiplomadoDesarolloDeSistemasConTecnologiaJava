package mx.unam.dgtic.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import mx.unam.dgtic.entities.Chapter;

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
        return List.of();
    }

    @Override
    public Chapter findById(String isbn) {
        return null;
    }

    @Override
    public void save(Chapter book) {

    }

    @Override
    public void update(Chapter book) {

    }

    @Override
    public void delete(String isbn) {

    }
}
