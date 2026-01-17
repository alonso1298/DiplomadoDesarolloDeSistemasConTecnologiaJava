package unam.diplomado.notificaciones.service;

public class ServiceUnavailableException extends RuntimeException{

    public ServiceUnavailableException(String servicio){
        super("El servicio: " + servicio + " no se encuentra disponible");
    }
}
