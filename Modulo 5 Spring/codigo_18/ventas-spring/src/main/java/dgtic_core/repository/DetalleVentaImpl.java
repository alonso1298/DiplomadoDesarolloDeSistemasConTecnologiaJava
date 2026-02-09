package dgtic_core.repository;

import dgtic_core.model.DetalleVenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DetalleVentaImpl implements IDetalleVentaDao{

    @Autowired
    DataSource cn;

    @Override
    public List<DetalleVenta> lista() throws SQLException {
        return List.of();
    }

    @Override
    public void guardar(DetalleVenta detalleVenta) throws SQLException {

    }

    @Override
    public void eliminar(int id) throws SQLException {

    }
}
