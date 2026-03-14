package dgtic.core.service.detalleventa;

import dgtic.core.model.dto.detalleventa.DetalleVentaDTO;
import dgtic.core.model.dto.venta.VentaDTO;
import dgtic.core.model.entity.DetalleVenta;

import java.math.BigDecimal;

public interface DetalleVentaService {
   // DetalleVentaDTO save(DetalleVentaDTO detalleVentaDTO);
    void saveNative(Long id_venta, Long id_producto, BigDecimal precio, Integer cantidad );
    Long getId();
}
