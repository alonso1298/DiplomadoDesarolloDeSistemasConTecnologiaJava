package unam.diplomado.pixup.usuario.repository;

import unam.diplomado.notificaciones.domain.Notificacion;

public interface INotificacionRepository {
    Notificacion save(Notificacion notificacion);
}
