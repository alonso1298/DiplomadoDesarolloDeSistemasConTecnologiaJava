package unam.diplomado.pixup.disco.domain;

public class DiscoDuplicadoException extends RuntimeException{
    public DiscoDuplicadoException(String titulo, String artista){
        super("El disco: " + titulo + " de: " + artista + " ya existe");
    }
}
