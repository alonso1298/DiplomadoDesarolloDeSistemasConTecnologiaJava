package unam.diplomado.pixup.usuario.api.dto;

import jakarta.persistence.Column;

public class UsuarioRequestDTO {

    private String nombre;
    @Column(name = "primer_apellido")
    private String primerApellido;
    @Column(name = "segundo_apellido")
    private String segundoApellido;
    private String password;
    private String email;
    private String rfc;
}
