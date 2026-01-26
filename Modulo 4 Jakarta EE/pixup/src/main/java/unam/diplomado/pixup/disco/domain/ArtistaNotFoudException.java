package unam.diplomado.pixup.disco.domain;

public class ArtistaNotFoudException extends RuntimeException{
    public ArtistaNotFoudException(Integer id){
        super("No se encontro Artista con id: " + id);
    }
}
