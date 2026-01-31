package dgtic_core.service;

import dgtic_core.model.Producto;
import dgtic_core.repository.IProductoDao;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class ProductoServicioTest {

    @Mock
    IProductoDao productoDao;

    @InjectMocks
    ProductoServicio productoServicio;

    static ArrayList<Producto> listaProducto = new ArrayList<>();

    @BeforeAll // Se ejecuta una sola vez
    static void estado(){
        Producto producto = Producto.builder()
                .id_producto(1)
                .nombre("Producto 1")
                .precio(234.89)
                .stock(109)
                .build();
        listaProducto.add(producto);
        producto = Producto.builder()
                .id_producto(2)
                .nombre("Producto 2")
                .precio(234.09)
                .stock(18)
                .build();
        listaProducto.add(producto);
    }
    @BeforeEach // Cada que se ejecute un test guarda y lo da
    void inicio() throws SQLException{
        when(productoDao.lista())
                .thenReturn(listaProducto);
        doNothing().when(productoDao).guardar(any(Producto.class));
    }
    @Test
    void lista() throws SQLException{
        assertEquals(2, productoDao.lista().size());
        System.out.println(productoServicio.listar().size());
        verify(productoDao, times(2)).lista();
    }
}