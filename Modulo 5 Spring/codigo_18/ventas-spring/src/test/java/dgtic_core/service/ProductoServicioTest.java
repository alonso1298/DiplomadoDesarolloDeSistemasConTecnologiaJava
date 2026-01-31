package dgtic_core.service;

import dgtic_core.model.Producto;
import dgtic_core.repository.IProductoDao;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductoServicioTest {

    @Mock
    IProductoDao productoDao;

    @InjectMocks
    ProductoServicio productoServicio;

    static ArrayList<Producto> listaProducto = new ArrayList<>();
}