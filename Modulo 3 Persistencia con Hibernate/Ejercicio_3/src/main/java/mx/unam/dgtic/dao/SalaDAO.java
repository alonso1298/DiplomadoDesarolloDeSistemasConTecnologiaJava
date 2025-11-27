package mx.unam.dgtic.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import mx.unam.dgtic.entities.Sala;

import java.util.List;

public class SalaDAO implements ICineCRUD<Sala>{

    private final EntityManager em;
    private final EntityManagerFactory emf;

    public SalaDAO() {
        emf = Persistence.createEntityManagerFactory("cine-pu");
        em = emf.createEntityManager();
    }

    @Override
    public List<Sala> findAll() {
        return em.createQuery("SELECT s FROM Sala s", Sala.class).getResultList();
    }

    @Override
    public Sala findById(int id) {
        return em.find(Sala.class, id);
    }

    @Override
    public void save(Sala sala) {
        em.getTransaction().begin();
        em.persist(sala);
        em.getTransaction().commit();
    }

    @Override
    public void update(Sala sala) {
        em.getTransaction().begin();
        em.merge(sala);
        em.getTransaction().commit();
    }

    @Override
    public void delete(int id) {
        em.getTransaction().begin();
        Sala s = em.find(Sala.class, id);
        if (s != null) em.remove(s);
        em.getTransaction().commit();
    }

    // Consultas JPQL extras

    public List<Sala> buscarPorCapacidadMinima(int capacidad) {
        return em.createQuery(
                        "SELECT s FROM Sala s WHERE s.capacidad >= :capacidad",
                        Sala.class)
                .setParameter("capacidad", capacidad)
                .getResultList();
    }

    public Sala buscarPorNombre(String nombre) {
        return em.createQuery(
                        "SELECT s FROM Sala s WHERE s.nombre = :nombre",
                        Sala.class)
                .setParameter("nombre", nombre)
                .getSingleResult();
    }
}
