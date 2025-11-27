package mx.unam.dgtic.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import mx.unam.dgtic.entities.Pelicula;

import java.util.List;

public class PeliculaDAO implements ICineCRUD<Pelicula> {

    private final EntityManager em;
    private final EntityManagerFactory emf;

    public PeliculaDAO(){
        emf = Persistence.createEntityManagerFactory("cine-pu");
        em = emf.createEntityManager();
    }

    @Override
    public List<Pelicula> findAll() {
        em.createQuery("SELECT c FROM Pelicula c");
        return List.of();
    }

    @Override
    public Pelicula findById(int id) {
        return em.find(Pelicula.class, id);
    }

    @Override
    public void save(Pelicula pelicula) {
        em.persist(pelicula);
    }

    @Override
    public void update(Pelicula pelicula) {
        em.merge(pelicula);
    }

    @Override
    public void delete(int id) {
        em.remove(em.find(Pelicula.class, id));
    }

    // Consultas JPQL extra

    //Buscar una pelicula que sea mayor a X minutos
    public List<Pelicula> findByDuracionMayor (int minutos){
        return em.createQuery(
                "SELECT p FROM Pelicula p WHERE p.duracion > :min", Pelicula.class)
                 .setParameter("min", minutos).getResultList();
    }

    // Buscar pelicula por nombre
    public List<Pelicula> findByName(String titulo){
        return em.createQuery(
                "SELECT p FROM pelicula p WHERE p.titulo LIKE :tit", Pelicula.class)
                .setParameter("tit",  "%" + titulo + "%").getResultList();

    }

    // Buscar películas por clasificación (PG, PG-13, etc.)
    public List<Pelicula> buscarPorClasificacion(String clasificacion) {
        return em.createQuery(
                        "SELECT p FROM Pelicula p WHERE p.clasificacion = :clasificacion",
                        Pelicula.class)
                .setParameter("clasificacion", clasificacion)
                .getResultList();
    }
}
