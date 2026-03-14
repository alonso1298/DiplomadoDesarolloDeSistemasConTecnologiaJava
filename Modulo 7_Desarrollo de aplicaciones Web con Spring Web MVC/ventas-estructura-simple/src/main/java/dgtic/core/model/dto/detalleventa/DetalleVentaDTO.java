package dgtic.core.model.dto.detalleventa;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetalleVentaDTO {
    private Long id_detalleVenta;
    private Long id_producto;
    private Long id_venta;
    private Integer cantidad;
    private BigDecimal precioUnitario;
}
