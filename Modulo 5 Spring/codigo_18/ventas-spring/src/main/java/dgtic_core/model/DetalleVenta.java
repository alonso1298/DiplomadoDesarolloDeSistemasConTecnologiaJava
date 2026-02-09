package dgtic_core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetalleVenta {

    private int cantidad;
    private int idDetalle;
    private int idProducto;
    private int idVenta;
    private double precioUnitario;

}
