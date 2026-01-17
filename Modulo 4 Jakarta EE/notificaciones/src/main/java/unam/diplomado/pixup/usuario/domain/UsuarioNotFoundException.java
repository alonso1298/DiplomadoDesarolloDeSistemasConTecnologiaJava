package unam.diplomado.pixup.usuario.domain;

import jakarta.ejb.ApplicationException;

@ApplicationException
public class UsuarioNotFoundException extends RuntimeException {

    public UsuarioNotFoundException(String email) {
        super("No se encontró el usuario con email: " + email);
    }

}

