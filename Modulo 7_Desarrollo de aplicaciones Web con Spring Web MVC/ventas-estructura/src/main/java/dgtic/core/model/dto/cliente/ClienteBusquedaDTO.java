package dgtic.core.model.dto.cliente;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteBusquedaDTO {
    private Long id_cliente;
    private String nombre;
}
