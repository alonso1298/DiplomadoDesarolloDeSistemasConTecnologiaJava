package unam.diplomado.notificaciones.service;

public interface IEmailSerivce {
    void enviarEmail(String email, String titulo, String mensaje);
}
