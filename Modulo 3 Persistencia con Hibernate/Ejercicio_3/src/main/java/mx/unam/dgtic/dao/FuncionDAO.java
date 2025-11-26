package mx.unam.dgtic.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import mx.unam.dgtic.entities.Funcion;

import java.util.List;

public class FuncionDAO implements ICineCRUD<Funcion> {

    private final EntityManager em;
    private final EntityManagerFactory emf;

    public FuncionDAO(){
        emf = Persistence.createEntityManagerFactory("cine-pu");
        em = emf.createEntityManager();
    }

    @Override
    public List<Funcion> findAll() {
        em.createQuery("SELECT f FROM Funcion f");
        return List.of();
    }

    @Override
    public Funcion findById(int id) {
        return em.find(Funcion.class, id);
    }

    @Override
    public void save(Funcion funcion) {
        em.persist(funcion);
    }

    @Override
    public void update(Funcion funcion) {
        em.merge(funcion);
    }

    @Override
    public void delete(int id) {
        em.remove(em.find(Funcion.class, id));
    }
}
