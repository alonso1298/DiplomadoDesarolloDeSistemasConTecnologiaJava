package dgtic.core.repository;

import dgtic.core.model.dto.producto.ProductoDTO;
import dgtic.core.model.entity.DetalleVenta;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface DetalleVentaRepository extends JpaRepository<DetalleVenta,Long> {
    @Modifying
    @Transactional
    @Query(value="INSERT INTO detalle_venta(id_venta,id_producto,precio_unitario,cantidad) "+
          "VALUES(?1,?2,?3,?4)", nativeQuery = true)
    void saveNative(Long id_venta, Long id_producto, BigDecimal precio, Integer cantidad );
    @Query(value = "SELECT LAST_INSERT_ID()", nativeQuery = true)
    Long getId();
}
