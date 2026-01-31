package dgtic_core.repository;

import dgtic_core.model.Producto;

import java.sql.SQLException;
import java.util.List;

public interface IProductoDao {
    List<Producto> lista() throws SecurityException;
    void guardar(Producto producto) throws SQLException;
}
