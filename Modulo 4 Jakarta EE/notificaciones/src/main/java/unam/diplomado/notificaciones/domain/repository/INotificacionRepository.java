package unam.diplomado.notificaciones.domain.repository;

import unam.diplomado.notificaciones.domain.Notificacion;

public interface INotificacionRepository {
    Notificacion save(Notificacion notificacion);
}
