package mx.unam.dgtic.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import mx.unam.dgtic.entities.Publisher;

import java.util.List;

public class PublisherDAO implements BookStoreDAO<Publisher> {

    // Importar EntityManager Y EntityManagerFactory
    private final EntityManager em;
    private final EntityManagerFactory emf;

    public PublisherDAO() {
        // Creando un EntityMnager de la configuracion que tengo en persistence.xml
        // Necesitostablecer el nombre de mi presistence unit
        emf = Persistence.createEntityManagerFactory("bookstore-pu");

        //Creando un EntityManager con la configuracion de nuestro persistence unit.
        em = emf.createEntityManager();

    }

    @Override
    public List<Publisher> findAll() {
        return List.of();
    }

    @Override
    public Publisher findById(String isbn) {
        return null;
    }

    @Override
    public void save(Publisher book) {

    }

    @Override
    public void update(Publisher book) {

    }

    @Override
    public void delete(String isbn) {

    }
}
