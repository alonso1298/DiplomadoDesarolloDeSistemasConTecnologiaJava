package dgtic_core.service;

import dgtic_core.model.Producto;
import dgtic_core.repository.ProductoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ProductoServicio {

    @Autowired
    private final ProductoDao productoDao;

    public ProductoServicio(ProductoDao productoDao){
        this.productoDao = productoDao;
    }

    public List<Producto> listar() throws SQLException{
        return productoDao.lista();
    }
    public void guardar(Producto producto) throws SQLException{
        productoDao.guardar(producto);
    }
    public void actualizar(Producto producto) throws SQLException {
        productoDao.actualizar(producto);
    }
    public void eliminar(int id) throws SQLException{
        productoDao.eliminar(id);
    }

}
