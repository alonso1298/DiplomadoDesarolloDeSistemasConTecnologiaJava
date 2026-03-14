package dgtic.core.repository;

import dgtic.core.model.dto.producto.ProductoDTO;
import dgtic.core.model.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto,Long> {
    @Query("SELECT new dgtic.core.model.dto.producto.ProductoDTO(p.id_producto,p.nombre)" +
            " FROM Producto p WHERE p.nombre LIKE %?1%")
    List<ProductoDTO> findProductoView(String dato);
}
