package mx.unam.dgtic.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import mx.unam.dgtic.entities.Funcion;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class FuncionDAO implements ICineCRUD<Funcion> {

    private final EntityManager em;
    private final EntityManagerFactory emf;

    public FuncionDAO() {
        emf = Persistence.createEntityManagerFactory("cine-pu");
        em = emf.createEntityManager();
    }

    @Override
    public List<Funcion> findAll() {
        return em.createQuery("SELECT f FROM Funcion f", Funcion.class).getResultList();
    }

    @Override
    public Funcion findById(int id) {
        return em.find(Funcion.class, id);
    }

    @Override
    public void save(Funcion funcion) {
        em.getTransaction().begin();
        em.persist(funcion);
        em.getTransaction().commit();
    }

    @Override
    public void update(Funcion funcion) {
        em.getTransaction().begin();
        em.merge(funcion);
        em.getTransaction().commit();
    }

    @Override
    public void delete(int id) {
        em.getTransaction().begin();
        Funcion f = em.find(Funcion.class, id);
        if (f != null) em.remove(f);
        em.getTransaction().commit();
    }

    // Consultas JPQL extras

    public List<Funcion> buscarPorFecha(LocalDate fecha) {
        LocalDateTime inicioDia = fecha.atStartOfDay();
        LocalDateTime finDia = fecha.atTime(23, 59, 59);

        return em.createQuery(
                        "SELECT f FROM Funcion f WHERE f.fecha BETWEEN :inicio AND :fin",
                        Funcion.class
                )
                .setParameter("inicio", inicioDia)
                .setParameter("fin", finDia)
                .getResultList();
    }

    public List<Funcion> buscarPorPelicula(int idPelicula) {
        return em.createQuery(
                        "SELECT f FROM Funcion f WHERE f.idPelicula.idPelicula = :idPelicula",
                        Funcion.class
                )
                .setParameter("idPelicula", idPelicula)
                .getResultList();
    }
}
