package dgtic_core.repository;

import dgtic_core.model.Venta;

import java.sql.SQLException;
import java.util.List;

public interface IVentaDao {
    List<Venta> listar() throws SQLException;
    Integer guardar(Venta ventas) throws SQLException;
    Integer actualizar(Venta ventas) throws SQLException;
    Integer eliminar(Integer id) throws SQLException;
    Venta consultaId(Integer id) throws SQLException;
}
