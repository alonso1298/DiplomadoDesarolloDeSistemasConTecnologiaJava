package unam.diplomado.notificaciones.domain.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import unam.diplomado.notificaciones.domain.Notificacion;

import java.util.Date;

public class JpaNotificacionRepository implements INotificacionRepository{
    @PersistenceContext(unitName="pixup")
    private EntityManager entityManager;

    @Override
    public Notificacion save(Notificacion notificacion) {
        notificacion.setFechaNotificacion(new Date((System.currentTimeMillis())));
        entityManager.persist(notificacion);
        return notificacion;
    }
}
