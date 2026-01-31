package dgtic_core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Venta {

    private Integer id_venta;
    private Cliente cliente;
    private Date fecha;
    private Double total;

}
