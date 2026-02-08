package dgtic_core.repository;

import dgtic_core.model.Producto;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface IProductoDao {
    List<Producto> lista() throws SQLException;
    void guardar(Producto producto) throws SQLException;
}
