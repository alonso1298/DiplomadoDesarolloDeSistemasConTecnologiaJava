package unam.diplomado.pixup.notification.service;

import unam.diplomado.pixup.notification.domain.Notificacion;

public interface INotificacionService {
    Notificacion enviarNotificacion(String email);
}
