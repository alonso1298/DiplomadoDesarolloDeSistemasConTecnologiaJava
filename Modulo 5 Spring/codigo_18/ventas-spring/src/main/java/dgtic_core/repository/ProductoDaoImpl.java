package dgtic_core.repository;

import dgtic_core.model.Producto;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class ProductoDaoImpl implements IProductoDao{
    @Override
    public List<Producto> lista() throws SecurityException {
        return List.of();
    }

    @Override
    public void guardar(Producto producto) throws SQLException {

    }
}
