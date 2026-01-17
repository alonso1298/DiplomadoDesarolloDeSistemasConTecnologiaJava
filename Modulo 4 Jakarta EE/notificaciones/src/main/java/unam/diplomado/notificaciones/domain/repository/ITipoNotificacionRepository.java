package unam.diplomado.notificaciones.domain.repository;

import unam.diplomado.notificaciones.domain.TipoNotificacion;

import java.util.Optional;

public interface ITipoNotificacionRepository {
    Optional<TipoNotificacion> findByDescripcion(String descripcion);
}
