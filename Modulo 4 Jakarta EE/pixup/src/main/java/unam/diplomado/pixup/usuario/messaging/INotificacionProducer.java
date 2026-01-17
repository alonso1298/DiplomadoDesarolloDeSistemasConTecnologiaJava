package unam.diplomado.pixup.usuario.messaging;

import jakarta.ejb.Local;

@Local
public interface INotificacionProducer {

    boolean enviarNotificacionAltaUsuario(Integer id, String email);
}
