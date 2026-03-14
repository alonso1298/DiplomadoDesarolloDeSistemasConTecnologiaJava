package dgtic.core.service.producto;

import dgtic.core.model.dto.producto.ProductoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductoService {
    List<ProductoDTO> findAll();
    ProductoDTO findById(Long id);
    ProductoDTO save(ProductoDTO productoDTO);
    void deleteById(Long id);
    Page<ProductoDTO> findByPage(Pageable pageable);
    List<ProductoDTO> findProductoView(String dato);



}
