package unam.diplomado.pixup.usuario.domain;

import jakarta.ejb.ApplicationException;

@ApplicationException //Excepocion de negocio y no es encapsulada
public class UsuarioAlreadyExistsException extends RuntimeException{

    public UsuarioAlreadyExistsException(String email){
        super("Ya existe el usuario con el email: " + email);
    }
}
