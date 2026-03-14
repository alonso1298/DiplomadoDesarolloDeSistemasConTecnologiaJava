package dgtic.core.model.dto.venta;

import dgtic.core.model.dto.cliente.ClienteDTO;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VentaDTO {
    private Long id_venta;

    private Long cliente;

    private BigDecimal total;
    private LocalDate fecha;

    @Override
    public String toString() {
        return "Venta{" +
                ", id_venta=" + id_venta +
                ", fecha=" + fecha +
                ", total=" + total +

                '}';
    }
}
