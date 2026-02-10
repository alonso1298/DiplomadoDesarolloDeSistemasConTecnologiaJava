package dgtic_core.repository;

import dgtic_core.model.Producto;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface ProductoDao {
    List<Producto> lista() throws SQLException;
    Producto buscarPorId(int id) throws SQLException;
    void guardar(Producto producto) throws SQLException;
    void actualizar(Producto producto) throws SQLException;
    Integer eliminar(int id) throws SQLException;
}
