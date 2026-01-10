package unam.diplomado.pixup.colonia.domain;

public class ColoniaAlreradyExistsException extends RuntimeException {

    public ColoniaAlreradyExistsException(String cp, String nombre) {
        super("La colonia con CP: " + cp + " y Nombre: " + nombre + " ya existe.");
    }

}
