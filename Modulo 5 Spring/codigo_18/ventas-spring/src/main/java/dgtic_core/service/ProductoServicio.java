package dgtic_core.service;

import dgtic_core.model.Producto;
import dgtic_core.repository.IProductoDao;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ProductoServicio {

    private final IProductoDao productoDao;

    public ProductoServicio(IProductoDao productoDao){
        this.productoDao = productoDao;
    }
    public List<Producto> listar() throws SQLException{
        return productoDao.lista();
    }
    public void guarrdar(Producto producto) throws SQLException{
        productoDao.guardar(producto);
    }

}
