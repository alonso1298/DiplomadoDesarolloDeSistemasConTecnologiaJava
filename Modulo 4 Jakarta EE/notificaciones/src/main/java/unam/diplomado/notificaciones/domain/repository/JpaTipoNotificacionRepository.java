package unam.diplomado.notificaciones.domain.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import unam.diplomado.notificaciones.domain.TipoNotificacion;

import java.util.List;
import java.util.Optional;

public class JpaTipoNotificacionRepository implements ITipoNotificacionRepository{
    @PersistenceContext(unitName="pixup")
    private EntityManager entityManager;

    @Override
    public Optional<TipoNotificacion> findByDescripcion(String descripcion) {
        TypedQuery<TipoNotificacion> query = entityManager.createQuery(
                "SELECT tn FROM TipoNotificacion tn WHERE tn.descripcion = :descripcion",
                TipoNotificacion.class);
        query.setParameter("descripcion", descripcion);
        List<TipoNotificacion> tiposNotificacion = query.getResultList();
        return !tiposNotificacion.isEmpty() ? Optional.of(tiposNotificacion.get(0)) : Optional.empty();
    }
}
