package unam.diplomado.pixup.usuario.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponseDTO {

    private Integer estatus;
    private String tipo;
    private String mensaje;

}
