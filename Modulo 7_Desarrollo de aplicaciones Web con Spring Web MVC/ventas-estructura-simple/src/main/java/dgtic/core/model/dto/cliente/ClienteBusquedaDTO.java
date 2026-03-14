package dgtic.core.model.dto.cliente;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteBusquedaDTO {
    private Long id_cliente;
    private String nombre;

}
