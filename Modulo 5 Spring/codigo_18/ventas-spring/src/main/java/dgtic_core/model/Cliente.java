package dgtic_core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    private Integer id_cliente;
    private String nombre;
    private String email;
    private String telefono;
    private String ciudad;

}
