package dgtic.core.model.dto.cliente;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteDTO {
    private Long id_cliente;

    private String nombre;
    private String email;
    private String telefono;
    private String ciudad;
}
