package dgtic.core.repository;

import dgtic.core.model.dto.ProductoDTO;
import dgtic.core.model.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProductoRepository extends JpaRepository<Producto, Long> {
    @Query("SELECT new dgtic.core.model.dto.ProductoDTO(p.producto_id, p.nombre) "+
    " FROM Producto p WHERE p.categoria.categoria_id=:categoriaId")
    List<ProductoDTO> findProductoByCategoria(@Param("categoriaId") Long categoria);
}
