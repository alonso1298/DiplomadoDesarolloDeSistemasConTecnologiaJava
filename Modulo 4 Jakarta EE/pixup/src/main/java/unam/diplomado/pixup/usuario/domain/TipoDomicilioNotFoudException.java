package unam.diplomado.pixup.usuario.domain;

import jakarta.ejb.ApplicationException;

@ApplicationException
public class TipoDomicilioNotFoudException extends RuntimeException {

    public TipoDomicilioNotFoudException(Integer id){
        super("No se encontro un tipo domicilio con id: " + id);
    }
}
