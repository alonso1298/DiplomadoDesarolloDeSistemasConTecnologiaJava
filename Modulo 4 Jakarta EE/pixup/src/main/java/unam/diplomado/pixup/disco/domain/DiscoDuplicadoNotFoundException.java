package unam.diplomado.pixup.disco.domain;

public class DiscoDuplicadoNotFoundException extends RuntimeException{
    public DiscoDuplicadoNotFoundException(String titulo, String artista){
        super("El disco: " + titulo + " de: " + artista + " ya existe");
    }
}
