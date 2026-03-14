package dgtic.core.service.detalleventa;

import dgtic.core.mapping.Mapper;
import dgtic.core.model.dto.detalleventa.DetalleVentaDTO;
import dgtic.core.model.entity.DetalleVenta;
import dgtic.core.model.entity.Producto;
import dgtic.core.model.entity.Venta;
import dgtic.core.repository.DetalleVentaRepository;
import dgtic.core.repository.ProductoRepository;
import dgtic.core.service.producto.ProductoService;
import dgtic.core.service.venta.VentaService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class DetalleVentaServiceImpl implements DetalleVentaService{
    private final DetalleVentaRepository detalleVentaRepository;


    public DetalleVentaServiceImpl(DetalleVentaRepository detalleVentaRepository) {
        this.detalleVentaRepository = detalleVentaRepository;

    }

    @Override
    public void saveNative(Long id_venta, Long id_producto, BigDecimal precio, Integer cantidad) {
        detalleVentaRepository.saveNative(id_venta,id_producto,precio,cantidad);
    }

    @Override
    public Long getId() {
        return detalleVentaRepository.getId();
    }
}
