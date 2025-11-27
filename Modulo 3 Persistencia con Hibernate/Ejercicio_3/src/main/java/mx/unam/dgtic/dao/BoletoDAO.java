package mx.unam.dgtic.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import mx.unam.dgtic.entities.Boleto;

import java.util.List;

public class BoletoDAO implements ICineCRUD<Boleto>{

    private final EntityManager em;
    private final EntityManagerFactory emf;

    public BoletoDAO() {
        emf = Persistence.createEntityManagerFactory("cine-pu");
        em = emf.createEntityManager();
    }

    @Override
    public List<Boleto> findAll() {
        return em.createQuery("SELECT b FROM Boleto b", Boleto.class).getResultList();
    }

    @Override
    public Boleto findById(int id) {
        return em.find(Boleto.class, id);
    }

    @Override
    public void save(Boleto boleto) {
        em.getTransaction().begin();
        em.persist(boleto);
        em.getTransaction().commit();
    }

    @Override
    public void update(Boleto boleto) {
        em.getTransaction().begin();
        em.merge(boleto);
        em.getTransaction().commit();
    }

    @Override
    public void delete(int id) {
        em.getTransaction().begin();
        Boleto b = em.find(Boleto.class, id);
        if (b != null) em.remove(b);
        em.getTransaction().commit();
    }

    // Consultas JPQL Extras

    //Tipo A devuelve asientos A10, A11, A20, etc.
    public List<Boleto> buscarPorTipoAsiento(String tipo) {
        return em.createQuery(
                        "SELECT b FROM Boleto b WHERE b.asiento LIKE :tipo",
                        Boleto.class)
                .setParameter("tipo", tipo + "%")
                .getResultList();
    }
}
