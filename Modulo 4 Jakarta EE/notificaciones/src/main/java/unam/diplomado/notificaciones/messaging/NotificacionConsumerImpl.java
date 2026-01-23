package unam.diplomado.notificaciones.messaging;

import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.MessageDriven;
import jakarta.inject.Inject;
import jakarta.jms.MapMessage;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import lombok.extern.java.Log;
import unam.diplomado.notificaciones.domain.Notificacion;
import unam.diplomado.notificaciones.service.INotificacionService;

import java.util.logging.Level;

@Log
@MessageDriven(
        activationConfig = {
                @ActivationConfigProperty(
                        propertyName="destination", propertyValue="java:/jms/queue/NotificacionQueue"), //Donde toma el mensaje
                @ActivationConfigProperty(
                        propertyName="destinationType", propertyValue="jakarta.jms.Queue") // Como se llama el recurso
        })
public class NotificacionConsumerImpl implements MessageListener {

    @Inject
    private INotificacionService notificacionService;

    @Override
    public void onMessage(Message message) {
        try {
            MapMessage mapMessage = (MapMessage) message;
            Integer isUsuario = mapMessage.getInt("idUsuario");
            String email = mapMessage.getString("email");
            log.info("Mensaje recibido: [idusuario: " + isUsuario + ", email: " + email + "]");
            Notificacion notificacion =
                    notificacionService.enviarNotificacionAltaUsuario(isUsuario, email);
            log.info("Procesado de manera exitosa el mensaje, notificacion generada: " +
                    notificacion);
        }catch (Exception e) {
            log.log(Level.SEVERE, "Error al porocesar el mendaje en NotificacionConsumerImpl", e);
        }

    }
}
