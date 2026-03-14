package dgtic.core.service.venta;

import dgtic.core.model.dto.venta.FormularioItemsDTO;
import dgtic.core.model.dto.venta.VentaDTO;
import dgtic.core.model.entity.Venta;

import java.util.List;

public interface VentaService {
    List<VentaDTO> findAll();
    VentaDTO findById(Long id);
    Venta findByIdReturnEntity(Long id);
    VentaDTO save(VentaDTO ventaDTO);
    void deleteById(Long id);
    void registerSale(FormularioItemsDTO formulario);
}
