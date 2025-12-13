package unam.diplomado.pixup.colonia.domain;

public class ColoniaNotFoudException extends RuntimeException {

    public ColoniaNotFoudException(Integer id){
        super("No se encontro la colonia con id " + id);
    }
}
