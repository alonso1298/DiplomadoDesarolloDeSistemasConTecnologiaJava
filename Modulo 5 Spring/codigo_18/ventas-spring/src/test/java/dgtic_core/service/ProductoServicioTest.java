package dgtic_core.service;

import dgtic_core.model.Producto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
@Transactional
class ProductoServicioTest {

    @Autowired
    ProductoServicio productoServicio;

    @Test
    void guardarProductoTest() throws SQLException{
        Producto producto = Producto.builder()
                .nombre("Teclado")
                .precio(700.0)
                .stock(15)
                .build();
        productoServicio.guardar(producto);

        List<Producto> lista = productoServicio.listar();
        assertFalse(lista.isEmpty());
    }

    @Test
    void eliminarProductoTest() throws SQLException {
        productoServicio.eliminar(1);
        List<Producto> lista = productoServicio.listar();
        assertTrue(lista.stream().noneMatch(p -> p.getId_producto() == 1));
    }
}