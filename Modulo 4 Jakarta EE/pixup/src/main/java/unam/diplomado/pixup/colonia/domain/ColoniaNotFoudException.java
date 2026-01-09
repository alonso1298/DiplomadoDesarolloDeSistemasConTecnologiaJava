package unam.diplomado.pixup.colonia.domain;

import jakarta.ejb.ApplicationException;

@ApplicationException //En tiempo de ejecucion los metodos de estos servicios arrojan este error, se dice que no quiere que la encapsules
public class ColoniaNotFoudException extends RuntimeException {

    public ColoniaNotFoudException(Integer id){
        super("No se encontro la colonia con id " + id);
    }
}
