package unam.diplomado.notificaciones.service;

import jakarta.annotation.Resource;
import jakarta.mail.Session;

public class EmailServiceImpl implements IEmailSerivce{

    @Resource(mappedName = "java:bodd/mail/Default")
    private Session mailSession;

    @Override
    public void enviarEmail(String email, String titulo, String mensaje) {
        try {

        }catch (Exception e){
            e.printStackTrace();

        }
    }
}
