package mx.unam.dgtic.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import mx.unam.dgtic.entities.Book;

import java.util.List;

public class BookDAO  implements BookStoreDAO<Book> {

    // Importar EntityManager Y EntityManagerFactory
    private final EntityManager em;
    private final EntityManagerFactory emf;

    public BookDAO(){
        // Creando un EntityMnager de la configuracion que tengo en persistence.xml
        // Necesitostablecer el nombre de mi presistence unit
        emf = Persistence.createEntityManagerFactory("bookstore-pu");

        //Creando un EntityManager con la configuracion de nuestro persistence unit.
        em = emf.createEntityManager();
    }

    @Override
    public List<Book> findAll() {
        // JPQL
        // GQL
        em.createQuery("SELECT b FROM Book b");
        return List.of();
    }

    @Override
    public Book findById(String isbn) {
        return em.find(Book.class, isbn);
    }

    @Override
    public void save(Book book) {
        em.persist(book);
    }

    @Override
    public void update(Book book) {
        em.merge(book);
    }

    @Override
    public void delete(String isbn) {
        em.remove(em.find(Book.class, isbn));
    }
}
