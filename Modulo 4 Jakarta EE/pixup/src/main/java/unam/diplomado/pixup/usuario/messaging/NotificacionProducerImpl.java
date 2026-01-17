package unam.diplomado.pixup.usuario.messaging;

import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import jakarta.jms.*;
import lombok.extern.java.Log;

import java.util.logging.Level;

@Log
@Stateless
public class NotificacionProducerImpl implements INotificacionProducer{

    @Resource(mappedName = "JAVA:/JmsXA")
    private QueueConnectionFactory connectionFactory;

    @Resource(mappedName = "java:/jms/queue/NotificacionQueue")
    private Queue notificacionQueue;

    @Override
    public boolean enviarNotificacionAltaUsuario(Integer id, String email) {
        try (JMSContext context = connectionFactory.createContext()) {
            MapMessage mapMessage = context.createMapMessage();
            mapMessage.setInt("idUsuario", id);
            mapMessage.setString("email", email);
            JMSProducer producer = context.createProducer();
            producer.send(notificacionQueue, mapMessage);
            log.info("Mensaje enviado java:/jms/queue/NotificacionQueue, " + "[idUsuario: " + id + ", email: " + email + "]");
            return true;
        }catch (Exception e){
            log.log(
                    Level.SEVERE,
                    "Error al enviar el mensaje a la cola java:/jms/queue/NotificacionQueue", e);
            return false;
        }
    }
}
