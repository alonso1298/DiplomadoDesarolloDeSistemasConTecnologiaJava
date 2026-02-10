package dgtic_core.service;

import dgtic_core.model.DetalleVenta;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@SpringBootTest
@Transactional
public class DetalleVentaTest {

    @Autowired
    DetalleVentaServicio detalleVentaServicio;

    @Test
    void guardarDetalleVentaTest() throws SQLException {
        DetalleVenta detalleVenta = DetalleVenta.builder()
                .idVenta(1)
                .idProducto(1)
                .cantidad(2)
                .precioUnitario(300)
                .build();
        detalleVentaServicio.guardar(detalleVenta);
    }

    @Test
    void eliminarDetalleVentaTest() throws SQLException {
        detalleVentaServicio.eliminar(1);
    }

}
