package dgtic_core.repository;

import dgtic_core.model.DetalleVenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DetalleVentaImpl implements IDetalleVentaDao{

    @Autowired
    DataSource cn;

    @Override
    public List<DetalleVenta> lista() throws SQLException {
        List<DetalleVenta> detalleVentas = new ArrayList<>();
        String sql = "SELECT * FROM detalle_venta";
        PreparedStatement ps = cn.getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            DetalleVenta detalleVenta = DetalleVenta.builder()
                    .cantidad(rs.getInt(1))
                    .idDetalle(rs.getInt(2))
                    .idProducto(rs.getInt(3))
                    .idVenta(rs.getInt(4))
                    .precioUnitario(rs.getDouble(5))
                    .build();
        }
        return detalleVentas;
    }

    @Override
    public void guardar(DetalleVenta detalleVenta) throws SQLException {

    }

    @Override
    public void eliminar(int id) throws SQLException {

    }
}
