package dgtic_core.repository;

import dgtic_core.model.DetalleVenta;

import java.sql.SQLException;
import java.util.List;

public interface DetalleVentaDao {

    List<DetalleVenta> lista() throws SQLException;
    void guardar(DetalleVenta detalleVenta) throws SQLException;
    Integer eliminar(int id) throws SQLException;
}
