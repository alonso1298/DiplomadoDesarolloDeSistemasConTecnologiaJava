package unam.diplomado.pixup.notification.service;

import jakarta.transaction.Transactional;
import unam.diplomado.pixup.notification.domain.Notificacion;

public class NotificacionServiceImpl implements INotificacionService{

    @Override
    @Transactional(Transactional.TxType.SUPPORTS)
    public Notificacion enviarNotificacion(String email) {
        // Implementation
        return null;
    }
}
