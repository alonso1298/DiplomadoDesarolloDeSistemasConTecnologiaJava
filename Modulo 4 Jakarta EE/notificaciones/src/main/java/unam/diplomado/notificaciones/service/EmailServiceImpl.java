package unam.diplomado.notificaciones.service;

import jakarta.annotation.Resource;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Date;

public class EmailServiceImpl implements IEmailSerivce{

    @Resource(mappedName = "java:bodd/mail/Default")
    private Session mailSession;

    @Override
    public void enviarEmail(String email, String titulo, String mensaje) {
        try {
            // Crear Email
            MimeMessage message = new  MimeMessage(mailSession);
            message.setRecipients(MimeMessage.RecipientType.TO,
                    InternetAddress.parse(email, false));
            message.setSubject(titulo);
            message.setContent(mensaje, "text/html");
            message.setSentDate(new Date());
            // Enviar email
            Transport.send(message);
        }catch (Exception e){
            e.printStackTrace();
            throw new ServiceUnavailableException("EmailService");

        }
    }
}
