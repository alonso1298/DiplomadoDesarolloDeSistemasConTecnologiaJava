package unam.diplomado.pixup.usuario.api.dto;

import jakarta.persistence.Column;

public class UsuarioRequestDTO {

    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String password;
    private String email;
    private String rfc;
}
