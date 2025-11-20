package mx.unam.dgtic.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import mx.unam.dgtic.entities.Book;

import java.util.List;

public class BookDAO  implements BookStoreDAO<Book> {

    // Importar EntityManager Y EntityManagerFactory
    private EntityManager em;
    private EntityManagerFactory emf;

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
        Book book = em.find(Book.class, isbn);
        return book;
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
