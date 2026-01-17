package unam.diplomado.pixup.usuario.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegistroUsuarioDTO {

    @NotNull(message = "Domicio es rquerido para registrar al usuario")
    @Valid // Entra al objeto para validar cada uno de los campos
    private DomicilioDTO domicilio;

    @NotNull(message="Usuario es requerido para el registro del usuario")
    @Valid
    private UsuarioRequestDTO usuario;
}
