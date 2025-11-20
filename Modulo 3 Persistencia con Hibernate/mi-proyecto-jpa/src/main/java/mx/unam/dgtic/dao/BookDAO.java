package mx.unam.dgtic.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class BookDAO  implements BookStoreDAO{

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
    public List findAll() {
        return List.of();
    }

    @Override
    public Object findById(String isbn) {
        return null;
    }

    @Override
    public void save(Object book) {

    }

    @Override
    public void update(Object book) {

    }

    @Override
    public void delete(String isbn) {

    }
}
